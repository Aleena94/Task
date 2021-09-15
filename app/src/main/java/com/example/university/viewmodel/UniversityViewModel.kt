package com.example.university.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.university.model.UniversityListItem
import com.example.university.repository.UniversityRepository
import kotlinx.coroutines.launch

class UniversityViewModel(private val repository: UniversityRepository) : ViewModel() {
    private var uniList: MutableLiveData<List<UniversityListItem>>? = null

    fun getUniList(): LiveData<List<UniversityListItem>>? {
        viewModelScope.launch {
            uniList = repository.getUniList()
        }
        return uniList
    }
}