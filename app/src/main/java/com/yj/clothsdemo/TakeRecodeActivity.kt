package com.yj.clothsdemo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.yj.clothsdemo.adapter.TakeRecodeAdapter
import com.yj.clothsdemo.util.ToastUtils
import com.yj.clothsdemo.util.onClick
import com.yj.clothsdemo.util.threadSwitch
import com.yj.service.UserClient
import com.yj.service.response.TakeBean
import com.yj.service.response.TakeRecodeEntity
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_take_recode.*

class TakeRecodeActivity : AppCompatActivity() {

    private val takeRecodeAdapter by lazy {
        TakeRecodeAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_recode)
        refreshData(false)
        recycle_view.apply {
            layoutManager = LinearLayoutManager(this@TakeRecodeActivity)
            adapter = takeRecodeAdapter
        }
        img_back.onClick {
            onBackPressed()
        }
        tv_all.onClick {
            refreshData(true)
        }
        tv_time.onClick {
            refreshData(false)
        }
    }

    private fun refreshData(isAll: Boolean) {
        (application as App)
                .client
                .clothsService
                .takeRecode("appApi.TakeRecord", UserClient.userEntity?.list?.token ?: "")
                .threadSwitch()
                .subscribe(object : Observer<TakeRecodeEntity> {
                    override fun onComplete() {

                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: TakeRecodeEntity) {
                        takeRecodeAdapter.setNewData(t.list?: arrayListOf())
                    }

                    override fun onError(e: Throwable) {
                        ToastUtils.show(applicationContext, "获取失败")
                    }

                })

    }
    companion object {
        fun start(context: Context) {
            context?.startActivity(Intent(context, TakeRecodeActivity::class.java))
        }
    }
}
