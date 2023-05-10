package com.codingwithze.latihannewsorg.network

import com.codingwithze.latihannewsorg.model.Source
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines/sources")
    fun getAllSources(
        @Query("category") category : String,
        @Query("apikey") apikey : String = "66e22ccf6f414879bd8a6c05e4232de4"
    ) : Call<List<Source>>


}