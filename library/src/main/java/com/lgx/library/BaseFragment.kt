package com.lgx.library

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by liugaoxin on 2018/8/26.
 * fragment基类
 */
abstract class BaseFragment: Fragment() {
    private lateinit var mToast: Toast

    abstract fun getLayoutId(): Int
    abstract fun initView(rootView: View)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(getLayoutId(), container, false)
        initView(view)
        return view
    }


    fun toast(message: String) {
        if(mToast == null) {
            mToast = Toast.makeText(activity, "", Toast.LENGTH_SHORT)
        }

        mToast.setText(message)
        mToast.show()
    }

    fun jumpActivity(clazz: Class<*>) {
        startActivity(Intent(activity, clazz))
    }
}