package com.lgx.news

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.lgx.business.NewsMainTabItem
import com.lgx.library.BaseFragment

/**
 * Created by liugaoxin on 2018/9/10.
 * 新闻各个tab的页面
 */
class NewsItemFragment: BaseFragment() {
    companion object {
        private val EXTRA_NEWS_ITEM = "extra_news_item"

        fun getInstance(item: NewsMainTabItem): NewsItemFragment {
            val bundle = Bundle()
            bundle.putParcelable(EXTRA_NEWS_ITEM, item)

            val fragment = NewsItemFragment()
            fragment.arguments = bundle

            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_news_item
    }

    override fun initView(rootView: View) {
        val textView: TextView = rootView.findViewById(R.id.test)
        textView.text = arguments?.getParcelable<NewsMainTabItem>(EXTRA_NEWS_ITEM)?.title
    }
}