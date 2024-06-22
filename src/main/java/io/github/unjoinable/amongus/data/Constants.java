package io.github.unjoinable.amongus.data;

import io.github.unjoinable.amongus.enums.Crewmate;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.world.DimensionType;

import java.nio.file.Path;

public final class Constants {
    public static final String BRAND = "AmongUs";
    public static final Pos SKELD_SPAWN_POS = new Pos(0,100,0);
    public static final int PORT = 25565;
    public static final Path WORLD_PATH = Path.of("./world/");
    public static final int GAME_INSTANCE_MAX_SIZE = Crewmate.getValues().size();
    public static final DimensionType FULL_BRIGHT_DIM = DimensionType.builder().ambientLight(2.0f).build();
}
