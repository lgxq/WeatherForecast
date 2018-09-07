package com.lgx.library.utils

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.lgx.library.BaseApplication

/**
 * Created by liugaoxin on 2018/9/7.
 * sp工具类
 */
object SpUtil {
    private var mPreferences: SharedPreferences

    init {
        //sp默认名字用应用包名
        val context: Application = BaseApplication.sApplication
        mPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    fun putData(key: String, value: Any) {
        when(value) {
            is Int -> mPreferences.edit().putInt(key, value).apply()
            is String -> mPreferences.edit().putString(key, value).apply()
            is Float -> mPreferences.edit().putFloat(key, value).apply()
            is Boolean -> mPreferences.edit().putBoolean(key, value).apply()
            is Long -> mPreferences.edit().putLong(key, value).apply()
        }
    }

}