package soumyajitdas.com.dagger2sampleapp.Main

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import soumyajitdas.com.dagger2sampleapp.Dagger2SampleApplication
import soumyajitdas.com.dagger2sampleapp.R
import javax.inject.Inject

class MainActivity : AppCompatActivity() , MainActivityContract.View{

    lateinit var progressDialog: ProgressDialog
    lateinit var mainActivityPresenter: MainActivityPresenter

    @Inject
    lateinit var retrofit: Retrofit

    @Inject
    lateinit var okHttpClient: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as Dagger2SampleApplication).getApiComponent().inject(this)
        mainActivityPresenter = MainActivityPresenter(this)
    }

    override fun onInitView() {
        progressDialog =  ProgressDialog(this)
        showProgress()
    }



    override fun showProgress() {
        progressDialog.setMessage("Loading, please wait.")
        progressDialog.show()
    }

    override fun hideProgress() {
        if(progressDialog.isShowing)
        {
            progressDialog.dismiss()
        }
    }
}
