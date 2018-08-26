package com.lgx.news

import android.view.View
import com.lgx.library.BaseFragment
import com.lgx.library.utils.parseFind

/**
 * Created by liugaoxin on 2018/8/26.
 * 天气首页
 */
class NewsMainFragment: BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_news_main
    }

    override fun initView(rootView: View) {
        parseFind(rootView)
    }
}