package com.netcracker.services;

import com.netcracker.dao.iDAO.IBuyDAO;
import com.netcracker.model.Buy;
import com.netcracker.services.iServices.IBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("buyService")
public class BuyService implements IBuyService {

    @Autowired
    IBuyDAO buyDAO;

    public void saveBuy(Buy buyer) {
        buyDAO.saveBuy(buyer);
    }

    public List<Buy> findAllBuys() { return buyDAO.findAllBuy(); }

    public Buy findBuyById(int id) {
        return buyDAO.findBuyById(id);
    }

    public void deleteBuyById(int id) {
        buyDAO.deleteBuyById(id);
    }
    @Override
    public void updateBuy(Buy buy) { buyDAO.updateBuy(buy);}

}
