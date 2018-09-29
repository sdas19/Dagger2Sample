package soumyajitdas.com.dagger2sampleapp.DI

import android.app.Application
import dagger.Module
import javax.inject.Singleton
import dagger.Provides


@Module
class AppModule(application: Application) {

    var mApplication: Application = application

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return mApplication
    }

}