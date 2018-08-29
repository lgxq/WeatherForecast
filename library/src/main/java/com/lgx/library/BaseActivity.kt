package com.lgx.library

import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by liugaoxin on 2018/8/20.
 * Activity基类
 */
abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = changeOrientation()
        super.onCreate(savedInstanceState)
    }

    //默认竖屏，如果想改为横屏或者可切换，子类重写该方法即可
    //发现坑：如果开启屏幕旋转，并且是横屏状态打开，只在代码中加会先横屏再变回竖屏。。
    open fun changeOrientation(): Int {
        return ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    //新的屏幕适配方案，修改density
    fun setDensity() {
        val metaData = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
        val maxWidth = metaData.metaData.getInt(BaseApplication.KEY_MAX_WIDTH_DP)
        resources.displayMetrics.density = resources.displayMetrics.widthPixels / 1.0f / maxWidth
    }
}