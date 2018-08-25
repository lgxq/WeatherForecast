package com.lgx.weatherforecast;

import android.os.Bundle;
import android.support.design.widget.TabLayout
import android.widget.Toast
import com.lgx.library.BaseActivity
import com.lgx.library.utils.BindView
import com.lgx.library.utils.parseFind

/**
 * Created by liugaoxin on 2018/8/20.
 * 主页
 */
class MainActivity: BaseActivity() {
    @BindView(id = R.id.main_tab_layout)
    private lateinit var mTabLayout: TabLayout

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        parseFind(this)

        initTabLayout()
    }

    private fun initTabLayout() {
        mTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                //do nothing
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                //do nothing
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, tab?.text, Toast.LENGTH_SHORT).show()
            }

        })
    }
}
