package com.example.retrofitdemo

import retrofit2.Response
import retrofit2.http.*


// service interface
interface AlbumService {


    @GET("/albums")
    suspend fun getAlbums():Response<Albums>

    @GET("/albums")
    suspend fun getSortedAlbums(@Query("userId") userId:Int):Response<Albums>


// path parameter to get single object

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path(value = "id") albumId:Int):Response<AlbumsItem>

    @POST(" /albums")
    suspend fun uploadAlbum(@Body album:AlbumsItem):Response<AlbumsItem>


}