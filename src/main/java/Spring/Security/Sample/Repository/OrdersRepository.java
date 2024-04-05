package Spring.Security.Sample.Repository;

import Spring.Security.Sample.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    List<Orders> findAllByUsername(String username);
}
