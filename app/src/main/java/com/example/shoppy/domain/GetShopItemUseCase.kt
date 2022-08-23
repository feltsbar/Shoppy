package com.example.shoppy.domain

class GetShopItemUseCase(private val repository: ShopListRepository) {

    fun getShopItem(shopItemId : Int) : ShopItem {
        return repository.getShopItem(shopItemId)
    }
}