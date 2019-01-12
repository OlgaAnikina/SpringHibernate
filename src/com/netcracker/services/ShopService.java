package com.netcracker.services;


import com.netcracker.dao.iDAO.IShopDAO;
import com.netcracker.model.Shop;
import com.netcracker.services.iServices.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shopService")
public class ShopService implements IShopService {

    @Autowired
    IShopDAO shopDAO;

    @Override
    public void saveShop(Shop shop) {
        shopDAO.saveShop(shop);
    }

    @Override
    public List<Shop> findAllShops() {
        return shopDAO.findAllShop();
    }

    @Override
    public Shop findShopById(int id) {
        return shopDAO.findShopById(id);
    }

    @Override
    public void deleteShopById(int id) {

        shopDAO.deleteShopById(id);
    }
}
