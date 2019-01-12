package com.netcracker.dao.iDAO;

import com.netcracker.model.Buy;

import java.util.List;

public interface IBuyDAO {

    void saveBuy(Buy entity);

    List<Buy> findAllBuy();

    Buy findBuyById(int id);

    void deleteBuyById(int id);
    void updateBuy(Buy buy);
}
