package com.lgx.personal

import android.view.View
import com.lgx.library.BaseFragment
import com.lgx.library.utils.parseFind

/**
 * Created by liugaoxin on 2018/8/26.
 * 天气首页
 */
class PersonalMainFragment: BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_personal_main
    }

    override fun initView(rootView: View) {
        parseFind(rootView)
    }
}