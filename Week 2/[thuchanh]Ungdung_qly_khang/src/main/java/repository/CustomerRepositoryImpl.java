package repository;

import model.Customer;
import org.hibernate.query.internal.QueryImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> findAll() {
        String query="SELECT c FROM Customer c";
        TypedQuery<Customer> typedQuery = em.createQuery(query,Customer.class);
        return typedQuery.getResultList();
    }

    @Override
    public Customer findById(Integer id) {
        String query="SELECT c FROM Customer c WHERE c.id =:id";
        TypedQuery<Customer> typedQuery = em.createQuery(query,Customer.class);
        typedQuery.setParameter("id",id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId()!=null){
            em.merge(customer);
        } else {
            em.persist(customer);
        }
    }

    @Override
    public void remove(Integer id) {
        Customer customer = findById(id);
        if (customer!=null){
            em.remove(customer);
        }
    }
}
