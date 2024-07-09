package com.example.nerkhearzapp.view

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("test.json")
    fun getData() : Call<String>
}