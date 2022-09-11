package no.hvl.dat250.jpa.assignment2;

import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "owners")
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    private Set<CreditCard> creditCards = new HashSet<>();
    public String getName() {
        return name;
    }

    public Collection<Address> getAdresses() {
        return addresses;
    }

    public void setAddress(Address a) {
        this.addresses.add(a);
    }

    public Collection<CreditCard> getCreditCards() {
        return this.creditCards;
    }
}
