package com.lgx.library

import android.annotation.SuppressLint
import android.app.Application

/**
 * Created by liugaoxin on 2018/8/20.
 * application基类
 */

//做为顶部成员，并不需要依附这个类


abstract class BaseApplication: Application() {
    //静态成员两种写法，一个是伴生，一个是顶层成员，区别暂未知
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var sApplication: Application

        //和manifest中的配置要一致
        const val KEY_MAX_WIDTH_DP = "MaxWidthDp"
    }

    override fun onCreate() {
        super.onCreate()

        sApplication = this
    }
}