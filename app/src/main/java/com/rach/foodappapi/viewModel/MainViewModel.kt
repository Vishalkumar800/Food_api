package com.rach.foodappapi.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rach.foodappapi.api.recipeService
import com.rach.foodappapi.dataClass.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {

    private val _selectedCategory = MutableStateFlow<Category?>(null)
    val selectedCategory:StateFlow<Category?> = _selectedCategory

    private val _categoriesState = MutableStateFlow(RecipeState())
    val categoriesState:StateFlow<RecipeState> = _categoriesState

    data class RecipeState(
        val loading:Boolean = false,
        val list:List<Category> = emptyList(),
        val error:String? = null
    )

    init {
        fetchCategories()
    }

    private fun fetchCategories(){
        viewModelScope.launch {
            _categoriesState.value = _categoriesState.value.copy(loading = true)
            try {

                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )

            }catch (e:Exception){

                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )

            }
        }
    }

    fun selectCategory(category: Category){
        _selectedCategory.value = category
    }





}