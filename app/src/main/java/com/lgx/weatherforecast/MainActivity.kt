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
        private const val TAG_FORECAST: String = "tag_forecast"
        private const val TAG_NEWS: String = "tag_news"
        private const val TAG_PERSONAL: String = "tag_personal"
        //按页面顺序
        val mList = listOf(TAG_FORECAST, TAG_NEWS, TAG_PERSONAL)
    }

    @BindView(id = R.id.main_navigation_view)
    private lateinit var mNavigation: BottomNavigationView

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        parseFind(this)

        initTabLayout()
        onTabChange(TAG_FORECAST)
    }

    private fun initTabLayout() {
        mNavigation.setOnNavigationItemSelectedListener { item ->
            val tag = when(item.itemId) {
                R.id.main_tab_weather -> TAG_FORECAST
                R.id.main_tab_news -> TAG_NEWS
                R.id.main_tab_personal -> TAG_PERSONAL
                else -> TAG_FORECAST
            }

            onTabChange(tag)
            true
        }
    }

    //切换tab
    private fun onTabChange(tabTag: String) {
        var fragment: Fragment? = supportFragmentManager.findFragmentByTag(tabTag)
        val transaction = supportFragmentManager.beginTransaction()

        if(fragment == null) {
            fragment = when(tabTag) {
                TAG_FORECAST -> ForecastMainFragment()
                TAG_NEWS -> NewsMainFragment()
                TAG_PERSONAL -> PersonalMainFragment()
                else -> throw IllegalAccessException("not have such fragment")
            }

            transaction.add(R.id.main_content, fragment, tabTag)
        }

        //隐藏所有fragment
        mList.map { supportFragmentManager.findFragmentByTag(it) }
                .filter { it != null && !it.isHidden }
                .forEach { transaction.hide(it) }

        transaction.show(fragment).commit()
    }
}