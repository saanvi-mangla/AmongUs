package io.github.unjoinable.amongus;

import net.minestom.server.MinecraftServer;

public class AmongUs {

    public static void main(String[] args) {
        //Initialization
        MinecraftServer server = MinecraftServer.init();




        server.start("0.0.0.0", 25565);
    }
}