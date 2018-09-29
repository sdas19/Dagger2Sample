package soumyajitdas.com.dagger2sampleapp.Main

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import soumyajitdas.com.dagger2sampleapp.ApiClient
import soumyajitdas.com.dagger2sampleapp.Dagger2SampleApplication
import javax.inject.Inject

class MainActivityPresenter(_mainView: MainActivity) : MainActivityContract.Presenter {

    @Inject
    lateinit var retrofit : Retrofit

    val  mainView = _mainView
    val TAG = MainActivityPresenter::class.java.simpleName

    init {
        (mainView.application as Dagger2SampleApplication).getApiComponent().inject(this)
        mainView.onInitView()
        onInitPresenter()
    }

    override fun onInitPresenter() {
        getData()
    }


    fun getData()
    {

        val apiClient = retrofit.create<ApiClient>(ApiClient::class.java)

        val call = apiClient.getData()

        call.enqueue(object :Callback<DataModel> {

            override fun onResponse(call: Call<DataModel>?, response: Response<DataModel>?) {
                mainView.hideProgress()
                if (response != null && response.isSuccessful) {
                    for (model in response.body()!!.data)
                    {
                        Log.e(TAG,model.first_name)
                    }
                } else {
                    Log.e(TAG,"failed in response")

                }
            }

            override fun onFailure(call: Call<DataModel>?, t: Throwable?) {
                Log.e(TAG,"failed in response")
            }
        })
        /*apiClient.getData().
                doOnNext { dataModel ->
                    Log.e(TAG, Thread.currentThread().name)

                }.subscribeOn(Schedulers.io())
                .doOnSubscribe { d ->
                    DisposableManager.add(d)
                    mainView.showProgress()
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {dataModel ->
                    for(singleDataModel in dataModel.data)
                    {
                        Log.e(TAG,singleDataModel.first_name)
                    }
                    Log.e(TAG,Thread.currentThread().name)
                }
                .doOnTerminate {
                    mainView.hideProgress()
                }
                .subscribe()*/

    }
}