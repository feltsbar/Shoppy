package com.example.shoppy.domain

class AddShopItemUseCase(private val repository: ShopListRepository) {

    fun addShopItem(shopItem: ShopItem) {
        repository.addShopItem(shopItem)
    }
}