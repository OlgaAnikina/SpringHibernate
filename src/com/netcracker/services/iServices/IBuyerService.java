package com.netcracker.services.iServices;

import com.netcracker.model.Buyer;

import java.util.List;

public interface IBuyerService {
    void saveBuyer(Buyer buyer);
    List<Buyer> findAllBuyers();
    Buyer findBuyerById(int id);
    void deleteBuyerById(int id);

}
