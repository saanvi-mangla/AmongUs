package io.github.unjoinable.amongus.entity;

import net.kyori.adventure.text.Component;

import net.minestom.server.entity.Entity;
import net.minestom.server.entity.EntityType;
import net.minestom.server.entity.PlayerSkin;
import org.jetbrains.annotations.NotNull;
/*
TODO FINISH THIS CLASS
 */
import java.util.UUID;

/**
 * @since 1.0.0
 * @author unjoinable
 */
public class NonPlayerCharacter extends Entity {
    private final Component name;
    private final PlayerSkin skin;
    private final UUID uuid;

    /**
     * @param name The name of npc we want to show
     * @param skin The skin of npc
     * @since 1.0.0
     * @author unjoinable
     */
    public NonPlayerCharacter(@NotNull Component name, @NotNull PlayerSkin skin) {
        super(EntityType.PLAYER, UUID.randomUUID());
        this.name = name;
        this.skin = skin;
        this.uuid = this.getUuid();
    }



}
