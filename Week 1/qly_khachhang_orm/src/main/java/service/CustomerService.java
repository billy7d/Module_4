package service;

import model.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

@Service
public class CustomerService implements ICustomerService {

//    @Autowired
//    private EntityManager entityManager;
    // khong dung duoc cai nay phai thay =  EntityManager entityManager = sessionFactory.createEntityManager();

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> findAll() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        String queryHQL ="SELECT c FROM Customer AS c";
        TypedQuery<Customer> query = entityManager.createQuery(queryHQL,Customer.class);
        return query.getResultList();

    }

    //bai mau dung doi tuong Integer;
    @Override
    public Customer findById(int id) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        String queryHQL= "SELECT c from Customer AS c WHERE c.id = :id";
        TypedQuery<Customer> query =entityManager.createQuery(queryHQL,Customer.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public Customer save(Customer customer) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            return customer;
        } catch (HibernateException e) {
            e.printStackTrace();
            e.getMessage();
            if (transaction!=null)
                transaction.rollback();
        } finally {
            if (session!=null){
                session.close();
            }
        }


        return null;
    }

    @Override
    public Customer update(Customer customer) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (customer.getId() > 0) {
                session.merge(customer);
            } else {
                session.persist(customer);
            }
            transaction.commit();
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction!=null)
                transaction.rollback();
        }finally {
            if (session!=null)
                session.close();
        }

        return null;
    }


    @Override
    public void remove(int id) {
        Session session = null;
        Transaction transaction = null;
        try{
            Customer customer = findById(id);
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(customer);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            if (transaction !=null){
                transaction.rollback();
            }
        } finally {
            if (session!=null)
            session.close();
        }

    }
}
