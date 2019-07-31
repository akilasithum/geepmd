package com.geepmd.dbConnection;

import com.geepmd.entity.CommonDetails;
import com.geepmd.entity.MotherDetails;
import com.geepmd.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBConnection {

    private static final DBConnection dbConnection = new DBConnection();
    Session session;

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

    private Session getSession(){
        if(session == null || !session.isConnected()){
            session = HibernateUtil.getSessionFactory().openSession();
            return session;
        }
        else {
            return session;
        }
    }

    public int insertUser(User details){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int id = (Integer)session.save(details);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public int insertObjectHBM(Object details){
        Session session = getSession();
        session.beginTransaction();
        int id = (Integer)session.save(details);
        session.getTransaction().commit();
        //session.close();
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
        Session session = getSession();
        try
        {
            Criteria criteria = session.createCriteria(Class.forName(className));
            criteria.addOrder(Order.asc(order));
            List list = criteria.list();
            //session.close();
            return list;
        } catch (Exception e) {
            //session.close();
            return null;
        }
    }

    public List<?> getAllValues(String className,int surveyId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            Criteria criteria = session.createCriteria(Class.forName(className));
            criteria.add(Restrictions.eq("surveyId", surveyId));
            List list = criteria.list();
            session.close();
            return list;
        } catch (Exception e) {
            session.close();
            return null;
        }
    }

    public Object getPageValue(String className,int surveyId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            Criteria criteria = session.createCriteria(Class.forName(className));
            criteria.add(Restrictions.eq("surveyId", surveyId));
            List list = criteria.list();
            session.close();
            if(list != null && !list.isEmpty()) return list.get(0);
            else return null;
        } catch (Exception e) {
            session.close();
            return null;
        }
    }

    public CommonDetails isMotherDetailsAdded(String motherId){
        Session session = getSession();
        try
        {
            Criteria criteria = session.createCriteria(CommonDetails.class);
            criteria.add(Restrictions.eq("motherId",motherId));
            List list = criteria.list();
            if(list != null || !list.isEmpty()) return (CommonDetails)list.get(0);
            else return null;
        } catch (Exception e) {
            return null;
        }
    }
}
