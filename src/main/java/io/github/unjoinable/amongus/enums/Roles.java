package io.github.unjoinable.amongus.enums;

import java.util.Arrays;
import java.util.Collection;

public enum Roles {
    INNOCENT,
    IMPOSTER;

    private static final Collection<Roles> VALUES = Arrays.asList(values());

    /**
     * @return Get all roles are collection
     */
    public static Collection<Roles> getValues() {
        return VALUES;
    }
}
