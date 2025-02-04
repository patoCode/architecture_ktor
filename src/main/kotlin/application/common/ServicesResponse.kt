package f5.application.common

sealed class ServicesResponse<out T> {
    data class Success<T>(val data: T) : ServicesResponse<T>()
    data class Error(val message: String) : ServicesResponse<Nothing>()
}