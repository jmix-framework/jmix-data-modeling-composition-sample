package io.jmix.petclinic.security;

import io.jmix.petclinic.entity.User;
import io.jmix.petclinic.entity.coverage.CoverageDetails;
import io.jmix.petclinic.entity.coverage.InsuranceProvider;
import io.jmix.petclinic.entity.health.HealthRecord;
import io.jmix.petclinic.entity.owner.Address;
import io.jmix.petclinic.entity.owner.Owner;
import io.jmix.petclinic.entity.pet.Pet;
import io.jmix.petclinic.entity.pet.PetType;
import io.jmix.petclinic.entity.veterinarian.Specialty;
import io.jmix.petclinic.entity.veterinarian.Veterinarian;
import io.jmix.petclinic.entity.visit.Visit;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "Nurse", code = NurseRole.CODE)
public interface NurseRole {

    String CODE = "Nurse";

    @EntityAttributePolicy(entityClass = Owner.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Owner.class, actions = EntityPolicyAction.ALL)
    void owner();

    @EntityAttributePolicy(entityClass = Pet.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Pet.class, actions = EntityPolicyAction.ALL)
    void pet();

    @EntityAttributePolicy(entityClass = Visit.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Visit.class, actions = EntityPolicyAction.ALL)
    void visit();

    @EntityAttributePolicy(entityClass = Veterinarian.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Veterinarian.class, actions = EntityPolicyAction.READ)
    void veterinarian();

    @EntityAttributePolicy(entityClass = User.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = User.class, actions = EntityPolicyAction.READ)
    void user();

    @EntityAttributePolicy(entityClass = Specialty.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Specialty.class, actions = EntityPolicyAction.READ)
    void specialty();

    @EntityAttributePolicy(entityClass = PetType.class, attributes = "*", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = PetType.class, actions = EntityPolicyAction.READ)
    void petType();

    @ViewPolicy(viewIds = {"petclinic_MyVisits", "petclinic_Pet.list", "petclinic_Owner.list", "petclinic_Visit.list", "petclinic_Specialty.list", "petclinic_Veterinarian.list", "petclinic_PetType.list", "petclinic_Owner.detail", "petclinic_Pet.detail", "petclinic_PetType.detail", "petclinic_PetType.lookup", "petclinic_Specialty.detail", "petclinic_Veterinarian.detail", "petclinic_Visit.detail", "petclinic_Address.detail", "petclinic_HealthRecord.detail", "petclinic_InsuranceProvider.list", "petclinic_InsuranceProvider.detail", "petclinic_CoverageDetails.detail", "petclinic_Pet.create"})
    void views();

    @MenuPolicy(menuIds = {"petclinic_MyVisits", "petclinic_Pet.list", "petclinic_Owner.list", "petclinic_Visit.list", "petclinic_Specialty.list", "petclinic_Veterinarian.list", "petclinic_PetType.list", "petclinic_InsuranceProvider.list"})
    void screens();

    @EntityAttributePolicy(entityClass = Address.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Address.class, actions = EntityPolicyAction.ALL)
    void address();

    @EntityAttributePolicy(entityClass = HealthRecord.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = HealthRecord.class, actions = EntityPolicyAction.ALL)
    void healthRecord();

    @EntityAttributePolicy(entityClass = CoverageDetails.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = CoverageDetails.class, actions = EntityPolicyAction.ALL)
    void coverageDetails();

    @EntityAttributePolicy(entityClass = InsuranceProvider.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = InsuranceProvider.class, actions = EntityPolicyAction.ALL)
    void insuranceProvider();
}
