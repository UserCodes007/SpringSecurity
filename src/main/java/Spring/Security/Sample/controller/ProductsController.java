package Spring.Security.Sample.controller;

import Spring.Security.Sample.model.Products;
import Spring.Security.Sample.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductsController {
    private ProductsService pService;

    @GetMapping
    public List<Products> allProducts(){
        return pService.getAll();
    }

    @PostMapping
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
    @PutMapping
    public void update(@RequestBody Products product){
        pService.update(product);
    }
}
