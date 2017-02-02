package cz.etn.etnshop.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao implements ProductDao {


    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getProducts() {
        Criteria criteria = getSession().createCriteria(Product.class);
        return (List<Product>) criteria.list();
    }

    @Override
    public Product getEntityById(int id) {
        return (Product) getSession().get(Product.class, id);
    }

    @Override
    public void addEntity(Product product) {
        getSession().save(product);
    }

    @Override
    public void updateEntity(Product product) {
        getSession().update(product);
    }

    @Override
    public List<Product> getProducts(String searchText) {
        List<Product> filtered = getSession().createCriteria(Product.class)
                .add(Restrictions.like("name", "%" + searchText + "%"))
                .list();
        return filtered;
    }

}
