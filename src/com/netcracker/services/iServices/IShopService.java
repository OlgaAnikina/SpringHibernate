package com.netcracker.services.iServices;


import com.netcracker.model.Shop;

import java.util.List;

public interface IShopService {
    void saveShop(Shop shop);
    List<Shop> findAllShops();
    Shop findShopById(int id);
    void deleteShopById(int id);
}
