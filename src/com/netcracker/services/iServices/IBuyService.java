package com.netcracker.services.iServices;

import com.netcracker.model.Buy;

import java.util.List;

public interface IBuyService {
    void saveBuy(Buy buy);
    List<Buy> findAllBuys();
    Buy findBuyById(int id);
    void deleteBuyById(int id);
}
