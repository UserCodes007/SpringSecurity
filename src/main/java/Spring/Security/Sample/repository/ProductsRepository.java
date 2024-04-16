package Spring.Security.Sample.repository;

import Spring.Security.Sample.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductsRepository extends JpaRepository<Products,Integer> {
}
