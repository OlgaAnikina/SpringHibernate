package com.netcracker.dao.iDAO;

import com.netcracker.model.Buyer;

import java.util.List;

public interface IBuyerDAO {

    void saveBuyer(Buyer entity);

    List<Buyer> findAllBuyers();

    Buyer findBuyerById(int id);

    void deleteBuyerById(int id);

}
