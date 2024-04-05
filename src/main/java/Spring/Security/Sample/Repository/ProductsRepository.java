package Spring.Security.Sample.Repository;

import Spring.Security.Sample.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductsRepository extends JpaRepository<Products,Integer> {
}
