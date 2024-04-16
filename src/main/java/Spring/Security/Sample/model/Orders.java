package Spring.Security.Sample.model;

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
    private Products product;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private int quantity;
}
