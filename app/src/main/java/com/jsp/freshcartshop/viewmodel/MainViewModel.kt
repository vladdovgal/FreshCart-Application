package com.jsp.freshcartshop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jsp.freshcartshop.data.repository.FreshCartRepositoryImpl
import com.jsp.freshcartshop.model.CartItem
import com.jsp.freshcartshop.model.Category
import com.jsp.freshcartshop.model.Product
import com.jsp.freshcartshop.model.Promotion
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class MainViewModel : BaseViewModel() {

    private val freshCartRepository by inject(FreshCartRepositoryImpl::class.java)

    val productList = MutableLiveData<List<Product>>()
    val filteredProductList = MutableLiveData<List<Product>>()
    val categoryList = MutableLiveData<List<Category>>()
    val product = MutableLiveData<Product>()
    val searchValue = MutableLiveData<String>()
    val orderedItems = MutableLiveData<MutableList<CartItem>>()
    var mainPromotionList = MutableLiveData<List<Promotion>>()
    var searchPromotionList = MutableLiveData<List<Promotion>>()
    val isLoaded = MutableLiveData<Boolean>()

    init {
        orderedItems.value = mutableListOf()
    }

    fun loadProducts() {
        viewModelScope.launch {
            try {
                isLoading.postValue(true)
                val response = freshCartRepository.getProducts()
                productList.value = response
                isLoaded.postValue(true)
                errorMessageData.postValue(null)
            } catch (e: Exception) {
                e.printStackTrace()
                errorMessageData.postValue(e.message)
            } finally {
                isLoading.postValue(false)
            }
        }
    }

    fun findProducts() {
        viewModelScope.launch {
            try {
                isLoading.postValue(true)
                searchValue.value?.let {
                    val response = freshCartRepository.findProducts(it)
                    filteredProductList.value = response
                }
                isLoaded.postValue(true)
                errorMessageData.postValue(null)
            } catch (e: Exception) {
                e.printStackTrace()
                errorMessageData.postValue(e.message)
            } finally {
                isLoading.postValue(false)
            }
        }
    }

    fun loadProduct(id : Long) {
        viewModelScope.launch {
            try {
                isLoading.postValue(true)
                val response = freshCartRepository.getProductById(id)
                product.value = response
                isLoaded.postValue(true)
                errorMessageData.postValue(null)
            } catch (e: Exception) {
                e.printStackTrace()
                errorMessageData.postValue(e.message)
            } finally {
                isLoading.postValue(false)
            }
        }
    }

    fun addProductToCart(product: Product, quantity : Int) {
        // update product if exists else add to the cart
        orderedItems.value?.find { it.product == product }.also {
            if (it != null) {
                it.quantity = it.quantity.plus(quantity)
            } else orderedItems.value!!.add(CartItem(product, quantity))
        }
    }

    fun loadCategories() {
        viewModelScope.launch {
            try {
                isLoading.postValue(true)
                val response = freshCartRepository.getCategories()
                categoryList.value = response
                isLoaded.postValue(true)
                errorMessageData.postValue(null)
            } catch (e: Exception) {
                e.printStackTrace()
                errorMessageData.postValue(e.message)
            } finally {
                isLoading.postValue(false)
            }
        }
    }

    fun loadMainPromotions() {
        viewModelScope.launch {
            try {
                isLoading.postValue(true)
                val response = freshCartRepository.getMainPromotions()
                mainPromotionList.value = response
                isLoaded.postValue(true)
                errorMessageData.postValue(null)
            } catch (e: Exception) {
                e.printStackTrace()
                errorMessageData.postValue(e.message)
            } finally {
                isLoading.postValue(false)
            }
        }
    }

    fun loadSearchPromotions() {
        viewModelScope.launch {
            try {
                isLoading.postValue(true)
                val response = freshCartRepository.getSearchPromotions()
                searchPromotionList.value = response
                isLoaded.postValue(true)
                errorMessageData.postValue(null)
            } catch (e: Exception) {
                e.printStackTrace()
                errorMessageData.postValue(e.message)
            } finally {
                isLoading.postValue(false)
            }
        }
    }
}