package db;

import models.CurrentPurchase;
import models.Customer;
import models.Product;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void saveOrUpdate(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> void deleteAll(Class classType){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(classType);
            List<T> results = cr.list();
            for (T result : results){
                session.delete(result);
            }
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> T getUnique(Criteria criteria) {
        T result = null;
        try {
            transaction = session.beginTransaction();
            result = (T) criteria.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static <T> List<T> getList(Criteria criteria) {
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            results = criteria.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static <T> T find(Class classType, int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        Criteria cr = session.createCriteria(classType);
        cr.add(Restrictions.idEq(id));
        result = getUnique(cr);
        return result;
    }

    public static <T> List<T> getAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        Criteria cr = session.createCriteria(classType);
        cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        results = getList(cr);
        return results;
    }

    public static GregorianCalendar formatStringToDate(String strDate) {
        ArrayList<String> dateParts = new ArrayList<>();
        for (String datePart: strDate.split("-")) {
            dateParts.add(datePart);
        }
        int day = Integer.parseInt(dateParts.get(0));
        int month = Integer.parseInt(dateParts.get(1));
        int year = Integer.parseInt(dateParts.get(2));
        GregorianCalendar result  = new GregorianCalendar(day, month, year);
        return result;
    }

    public static Customer findCustomerByUsername(String username) {
        session = HibernateUtil.getSessionFactory().openSession();
        Customer customer = null;
        Criteria cr = session.createCriteria(Customer.class);
        cr.add(Restrictions.eq("username", username));
        customer = getUnique(cr);
        return customer;
    }

    public static CurrentPurchase findBasketForCustomer(Customer customer) {
        session = HibernateUtil.getSessionFactory().openSession();
        CurrentPurchase basket = null;
        Criteria cr = session.createCriteria(CurrentPurchase.class);
        cr.add(Restrictions.eq("customer", customer));
        basket = getUnique(cr);
        return basket;
    }

}
