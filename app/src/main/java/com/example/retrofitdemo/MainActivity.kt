package com.example.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {


    lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView=findViewById(R.id.textview)


        // we need to have a instance of  Service Interface we will create retrofit Instance class
        val retService=RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)

        // using corutine livedata builder we are going to get Retrofit response as livedata

        val responseLiveData:LiveData<Response<Albums>> = liveData {
            val response=retService.getAlbums()
            emit(response)
        }


        responseLiveData.observe(this,Observer{
             val albumsList=it.body()?.listIterator()
            if(albumsList!=null)
            {
                while(albumsList.hasNext())
                {
                    val albumsItem=albumsList.next()
                    val result = " "+"Album Title: ${albumsItem.title}" +"\n"+
                                 " "+"Album id : ${albumsItem.id}" +"\n"+
                                 " "+"User id : ${albumsItem.userId}" +"\n\n\n"

                    textView.append(result)
                }
            }
        })




    }
}