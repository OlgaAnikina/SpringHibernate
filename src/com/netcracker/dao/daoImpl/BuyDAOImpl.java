package com.netcracker.dao.daoImpl;

import com.netcracker.dao.BasicDAO;
import com.netcracker.dao.iDAO.IBuyDAO;
import com.netcracker.model.Buy;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository("buyDAO")
@Transactional
public class BuyDAOImpl extends BasicDAO implements IBuyDAO {
    @Override
    public void saveBuy(Buy buy) {
        persist(buy);
    }

    @Override
    public List<Buy> findAllBuy() {
        Criteria criteria = getSession().createCriteria(Buy.class);
        return criteria.list();
    }

    @Override
    public Buy findBuyById(int id) {
        Criteria criteria = getSession().createCriteria(Buy.class);
        criteria.add(Restrictions.eq("buy_id",id));
        return (Buy) criteria.uniqueResult();
    }

    @Override
    public void deleteBuyById(int id) {
        Query query = getSession().createQuery("delete from Buy where id = :id");
        query.setInteger("id",id);
        query.executeUpdate();
    }
}
