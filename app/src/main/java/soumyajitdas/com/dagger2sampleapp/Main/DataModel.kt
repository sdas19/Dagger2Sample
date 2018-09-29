package soumyajitdas.com.dagger2sampleapp.Main

class DataModel(
        val page : Int,
        val per_page : Int,
        val total: Int,
        val total_pages : Int,
        val data : List<SingleDataModel>
)

class  SingleDataModel(
        val id: Int,
        val first_name:String,
        val last_name:String,
        val avatar:String
)