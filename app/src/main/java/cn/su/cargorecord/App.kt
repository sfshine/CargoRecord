package cn.su.cargorecord

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho

/**
 * Created by sfshine@qq.com on 2019/2/16 0016.
 */
class App : Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this.applicationContext
        Stetho.initializeWithDefaults(context)
    }
}