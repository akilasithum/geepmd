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

    public boolean isUserNameExists(String userName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try
        {
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("userName", userName));
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

    public Session getSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }

    public void closeSession(Session session){
        if(session != null && session.isConnected()){
            session.close();
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

    public void saveOrUpdateHBM(Object details, Session session){
        session.beginTransaction();
        session.saveOrUpdate(details);
        session.getTransaction().commit();
    }

    public int saveObjectHBM(Object details,Session session){
        session.beginTransaction();
        int id = (Integer)session.save(details);
        session.getTransaction().commit();
        return id;
    }

    public void deleteBySurveyId(String className,int surveyId,Session session){
        try
        {
            Criteria criteria = session.createCriteria(Class.forName(className));
            criteria.add(Restrictions.eq("surveyId", surveyId));
            List list = criteria.list();
            for(Object obj : list){
                session.delete(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public List<?> getAllValues(Session session,String className,String order){
        try
        {
            Criteria criteria = session.createCriteria(Class.forName(className));
            criteria.addOrder(Order.asc(order));
            List list = criteria.list();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public List<?> getAllValues(String className,int surveyId,Session session){
        try
        {
            Criteria criteria = session.createCriteria(Class.forName(className));
            criteria.add(Restrictions.eq("surveyId", surveyId));
            List list = criteria.list();
            return list;
        } catch (Exception e) {
            session.close();
            return null;
        }
    }

    public Object getPageValue(String className,int surveyId,Session session){
        try
        {
            Criteria criteria = session.createCriteria(Class.forName(className));
            criteria.add(Restrictions.eq("surveyId", surveyId));
            List list = criteria.list();
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

    public boolean isMotherIdAvailable(String motherId){
        Session session = getSession();
        try
        {
            Criteria criteria = session.createCriteria(MotherDetails.class);
            criteria.add(Restrictions.eq("motherSerialNumber",motherId));
            List list = criteria.list();
            if(list != null && !list.isEmpty()) return true;
            else return false;
        } catch (Exception e) {
            return false;
        }
    }
}
