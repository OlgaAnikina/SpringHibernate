package com.netcracker.dao.iDAO;



import com.netcracker.model.Shop;

import java.util.List;

public interface IShopDAO {
    void saveShop(Shop entity);

    List<Shop> findAllShop();

    Shop findShopById(int id);

    void deleteShopById(int id);


}
