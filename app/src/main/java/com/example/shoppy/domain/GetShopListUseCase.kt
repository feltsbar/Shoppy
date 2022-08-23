package com.example.shoppy.domain

class GetShopListUseCase(private val repository: ShopListRepository) {

    fun getShopList() : List<ShopItem> {
        return repository.getShopList()
    }
}