package com.yj.clothsdemo

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yj.clothsdemo.util.ToastUtils
import com.yj.clothsdemo.util.onClick
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)
        tv_name.text = "姓名：${"银进"}"
        tv_area.text = "区域：${"新都区"}"
        tv_address.text = "小区：${"新都区新新都区新都区新都区新都区新都区"}"
        ll_take_recode.onClick {
            TakeRecodeActivity.start(this)
        }
        ll_put_recode.onClick {
            PutRecodeActivity.start(this)
        }
        ll_phone.onClick {
            callPhone("13551344263")
        }
        img_back.onClick {
            onBackPressed()
        }
    }

    /**
     * 拨打电话（跳转到拨号界面，用户手动点击拨打）
     *
     * @param phoneNum 电话号码
     */
    private fun callPhone(phoneNum: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        val data = Uri.parse("tel:$phoneNum")
        intent.data = data
        startActivity(intent)
    }

    companion object {
        fun start(context: Context?) {
            context?.startActivity(Intent(context, UserInfoActivity::class.java))
        }
    }
}
