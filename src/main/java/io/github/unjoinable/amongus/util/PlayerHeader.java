package io.github.unjoinable.amongus.util;

import io.github.unjoinable.amongus.enums.CrewmateColor;
import net.kyori.adventure.text.Component;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.network.packet.server.play.TeamsPacket;
import net.minestom.server.scoreboard.TeamBuilder;

import java.util.UUID;

import static io.github.unjoinable.amongus.util.MiniMessageTemplate.MM;

public class PlayerHeader {

    /**
     * @param player The player who we are adding to the team
     * @param crewmateColor The type of crewmateColor player is / will be
     */
    public static void setSussyHeader(Player player, CrewmateColor crewmateColor) {
        PlayerHeader.setPlayerHeader(player, MM."<bold>\{crewmateColor.name().replaceAll("_", " ")} ".color(crewmateColor.getColor()));
    }

    /**
     * @param player The player who we are adding to team
     * @param display The prefix of team
     */
    public static void setPlayerHeader(Player player, Component display) {
        TeamBuilder builder = MinecraftServer.getTeamManager().createBuilder(UUID.randomUUID().toString());
        builder.nameTagVisibility(TeamsPacket.NameTagVisibility.ALWAYS);
        builder.prefix(display);
        builder.collisionRule(TeamsPacket.CollisionRule.ALWAYS);
        player.setTeam(builder.build());
    }
}
