package com.netcracker.dao.daoImpl;

import com.netcracker.dao.BasicDAO;
import com.netcracker.dao.iDAO.IBuyerDAO;
import com.netcracker.model.Buyer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("buyerDAO")
@Transactional
public class BuyerDAOImpl extends BasicDAO implements IBuyerDAO {

    public void saveBuyer(Buyer buyer) {
        persist(buyer);
    }

    public List<Buyer> findAllBuyers() {
        Criteria criteria = getSession().createCriteria(Buyer.class);
        return criteria.list();
    }

    public Buyer findBuyerById(int id) {
        Criteria criteria = getSession().createCriteria(Buyer.class);
        criteria.add(Restrictions.eq("buyer_id",id));
        return (Buyer) criteria.uniqueResult();
    }

    public void deleteBuyerById(int id) {
        Query query = getSession().createQuery("delete from Buyer where id = :id");
        query.setInteger("id",id);
        query.executeUpdate();
    }
}
