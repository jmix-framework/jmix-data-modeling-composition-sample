package io.jmix.petclinic.entity.health;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum HealthStatus implements EnumClass<String> {

    HEALTHY("HEALTHY"),
    RECOVERING("RECOVERING"),
    CHRONIC_CONDITION("CHRONIC_CONDITION");

    private final String id;

    HealthStatus(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static HealthStatus fromId(String id) {
        for (HealthStatus at : HealthStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}