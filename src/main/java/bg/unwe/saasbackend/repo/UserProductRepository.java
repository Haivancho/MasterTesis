package bg.unwe.saasbackend.repo;

import bg.unwe.saasbackend.model.User;
import bg.unwe.saasbackend.model.UserProduct;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Optional;

@ApplicationScoped
public class UserProductRepository {

    @Inject
    EntityManager em;

    public UserProduct save(UserProduct userProduct) {
        if (userProduct.getId() == null || userProduct.getId() == 0) {
            em.persist(userProduct);
        } else {
            userProduct = em.merge(userProduct);
        }

        return userProduct;
    }

    public Optional<UserProduct> findAllByUser(User user) {
        Query query = em.createNamedQuery(UserProduct.FIND_ALL_BY_USER);
        query.setParameter("user", user);
        return query.getResultList().stream().findAny();
    }

}
