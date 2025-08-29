package example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @Column(length = 100)
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

    public void setId(String id) {
        if (!id.matches("[A-Z0-9]+")) {
            throw new IllegalArgumentException("ID должен быть только в верхнем регистре и цифры");
        }
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getDepartures() {
        return departures;
    }
    public void setDepartures(List<Ticket> departures) {
        this.departures = departures;
    }

    public List<Ticket> getArrivals() {
        return arrivals;
    }
    public void setArrivals(List<Ticket> arrivals) {
        this.arrivals = arrivals;
    }

    // --- equals & hashCode ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planet)) return false;
        Planet planet = (Planet) o;
        return Objects.equals(id, planet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // --- toString ---
    @Override
    public String toString() {
        return "Planet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
