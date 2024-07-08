package io.github.unjoinable.amongus.enums;

import java.util.Arrays;
import java.util.Collection;

/**
 * @since 1.0.0
 * @author unjoinable
 */
public enum Roles {
    INNOCENT,
    IMPOSTER;

    private static final Collection<Roles> VALUES = Arrays.asList(values());

    /**
     * @return Get all roles are collection
     * @since 1.0.0
     * @author unjoinable
     */
    public static Collection<Roles> getValues() {
        return VALUES;
    }
}
