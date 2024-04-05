package Spring.Security.Sample.Controller;

import Spring.Security.Sample.Model.OrderRequest;
import Spring.Security.Sample.Model.Orders;
import Spring.Security.Sample.Service.OrdersService;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrdersController {

    private OrdersService oService;
    @PostMapping("/placeOrder")
    public void add(@RequestBody List<OrderRequest> list, Authentication auth ){
        for(OrderRequest i:list) oService.add(i.getOrder(auth.getName()));
    }
    @GetMapping("/all")
    public List<Orders> all(Authentication auth){
        List<String>list=auth.getAuthorities().stream().map(x->x.getAuthority()).toList();
        return oService.getAll(auth.getName(),list);
    }

    @GetMapping("/{id}")
    public Orders get(@PathVariable int id){
        return oService.find(id);
    }
    /*@DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        oService.delete(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody Orders order){
        oService.update(order);
    }*/
}
