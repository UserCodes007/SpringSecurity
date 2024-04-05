package Spring.Security.Sample.Model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Builder
public class Orders {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name ="product_id",referencedColumnName = "id",nullable = false)
    private Products product;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private int quantity;
}
