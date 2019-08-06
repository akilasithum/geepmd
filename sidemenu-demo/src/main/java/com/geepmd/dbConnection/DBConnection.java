package com.geepmd.dbConnection;

import com.geepmd.entity.CommonDetails;
import com.geepmd.entity.MotherDetails;
import com.geepmd.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import sun.security.pkcs11.Secmod;

import java.util.List;

public class DBConnection {

    Session session;

    public DBConnection(){
        session = getSession();
    }


    public boolean isLoginSuccessful(String userName,String password){
        Session session = getSession();
        try
        {
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("userName", userName));
            criteria.add(Restrictions.eq("password", password));
            List retList =  criteria.list();
            return retList != null && !retList.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isUserNameExists(String userName) {
        try
        {
            Session session = getSession();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("userName", userName));
            List retList =  criteria.list();
            return retList != null && !retList.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public List<MotherDetails> getMotherDetails(){
        try
        {
            Session session = getSession();
            Criteria criteria = session.createCriteria(MotherDetails.class);
            List retList =  criteria.list();
            return retList;
        } catch (Exception e) {
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

    public void closeSession(){
        if(session != null && session.isConnected()){
            session.disconnect();
        }
    }

    public int insertUser(User details){
        Session session = getSession();
        session.beginTransaction();
        int id = (Integer)session.save(details);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public void saveOrUpdateHBM(Object details){
        Session session = getSession();
        session.beginTransaction();
        session.saveOrUpdate(details);
        session.getTransaction().commit();
    }

    public int saveObjectHBM(Object details){
        Session session = getSession();
        session.beginTransaction();
        int id = (Integer)session.save(details);
        session.getTransaction().commit();
        return id;
    }

    public void deleteBySurveyId(String className,int surveyId){
        Session session = getSession();
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
        Session session = getSession();
        try
        {
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("userName", userName));
            List retList =  criteria.list();
            return (User) retList.get(0);
        } catch (Exception e) {
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
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public List<?> getAllValues(String className,int surveyId){
        Session session = getSession();
        try
        {
            Criteria criteria = session.createCriteria(Class.forName(className));
            criteria.add(Restrictions.eq("surveyId", surveyId));
            List list = criteria.list();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public Object getPageValue(String className,int surveyId){
        Session session = getSession();
        try
        {
            Criteria criteria = session.createCriteria(Class.forName(className));
            criteria.add(Restrictions.eq("surveyId", surveyId));
            List list = criteria.list();
            if(list != null && !list.isEmpty()) return list.get(0);
            else return null;
        } catch (Exception e) {
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
