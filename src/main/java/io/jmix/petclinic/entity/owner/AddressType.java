package io.jmix.petclinic.entity.owner;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum AddressType implements EnumClass<String> {

    BILLING("BILLING"),
    CONTACT("CONTACT"),
    OTHER("OTHER");

    private final String id;

    AddressType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static AddressType fromId(String id) {
        for (AddressType at : AddressType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}