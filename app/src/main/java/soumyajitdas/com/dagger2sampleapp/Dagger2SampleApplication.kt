package soumyajitdas.com.dagger2sampleapp

import android.app.Application
import android.support.multidex.MultiDex
import soumyajitdas.com.dagger2sampleapp.DI.ApiModule
import soumyajitdas.com.dagger2sampleapp.DI.AppModule
import soumyajitdas.com.dagger2sampleapp.DI.Component.ApiComponent
import soumyajitdas.com.dagger2sampleapp.DI.Component.DaggerApiComponent

class Dagger2SampleApplication : Application() {

    lateinit var mApiComponent: ApiComponent

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        mApiComponent = DaggerApiComponent.builder()
                .appModule(AppModule(this))
                .apiModule(ApiModule("https://reqres.in/"))
                .build()
    }

    fun getApiComponent(): ApiComponent
    {
        return mApiComponent
    }
}