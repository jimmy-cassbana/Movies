package com.jimmy.core_arch.domain

sealed class DataState<out T>(
    val loading: Boolean,
    private val data: T? = null
) {

    fun data(): T? = data

    object Idle : DataState<Nothing>(false)

    class Loading<T>(val cachedData: T? = null) : DataState<T>(
        loading = true,
        data = cachedData
    )

    class Error<T>(val throwable: Throwable) : DataState<T>(
        loading = false,
        data = null
    )

    data class Success<out T>(val data: T) : DataState<T>(
        loading = false,
        data = data
    )
}

fun <T> DataState<List<T>>.isEmptyList(): Boolean {
    return this is DataState.Success && this.data.isNullOrEmpty()
}

fun <T, L> DataState<T>.map(transformer: (T) -> L): DataState<L> {
    return when (this) {
        is DataState.Error -> DataState.Error(throwable)
        DataState.Idle -> DataState.Idle
        is DataState.Loading -> DataState.Loading()
        is DataState.Success -> DataState.Success(transformer(data))
    }
}
