package com.example.shoppy.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppy.data.ShopListRepositoryImpl
import com.example.shoppy.domain.*

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val getShopItemUseCase = GetShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
        getShopList()
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
        getShopList()
    }

//    fun addShopItem(shopItem: ShopItem) {
//        addShopItemUseCase.addShopItem(shopItem)
//        getShopList()
//    }

//    fun getShopItem(shopItemId : Int) : ShopItem {
//        return getShopItemUseCase.getShopItem(shopItemId)
//    }


}