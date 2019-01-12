package com.netcracker.services;

import com.netcracker.dao.iDAO.IBuyerDAO;
import com.netcracker.model.Buyer;
import com.netcracker.services.iServices.IBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("buyerService")
public class BuyerService implements IBuyerService {

    @Autowired
    IBuyerDAO buyerDAO;

    public void saveBuyer(Buyer buyer) {
        buyerDAO.saveBuyer(buyer);
    }

    public List<Buyer> findAllBuyers() {
        return buyerDAO.findAllBuyers();
    }

    public Buyer findBuyerById(int id) {
        return buyerDAO.findBuyerById(id);
    }

    public void deleteBuyerById(int id) {
        buyerDAO.deleteBuyerById(id);
    }
    @Override
    public void updateBuyer(Buyer buyer) { buyerDAO.updateBuyer(buyer);}
}
