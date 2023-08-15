package com.example.project_3.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetYouTubeApi {

    @GET("playlists")
    fun getPlaylist(
    @Query("key") apiKey:String,
    @Query("part") part:String,
    @Query("channelId") channelId:String,
    @Query("maxResults") maxResults:Int
    ):Call<PlaylistModel>
}