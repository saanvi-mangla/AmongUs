package io.github.unjoinable.amongus.enums;

/**
 * @since 1.0.0
 * @author unjoinable
 */
public sealed interface GameMap {

    /**
     * @since 1.0.0
     * @author unjoinable
     */
    enum THE_SKELD implements GameMap {
        CAFETERIA,
        WEAPONS,
        NAVIGATION,
        O2,
        SHIELDS,
        COMMUNICATIONS,
        STORAGE,
        ADMIN,
        ELECTRICAL,
        LOWER_ENGINE,
        SECURITY,
        REACTOR,
        UPPER_ENGINE,
        MEDBAY,
        ;
    }

    /**
     * @since 1.0.0
     * @author unjoinable
     */
    enum POLUS implements GameMap {
        TO_BE_ADDED,
        ;
    }

    /**
     * @since 1.0.0
     * @author unjoinable
     */
    enum MIRA_HQ implements GameMap {
        TO_BE_ADDED,
        ;
    }
}

