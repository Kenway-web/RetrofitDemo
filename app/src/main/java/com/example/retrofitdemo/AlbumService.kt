package com.example.retrofitdemo

import retrofit2.Response
import retrofit2.http.GET


// service interface
interface AlbumService {


    @GET("/albums")
    suspend fun getAlbums():Response<Albums>
}