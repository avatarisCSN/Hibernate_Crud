package example;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @Column(length = 50)
    private String id;
    // можно вообще было так сделать @Pattern(regexp = "[A-Z0-9]+", message = "ID должен быть только в верхнем регистре и цифры")

    @Column(nullable = false, length = 500)
    private String name;

    @OneToMany(mappedBy = "fromPlanet")
    private java.util.List<Ticket> departures = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "toPlanet")
    private java.util.List<Ticket> arrivals = new java.util.ArrayList<>();

    public Planet(String id, String name) {
        if (!id.matches("[A-Z0-9]+")) {
            throw new IllegalArgumentException("ID должен быть только в верхнем регистре и цифры");
        }
        this.id = id;
        this.name = name;
    }

    public Planet() {
        // пустой конструктор для Hibernate
    }

}
