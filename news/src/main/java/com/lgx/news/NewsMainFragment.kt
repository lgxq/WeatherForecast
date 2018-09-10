package com.lgx.news

import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.View
import com.lgx.business.NewsMainTabItem
import com.lgx.library.BaseFragment

/**
 * Created by liugaoxin on 2018/8/26.
 * 天气首页
 */
class NewsMainFragment: BaseFragment() {
    private val mTitles = listOf<String>("推荐", "娱乐", "养生", "视频", "天气", "星座", "奇闻", "情感", "秒懂", "美食", "搞笑", "穿衣", "旅行", "汽车", "小说", "母婴")

    private lateinit var mTabLayout: TabLayout
    private lateinit var mViewPager: ViewPager

    override fun getLayoutId(): Int {
        return R.layout.fragment_news_main
    }

    override fun initView(rootView: View) {
        mTabLayout = rootView.findViewById(R.id.news_main_tab)
        mViewPager = rootView.findViewById(R.id.news_main_content)

        //加载标题
        for (title in mTitles) {
            val tab: TabLayout.Tab = mTabLayout.newTab()
            tab.text = title
            mTabLayout.addTab(tab)
        }

        mViewPager.adapter = NewsMainAdapter(getTestItem(), fragmentManager!!)
        mTabLayout.setupWithViewPager(mViewPager)
    }

    private fun getTestItem(): List<NewsMainTabItem> {
        return (0 until mTitles.size)
                .map { NewsMainTabItem(mTitles[it], it) }
                .toMutableList()
    }
}