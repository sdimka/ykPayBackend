package com.springTest.dao.chempRegDAO;

import com.springTest.model.chempReg.ChempReg;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ChempRegDAOImpl implements ChempRegDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public ChempReg get(long id) {

        ChempReg cr = sessionFactory.getCurrentSession().get(ChempReg.class, id);
        Hibernate.initialize(cr.getSelectedTrainig());
        return cr;

    }

    @Override
    public List<ChempReg> list() {
        List<ChempReg> list = sessionFactory.getCurrentSession().createQuery("from ChempReg").list();
        list.forEach(a -> Hibernate.initialize(a.getSelectedTrainig()));
        return list;
    }

    @Override
    public long save(ChempReg chempReg) {
        sessionFactory.getCurrentSession().save(chempReg);
        return chempReg.getId();
    }

    @Override
    public void updatePaymentId(long id, String newPaymentID) {
        Session session = sessionFactory.getCurrentSession();
        ChempReg tempCR = session.byId(ChempReg.class).load(id);
        tempCR.setPaymentID(newPaymentID);
        session.flush();
    }
}
