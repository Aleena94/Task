package com.example.university.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.university.model.UniversityListItem
import com.example.university.retrofit.ApiInterface
import com.example.university.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UniversityRepository(private val retrofitClient: RetrofitClient) {
    private val spaceList = MutableLiveData<List<UniversityListItem>>()

    fun getUniList()
            : MutableLiveData<List<UniversityListItem>> {
        val service = retrofitClient.getRetrofitInstance()!!.create(ApiInterface::class.java)
        val call = service.getUniList("middle")
        call!!.enqueue(object : Callback<List<UniversityListItem>?> {
            override fun onFailure(call: Call<List<UniversityListItem>?>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<UniversityListItem>?>,
                response: Response<List<UniversityListItem>?>
            ) {
                Log.v("DEBUG : ", response.body().toString())
                spaceList.postValue(response.body())

            }
        })
        return spaceList
    }
}