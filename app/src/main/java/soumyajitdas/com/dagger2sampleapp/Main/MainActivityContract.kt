package soumyajitdas.com.dagger2sampleapp.Main

interface MainActivityContract {

    interface View
    {
        fun onInitView()
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter
    {
        fun onInitPresenter()
    }
}