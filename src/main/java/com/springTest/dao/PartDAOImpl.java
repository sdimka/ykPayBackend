package com.springTest.dao;

import com.springTest.model.Part;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PartDAOImpl implements PartDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Part get(long id) {
        return sessionFactory.getCurrentSession().get(Part.class, id);
    }

    @Override
    public List<Part> list() {
        List<Part> list = sessionFactory.getCurrentSession().createQuery("from Part").list();
        return list;
    }

    @Override
    public long save(Part part) {
        sessionFactory.getCurrentSession().save(part);
        return part.getId();
    }

    @Override
    public void update(long id, Part part) {
        Session session = sessionFactory.getCurrentSession();
        Part tempPart = session.byId(Part.class).load(id);
        tempPart.setName(part.getName());
        tempPart.setSalon(part.getSalon());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Part part = sessionFactory.getCurrentSession().byId(Part.class).load(id);
        sessionFactory.getCurrentSession().delete(part);
    }

    @Override
    public void updatePaymentId(long id, String newPaymentID) {
        Session session = sessionFactory.getCurrentSession();
        Part tempPart = session.byId(Part.class).load(id);
        tempPart.setPaymentID(newPaymentID);
        session.flush();
    }
}
