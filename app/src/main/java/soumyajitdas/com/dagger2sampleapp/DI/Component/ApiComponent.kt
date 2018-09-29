package soumyajitdas.com.dagger2sampleapp.DI.Component

import dagger.Component
import soumyajitdas.com.dagger2sampleapp.Main.MainActivityPresenter
import soumyajitdas.com.dagger2sampleapp.DI.ApiModule
import soumyajitdas.com.dagger2sampleapp.DI.AppModule
import soumyajitdas.com.dagger2sampleapp.Main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (ApiModule::class)])
interface ApiComponent {

    fun inject(mainActivityPresenter: MainActivityPresenter)

    fun inject(mainActivity: MainActivity)
}