package io.github.unjoinable.amongus.enums;

import java.util.Arrays;
import java.util.Collection;

@SuppressWarnings("all") // disable spell check
public enum Crewmate {
    RED("FF0000"),
    ORANGE("FFA500"),
    YELLOW("FFFF00"),
    PINK("FFC0CB"),
    PEACH("FFE5B4"),
    WHITE("FFFFFF>"),
    GOLD("<color:FFD700"),
    LIGHT_BROWN("BF651D"),
    MAROON("800000"),
    PURPLE("800080"),
    BLUE("0000FF"),
    LIGHT_BLUE("ADD8E6"),
    LIME("BFFF00"),
    GREEN("00FF00"),
    TEAL("008080"),
    SILVER("C0C0C0"),
    GREY("808080"),
    BLACK("000000");

    private final String color;

    Crewmate(String color) {
        this.color = color;
    }

    private static final Collection<Crewmate> VALUES = Arrays.asList(values());

    /**
     * @return All types of Crewmates as Collection
     */
    public static Collection<Crewmate> getValues() {
        return VALUES;
    }

    /**
     * @return Hex color of crewmate #color where color is what you get
     */
    public String getColor() {
        return color;
    }
}
