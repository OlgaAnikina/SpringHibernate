package com.netcracker.dao.daoImpl;
import com.netcracker.dao.BasicDAO;


import com.netcracker.dao.iDAO.IShopDAO;
import com.netcracker.model.Shop;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("shopDAO")
@Transactional
public class ShopDAOImpl extends BasicDAO implements IShopDAO {


    public void saveShop(Shop shop) {
        persist(shop);
    }

    public List<Shop> findAllShop() {
        Criteria criteria = getSession().createCriteria(Shop.class);
        return criteria.list();
    }

    public Shop findShopById(int id) {
        Criteria criteria = getSession().createCriteria(Shop.class);
        criteria.add(Restrictions.eq("shop_id",id));
        return (Shop) criteria.uniqueResult();
    }

    public void deleteShopById(int id) {
        Query query = getSession().createQuery("delete from Shop where id = :id");
        query.setInteger("id",id);
        query.executeUpdate();
    }
}
