package io.github.unjoinable.amongus.commands;

import io.github.unjoinable.amongus.AmongUs;
import io.github.unjoinable.amongus.GameInstance;
import io.github.unjoinable.amongus.enums.Crewmate;
import net.minestom.server.command.builder.Command;
import net.minestom.server.entity.Player;


public class TestCommand extends Command {
    public TestCommand() {
        super("test");
        addSyntax((sender, _) -> {
            Player player = ((Player) sender);
            GameInstance instance = AmongUs.getInstanceStorage().createInstance();
            instance.addPlayer(player, Crewmate.BLACK);
            instance.start();
        });
    }
}
