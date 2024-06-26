package io.github.unjoinable.amongus.util;

import io.github.unjoinable.amongus.enums.Crewmate;
import net.kyori.adventure.text.Component;
import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.Player;
import net.minestom.server.network.packet.server.play.TeamsPacket;
import net.minestom.server.scoreboard.TeamBuilder;

import static io.github.unjoinable.amongus.util.MiniMessageTemplate.MM;

public class PlayerHeader {

    /**
     * @param player The player who we are adding to the team
     * @param crewmate The type of crewmate player is / will be
     */
    public static void setSussyHeader(Player player, Crewmate crewmate) {
        PlayerHeader.setPlayerHeader(player, crewmate.name(), MM."<color:\{crewmate.getColor()}><bold>\{crewmate.name().replaceAll("_", " ")}");
    }

    /**
     * @param player The player who we are adding to team
     * @param header The name of team
     * @param display The prefix of team
     */
    public static void setPlayerHeader(Player player, String header, Component display) {
        TeamBuilder builder = MinecraftServer.getTeamManager().createBuilder(header);
        builder.nameTagVisibility(TeamsPacket.NameTagVisibility.ALWAYS);
        builder.prefix(display);
        builder.collisionRule(TeamsPacket.CollisionRule.ALWAYS);
        player.setTeam(builder.build());
    }
}
