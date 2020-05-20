package bg.unwe.saasbackend.resource;

import bg.unwe.saasbackend.model.Product;
import bg.unwe.saasbackend.model.User;
import bg.unwe.saasbackend.model.UserProduct;
import bg.unwe.saasbackend.repo.ProductRepository;
import bg.unwe.saasbackend.repo.UserProductRepository;
import bg.unwe.saasbackend.repo.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.Optional;


@RequestScoped
@Path("/userProduct")
public class UserProductResource {


    @Inject
    private UserProductRepository userProductRepository;
    @Inject
    private UserRepository userRepository;
    @Inject
    private ProductRepository productRepository;

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/Items")
    public Response create(@PathParam("id") Long userID , @QueryParam("productID") Long productID, LocalDateTime dateFrom,LocalDateTime dateTo) {
        Optional<User> user = userRepository.getUserById(userID);
        Optional<Product> product = productRepository.getProductById(productID);

        if (user.isPresent() && product.isPresent()){
            UserProduct userProduct= userProductRepository.save(new UserProduct(user.get(),product.get(), dateFrom,dateTo));
            return Response.ok(userProduct).build();
        }
        else return Response.status(Response.Status.NOT_FOUND).build();
    }



}

