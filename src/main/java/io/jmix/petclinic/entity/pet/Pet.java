package io.jmix.petclinic.entity.pet;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.petclinic.entity.NamedEntity;
import io.jmix.petclinic.entity.coverage.CoverageDetails;
import io.jmix.petclinic.entity.health.HealthRecord;
import io.jmix.petclinic.entity.owner.Owner;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;


// tag::start-class[]
@JmixEntity
@Table(name = "PETCLINIC_PET", indexes = {
        @Index(name = "IDX_PETCLINIC_PET_COVERAGE_DETAILS", columnList = "COVERAGE_DETAILS_ID")
})
@Entity(name = "petclinic_Pet")
public class Pet extends NamedEntity {

    // end::start-class[]

    @Column(name = "IDENTIFICATION_NUMBER", nullable = false)
    @NotNull
    private String identificationNumber;
    @JoinColumn(name = "OWNER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Owner owner;


    @JoinColumn(name = "TYPE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private PetType type;

    @Column(name = "BIRTHDATE")
    private LocalDate birthdate;

    // tag::health-records[]
    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "pet")
    private List<HealthRecord> healthRecords;

    // end::health-records[]


    // tag::coverage-details[]
    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @JoinColumn(name = "COVERAGE_DETAILS_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private CoverageDetails coverageDetails;

    // end::coverage-details[]



    // tag::owner[]

    public CoverageDetails getCoverageDetails() {
        return coverageDetails;
    }

    public void setCoverageDetails(CoverageDetails coverageDetails) {
        this.coverageDetails = coverageDetails;
    }
    // end::owner[]

    public List<HealthRecord> getHealthRecords() {
        return healthRecords;
    }

    public void setHealthRecords(List<HealthRecord> healthRecords) {
        this.healthRecords = healthRecords;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

// tag::end-class[]
}
// end::end-class[]