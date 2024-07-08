package io.github.unjoinable.amongus.enums;

import net.kyori.adventure.text.format.TextColor;

import java.util.Arrays;
import java.util.Collection;

/*
REMOVED DUE TO NOT FINDING THEM ON WIKI PAGE
    TEAL(TextColor.color(0x008080)),
    SILVER(TextColor.color(0xC0C0C0)),
    GOLD(TextColor.color(0xFFD700)),
 */
@SuppressWarnings("all") // disable spell check
public enum CrewmateColor {
    RED(TextColor.color(0xC61111)),
    ORANGE(TextColor.color(0xF07D0D)),
    YELLOW(TextColor.color(0xF6F657)),
    BANANA(TextColor.color(0xFFFEBE)),
    CYAN(TextColor.color(0x38E2DD)),
    PINK(TextColor.color(0xEE54BB)),
    PEACH(TextColor.color(0xFFE5B4)),
    WHITE(TextColor.color(0xD7E1F1)),
    BROWN(TextColor.color(0x71491E)),
    MAROON(TextColor.color(0x6B2B3C)),
    ROSE(TextColor.color(0xECC0D3)),
    PURPLE(TextColor.color(0x6B2FBC)),
    BLUE(TextColor.color(0x132ED2)),
    LIGHT_BLUE(TextColor.color(0xADD8E6)),
    LIME(TextColor.color(0x50F039)),
    GREEN(TextColor.color(0x11802D)),
    GREY(TextColor.color(0x708496)),
    TAN(TextColor.color(0x928776)),
    CORAL(TextColor.color(0xEC7578)),
    BLACK(TextColor.color(0x3F474E));

    private final TextColor color;

    CrewmateColor(TextColor color) {
        this.color = color;
    }

    private static final Collection<CrewmateColor> VALUES = Arrays.asList(values());

    /**
     * @return All types of Crewmates as Collection
     */
    public static Collection<CrewmateColor> getValues() {
        return VALUES;
    }

    /**
     * @return Color of crewmate
     */
    public TextColor getColor() {
        return color;
    }
}
