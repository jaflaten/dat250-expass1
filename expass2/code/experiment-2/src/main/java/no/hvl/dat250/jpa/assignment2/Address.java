package no.hvl.dat250.jpa.assignment2;

import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private Integer number;

    @ManyToMany
    private Set<Person> owners;
    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public Set<Person> getOwners() {
        return owners;
    }
}
