package com.muhmmad.shoppingapp.api

import com.muhmmad.shoppingapp.model.LoginResponse
import com.muhmmad.shoppingapp.model.ProductsResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitServices {

    @GET("/api/product/getProducts")
    fun getProducts(
        @Body Authorization: String
    ): Call<ProductsResponse>

    @POST("user/login")
    fun login(
        @Body loginInfo: Map<String, String>,
    ): Call<LoginResponse>
}