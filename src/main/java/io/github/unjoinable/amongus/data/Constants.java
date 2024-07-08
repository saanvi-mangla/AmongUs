package io.github.unjoinable.amongus.data;

import io.github.unjoinable.amongus.enums.CrewmateColor;
import net.minestom.server.MinecraftServer;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.registry.DynamicRegistry;
import net.minestom.server.world.DimensionType;

import java.nio.file.Path;

/**
 * @since 1.0.0
 * @author unjoinable
 */
public final class Constants {
    public static final String BRAND = "AmongUs";
    public static final Pos SKELD_SPAWN_POS = new Pos(86,6,76);
    public static final int PORT = 25565;
    public static final Path WORLD_PATH = Path.of("./Skeld/world/");
    public static final int GAME_INSTANCE_MAX_SIZE = CrewmateColor.getValues().size();
    public static final DimensionType FULL_BRIGHT_DIM = DimensionType.builder().ambientLight(2.0f).build();
    public static final DynamicRegistry.Key<DimensionType> DIMENSION = MinecraftServer.getDimensionTypeRegistry().register("dim", FULL_BRIGHT_DIM);

}
