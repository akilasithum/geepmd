package com.geepmd.dbConnection;

import com.geepmd.entity.MotherDetails;
import com.geepmd.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBConnection {

    private static final DBConnection dbConnection = new DBConnection();

    public static DBConnection getInstance(){
        return dbConnection;
    }

    public boolean isLoginSuccessful(String userName,String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("userName", userName));
            criteria.add(Restrictions.eq("password", password));
            List retList =  criteria.list();
            session.close();
            return retList != null && !retList.isEmpty();
        } catch (Exception e) {
            session.close();
            return false;
        }
    }

    public List<MotherDetails> getMotherDetails(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            Criteria criteria = session.createCriteria(MotherDetails.class);
            List retList =  criteria.list();
            session.close();
            return retList;
        } catch (Exception e) {
            session.close();
            return null;
        }
    }

    public int insertObjectHBM(Object details){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int id = (Integer)session.save(details);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public void updateObjectHBM(Object details){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(details);
        session.getTransaction().commit();
        session.close();
    }

    public User getUser(String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("userName", userName));
            List retList =  criteria.list();
            session.close();
            return (User) retList.get(0);
        } catch (Exception e) {
            session.close();
            return null;
        }
    }

    public List<?> getAllValues(String className,String order){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            Criteria criteria = session.createCriteria(Class.forName(className));
            criteria.addOrder(Order.asc(order));
            List list = criteria.list();
            session.close();
            return list;
        } catch (Exception e) {
            session.close();
            return null;
        }
    }
}
