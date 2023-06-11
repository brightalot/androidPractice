package com.example.openapipractice

import com.example.openapipractice.data.Library
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

class SeoulOpenApi {
    companion object {
        val DOMAIN = "http://openapi.seoul.go.kr:8088/"
        val API_KEY = "6e6b5a706b627269313134576e4d5157"
    }
}

interface SeoulOpenService {
    //
    @GET("{api_key}/json/SeoulPublicLibraryInfo/1/{end}")
    fun getLibraries (@Path("api_key") key:String, @Path("end") limit:Int) : Call<Library>
}