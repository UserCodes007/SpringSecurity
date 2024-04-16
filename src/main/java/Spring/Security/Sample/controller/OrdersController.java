package Spring.Security.Sample.controller;

import Spring.Security.Sample.model.OrderRequest;
import Spring.Security.Sample.model.Orders;
import Spring.Security.Sample.service.OrdersService;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrdersController {

    private OrdersService oService;
    @PostMapping
    public void add(@RequestBody List<OrderRequest> list, Authentication auth ){
        for(OrderRequest i:list) oService.add(i.getOrder(auth.getName()));
    }
    @GetMapping
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
