package io.github.unjoinable.amongus.commands;

import io.github.unjoinable.amongus.AmongUs;
import io.github.unjoinable.amongus.game.GameInstance;
import io.github.unjoinable.amongus.enums.Crewmate;
import io.github.unjoinable.amongus.gui.guis.GUIUnlockManifolds;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.builder.Command;
import net.minestom.server.entity.Player;
import net.minestom.server.timer.TaskSchedule;


public class TestCommand extends Command {
    public TestCommand() {
        super("test");
        addSyntax((sender, _) -> {
            Player player = ((Player) sender);
            GameInstance instance = AmongUs.getInstanceStorage().createInstance();
            instance.addPlayer(player, Crewmate.BLACK);
            instance.start();
            MinecraftServer.getSchedulerManager().scheduleTask(() -> {
                new GUIUnlockManifolds().open(player);
            },TaskSchedule.tick(100), TaskSchedule.stop());
        });
    }
}
