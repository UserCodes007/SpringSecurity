package Spring.Security.Sample.repository;

import Spring.Security.Sample.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    List<Orders> findAllByUsername(String username);
}
