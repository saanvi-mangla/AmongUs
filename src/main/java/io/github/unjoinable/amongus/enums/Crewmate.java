package io.github.unjoinable.amongus.enums;

import java.util.Arrays;
import java.util.Collection;

@SuppressWarnings("unused")
public enum Crewmate {
    RED,
    ORANGE,
    YELLOW,
    PINK,
    PEACH,
    WHITE,
    GOLD,
    LIGHT_BROWN,
    MAROON,
    PURPLE,
    BLUE,
    LIGHT_BLUE,
    LIME,
    GREEN,
    TEAL,
    SILVER,
    GREY,
    BLACK;

    private static final Collection<Crewmate> VALUES = Arrays.asList(values());

    /**
     * @return All types of Crewmates as Collection
     */
    public static Collection<Crewmate> getValues() {
        return VALUES;
    }
}
