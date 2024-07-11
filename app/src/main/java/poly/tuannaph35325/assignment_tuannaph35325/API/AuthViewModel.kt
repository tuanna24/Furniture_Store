package poly.tuannaph35325.assignment_tuannaph35325.API


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    var authToken : String? = null
        private set
    var errorMessage : String? = null
        private set

    fun register(email: String, password : String, username : String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.register(RegisterRequest(email, password, username))
                authToken = response.token
            } catch (e : Exception) {
                errorMessage = "Đăng ký không thành công: ${e.message}"
            }
        }
    }
    fun login (email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.login(Login(email, password))
            } catch (e : Exception) {
                errorMessage = "Đăng nhập không thành công: ${e.message}"
            }
        }
    }
}