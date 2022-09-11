package no.hvl.dat250.jpa.assignment2.driver;

import no.hvl.dat250.jpa.assignment2.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Set;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // TODO: Persist object world corresponding to the domain model of experiment 2.
        Person person = new Person();
        person.setName("Max Mustermann");

        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);
        address.setOwners(Set.of(person));
        person.setAddress(address);

        Pincode pincode = new Pincode();
        pincode.setPincode("123");
        pincode.setCount(1);

        CreditCard cc1 = new CreditCard();
        CreditCard cc2 = new CreditCard();
        Bank bank = new Bank();
        bank.setName("Pengebank");

        cc1.setPincode(pincode);
        cc1.setNumber(12345);
        cc1.setBalance(-5000);
        cc1.setLimit(-10000);
        cc1.setOwningBank(bank);

        cc2.setPincode(pincode);
        cc2.setNumber(123);
        cc2.setBalance(1);
        cc2.setLimit(2000);
        cc2.setOwningBank(bank);

        Set<CreditCard> creditCards = Set.of(cc1, cc2);
        bank.setOwnedCards(creditCards);
        person.setCreditCards(creditCards);

        em.getTransaction().begin();
        em.persist(bank);
        em.persist(cc1);
        em.persist(cc2);
        em.persist(pincode);
        em.persist(address);
        em.persist(person);
        em.getTransaction().commit();
        em.close();


    }
}
