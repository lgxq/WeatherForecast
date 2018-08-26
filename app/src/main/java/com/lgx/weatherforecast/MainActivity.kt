package com.lgx.weatherforecast

import android.os.Bundle
import android.support.design.widget.TabLayout
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

    @BindView(id = R.id.main_tab_layout)
    private lateinit var mTabLayout: TabLayout

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        parseFind(this)

        initTabLayout()
        onTabChange(TAG_FORECAST)
    }

    private fun initTabLayout() {
        mTabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                //do nothing
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                //do nothing
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
               onTabChange(mList[mTabLayout.selectedTabPosition])
            }

        })
    }

    private fun onTabChange(tabTag: String) {
        var fragment: Fragment? = supportFragmentManager.findFragmentByTag(tabTag)
        if(fragment == null) {
            fragment = when(tabTag) {
                TAG_FORECAST -> ForecastMainFragment()
                TAG_NEWS -> NewsMainFragment()
                TAG_PERSONAL -> PersonalMainFragment()
                else -> throw IllegalAccessException("not have such fragment")
            }
            supportFragmentManager.beginTransaction().add(R.id.main_content, fragment, tabTag).commit()
        }

        hideAllFragment()
        supportFragmentManager.beginTransaction().show(fragment).commit()
    }

    private fun hideAllFragment() {
        for (tag in mList) {
            val fragment: Fragment? = supportFragmentManager.findFragmentByTag(tag)
            if(fragment != null && !fragment.isHidden) {
                supportFragmentManager.beginTransaction().hide(fragment).commit()
            }
        }
    }
}