package Spring.Security.Sample.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
public class OrderRequest {
    private int id;
    private Products product;
    private int quantity;
    public Orders getOrder(String username){
        return Orders.builder().
                id(id)
                .product(product)
                .quantity(quantity)
                .username(username)
                .build();
    }
}
