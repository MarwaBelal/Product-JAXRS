package org.eclipse.jakarta.hello.rest;

import jakarta.ejb.Singleton;
import jakarta.inject.Inject;
import jakarta.validation.*;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.jakarta.hello.model.Product;
import org.eclipse.jakarta.hello.service.ProductService;

import java.util.List;
import java.util.Set;

@Path("products")
@Singleton
public class ProductResource {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Inject
    private ProductService productService;

    public ProductResource() {
        System.out.println("new ProductResource()");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findAll() {
        return productService.findAllProducts();
    }

    @GET
    @Path("/findProductByName")
    @Produces(MediaType.APPLICATION_JSON)
    public Product findProductbyName(@QueryParam("name") String productName) {
        return productService.findProductbyName(productName);
    }

    @POST
    public Response addProduct(@Valid Product product) {
        // TODO @Valid don't enter the method
        // validate the product
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        if (!violations.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder();
            for (ConstraintViolation<Product> violation : violations) {
                errorMessage.append("- ").append(violation.getMessage());
            }
            throw new ValidationException(errorMessage.toString());
        }

        try {
            productService.addProduct(product);
            return Response.status(Response.Status.CREATED).entity("Product created successfully").build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error adding product").build();
        }
    }

    @PUT
    public Response update(Product updateProduct) {
        try {
            productService.updateProduct(updateProduct);
            return Response.status(Response.Status.OK).entity("Product updated successfully").build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error updating product").build();
        }

    }

    @DELETE
    public void delete(@QueryParam("id") int productId) {
        productService.deleteProductById(productId);
    }
}
