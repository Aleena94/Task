package com.example.university.retrofit

import com.example.university.model.UniversityListItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/search")
    fun getUniList(@Query("name") method : String): Call<List<UniversityListItem>?>?

}