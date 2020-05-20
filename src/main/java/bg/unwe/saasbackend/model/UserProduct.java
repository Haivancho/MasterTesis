package bg.unwe.saasbackend.model;

import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@NamedQuery(name = UserProduct.FIND_ALL_BY_USER, query = "SELECT usp FROM UserProduct usp WHERE usp.user = :user")
public class UserProduct extends AbstractEntity {

    public static final String FIND_ALL_BY_USER= "findAllCartbooksByUser";

    @MapsId
    @OneToOne
    private User user;

    @MapsId
    @OneToOne
    private Product product;

    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;

    public UserProduct() {}

    public UserProduct(User user, Product product, LocalDateTime dateFrom, LocalDateTime dateTo) {
        this.user = user;
        this.product = product;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
    }
}
