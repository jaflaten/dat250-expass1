package no.hvl.dat250.jpa.assignment2;

import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private Integer limit;
    private Integer balance;
    @OneToOne
    @JoinColumn(name = "pincode_id")
    private Pincode pincode;

    @ManyToOne
    private Person user;
    @ManyToOne
    @JoinColumn(name = "owning_bank_id")
    private Bank owningBank;
    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public int getNumber() {
        return number;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getLimit() {
        return limit;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public Bank getOwningBank() {
        return owningBank;
    }
}
