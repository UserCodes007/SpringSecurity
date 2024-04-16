package Spring.Security.Sample.service;
import Spring.Security.Sample.exceptions.ProductNotFoundException;
import Spring.Security.Sample.model.Products;
import Spring.Security.Sample.repository.ProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductsService {
    private ProductsRepository repo;
    public void add(Products product){
        repo.save(product);
    }
    public List<Products> getAll(){
        return repo.findAll();
    }

    public Products find(int id){
        Optional<Products> op=repo.findById(id);
        if(op.isEmpty())throw new ProductNotFoundException();
        return op.get();
    }

    public void delete(int id){
        if(!repo.existsById(id))throw new ProductNotFoundException();
        repo.deleteById(id);
    }

    public void update(Products product){
        if(!repo.existsById(product.getId()))throw new ProductNotFoundException();
        repo.save(product);
    }
}
