package poly.tuannaph35325.assignment_tuannaph35325.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

data class RegisterRequest(val email: String, val password: String, val username: String)
data class AuthResponse(val token: String)

data class Login(val email: String, val password: String)

// API
interface AuthService {
    @POST("register")
    suspend fun register(@Body request: RegisterRequest): AuthResponse

    @POST("login")
    suspend fun login(@Body request: Login) : AuthResponse
}

object RetrofitInstance {
    val api : AuthService by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.24.14.38:3000/")  // Thay thế bằng URL API của bạn
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthService::class.java)
    }
}