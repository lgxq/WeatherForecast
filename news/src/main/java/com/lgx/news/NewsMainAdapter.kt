package com.lgx.news

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.lgx.business.NewsMainTabItem

/**
 * Created by liugaoxin on 2018/9/7.
 * 新闻主页ViewVPager适配器
 */
class NewsMainAdapter(private val mModels: List<NewsMainTabItem>, fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    private val mFragmentList: MutableList<Fragment> = arrayListOf()

    override fun getItem(position: Int): Fragment {
        if(mFragmentList.elementAtOrNull(position) == null) {
            mFragmentList.add(position, NewsItemFragment.getInstance(mModels[position]))
        }

        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mModels.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mModels[position].title
    }
}