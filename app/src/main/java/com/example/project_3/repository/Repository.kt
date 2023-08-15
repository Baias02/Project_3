package com.example.project_3.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.project_3.BuildConfig
import com.example.project_3.data.GetYouTubeApi
import com.example.project_3.data.PlaylistModel
import com.example.project_3.data.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val retrofitClient: GetYouTubeApi by lazy { RetrofitClient.create() }


    fun getPlaylist(): LiveData<PlaylistModel> {
        val data = MutableLiveData<PlaylistModel>()
        retrofitClient.getPlaylist(
            BuildConfig.API_KEY,
            "snippet,contentDetails",
            "UCObk_g1hQBy0RKKriVX_zOQ",
            20
        ).enqueue(object : Callback<PlaylistModel> {
            override fun onResponse(call: Call<PlaylistModel>, response: Response<PlaylistModel>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<PlaylistModel>, t: Throwable) {
                //       Log.e("OLOLO", "onFailure: ${t.message}", )
            }

        })
        return data
    }

//    fun getData(firstname: String, secondName: String): MutableLiveData<LoveModel> {
//        val liveLove = MutableLiveData<LoveModel>()
//        api.getPercentage(firstname, secondName)
//            .enqueue(object : Callback<LoveModel> {
//                override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
//                    if (response.isSuccessful)
//                        liveLove.postValue(response.body())
//                }
//                override fun onFailure(call: Call<LoveModel>, t: Throwable) {
//                    Log.e("ololo", "onFailure: ${t.message}")
//                }
//
//            })
//        return liveLove
//    }
}