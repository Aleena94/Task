package com.example.university.di


import com.example.university.repository.UniversityRepository
import com.example.university.retrofit.ApiInterface
import com.example.university.retrofit.RetrofitClient
import com.example.university.viewmodel.UniversityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val netModule = module {

    single { retrofitInstance() }

}

fun retrofitInstance(): RetrofitClient {
    return RetrofitClient
}


val apiInterface = module {
    fun provideUserApi(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }
    single {
        provideUserApi(get())
    }
}

val viewModel = module {
    viewModel { UniversityViewModel(get()) }
}
val repository = module {
    fun spaceRepository(retrofitClient: RetrofitClient): UniversityRepository {
        return UniversityRepository(retrofitClient)
    }
    single { spaceRepository(get()) }

}




