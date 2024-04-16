package Spring.Security.Sample.service;

import Spring.Security.Sample.exceptions.OrderNotFoundException;
import Spring.Security.Sample.model.Orders;
import Spring.Security.Sample.repository.OrdersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrdersService {
    private OrdersRepository repo;
    public void add(Orders order){
        repo.save(order);
    }
    public List<Orders> getAll(String username, List<String> auth){
        for(String s:auth)
            if(s.equals("ADMIN"))
                return repo.findAll();
        return repo.findAllByUsername(username);
    }
    public Orders find(int id){
        Optional<Orders> op=repo.findById(id);
        if(op.isEmpty())throw new OrderNotFoundException();
        return op.get();
    }

    /*public void delete(int id){
        if(!repo.existsById(id))throw new OrderNotFoundException();
        repo.deleteById(id);
    }

    public void update(Orders order){
        if(!repo.existsById(order.getId()))throw new OrderNotFoundException();
        repo.save(order);
    }*/
}
