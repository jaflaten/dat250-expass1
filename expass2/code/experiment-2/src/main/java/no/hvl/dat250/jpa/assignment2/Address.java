package no.hvl.dat250.jpa.assignment2;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private Integer number;

    //skal vi ha ein mappeBy = "addresses" her for å mappe dei saman? men dei er jo på ein måte to felt, men det er det som knyttar dei..
    @ManyToMany(mappedBy = "addresses")
    private Set<Person> owners = new HashSet<>();
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
