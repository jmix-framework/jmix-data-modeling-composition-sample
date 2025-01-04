package io.jmix.petclinic.entity.owner;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.petclinic.entity.Person;
import io.jmix.petclinic.entity.pet.Pet;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.List;

// tag::start-class[]
@JmixEntity
@Table(name = "PETCLINIC_OWNER")
@Entity(name = "petclinic_Owner")
public class Owner extends Person {

    // end::start-class[]

    // tag::addresses[]
    @Composition // <1>
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "owner") // <2>
    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    // end::addresses[]

    @Email
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TELEPHONE")
    private String telephone;

    // tag::pets[]
    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OrderBy("identificationNumber")
    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;
    // end::pets[]

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

// tag::end-class[]
}
// end::end-class[]