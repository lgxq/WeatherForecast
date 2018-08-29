package com.lgx.weatherforecast

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import com.lgx.forecast.ForecastMainFragment
import com.lgx.library.BaseActivity
import com.lgx.library.utils.BindView
import com.lgx.library.utils.parseFind
import com.lgx.news.NewsMainFragment
import com.lgx.personal.PersonalMainFragment

/**
 * Created by liugaoxin on 2018/8/20.
 * 主页
 */
class MainActivity: BaseActivity() {
    companion object {
        private const val EXTRA_KEY_SELECT_ID = "extra_select_id"
        private const val TAG_FORECAST: String = "tag_forecast"
        private const val TAG_NEWS: String = "tag_news"
        private const val TAG_PERSONAL: String = "tag_personal"
        //按页面顺序放入集合
        val mList = listOf(TAG_FORECAST, TAG_NEWS, TAG_PERSONAL)
    }

    @BindView(id = R.id.main_navigation_view)
    private lateinit var mNavigation: BottomNavigationView

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //新的UI适配方案，只需要设置一次就行，但是在application中设置无效
        setDensity()

        setContentView(R.layout.activity_main)
        parseFind(this)
        initView()

        //保证页面被销毁重建时对应正确的fragment
        if(savedInstanceState == null) {
            onTabChange(TAG_FORECAST)
        } else {
            onTabChange(savedInstanceState.getInt(EXTRA_KEY_SELECT_ID))
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putInt(EXTRA_KEY_SELECT_ID, mNavigation.selectedItemId)
        super.onSaveInstanceState(outState)
    }

    private fun initView() {
        mNavigation.setOnNavigationItemSelectedListener { item ->
            onTabChange(item.itemId)
            true
        }
    }

    //切换fragment
    private fun onTabChange(id: Int) {
        //根据id获取对应tag
        val tag = when(id) {
            R.id.main_tab_weather -> TAG_FORECAST
            R.id.main_tab_news -> TAG_NEWS
            R.id.main_tab_personal -> TAG_PERSONAL
            else -> TAG_FORECAST
        }

        onTabChange(tag)
    }

    //find or create fragment
    private fun onTabChange(tag: String) {
        var fragment: Fragment? = supportFragmentManager.findFragmentByTag(tag)
        val transaction = supportFragmentManager.beginTransaction()

        if(fragment == null) {
            fragment = when(tag) {
                TAG_FORECAST -> ForecastMainFragment()
                TAG_NEWS -> NewsMainFragment()
                TAG_PERSONAL -> PersonalMainFragment()
                else -> throw IllegalAccessException("not have such fragment")
            }

            transaction.add(R.id.main_content, fragment, tag)
        }

        //隐藏所有fragment
        mList.map { supportFragmentManager.findFragmentByTag(it) }
                .filter { it != null && !it.isHidden }
                .forEach { transaction.hide(it) }

        transaction.show(fragment).commit()
    }
}