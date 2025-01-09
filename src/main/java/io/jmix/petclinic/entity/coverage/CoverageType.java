package io.jmix.petclinic.entity.coverage;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum CoverageType implements EnumClass<String> {

    INSURANCE("INSURANCE"),
    SELF_PAY("SELF_PAY"),
    SUBSIDIZED("SUBSIDIZED");

    private final String id;

    CoverageType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CoverageType fromId(String id) {
        for (CoverageType at : CoverageType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}