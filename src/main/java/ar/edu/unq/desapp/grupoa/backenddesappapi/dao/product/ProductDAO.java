package ar.edu.unq.desapp.grupoa.backenddesappapi.dao.product;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends CrudRepository<Product, Long> {
}
