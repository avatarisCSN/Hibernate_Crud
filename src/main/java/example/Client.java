package example;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // автоінкремент
    private int id;
    @Column(nullable = false, length = 200)
    private String name;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<Ticket> tickets = new java.util.ArrayList<>();
}
