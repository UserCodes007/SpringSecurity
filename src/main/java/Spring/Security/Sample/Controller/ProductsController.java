package Spring.Security.Sample.Controller;

import Spring.Security.Sample.Model.Products;
import Spring.Security.Sample.Service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductsController {
    private ProductsService pService;

    @GetMapping("/all")
    public List<Products> allProducts(){
        return pService.getAll();
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody List<Products> list){
        for(Products i:list)pService.add(i);
    }

    @GetMapping("/{id}")
    public Products get(@PathVariable int id){
        return pService.find(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        pService.delete(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody Products product){
        pService.update(product);
    }
}
