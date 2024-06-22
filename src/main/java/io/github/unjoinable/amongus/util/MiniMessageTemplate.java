package io.github.unjoinable.amongus.util;

import io.github.unjoinable.amongus.AmongUs;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

public final class MiniMessageTemplate {

    public static final StringTemplate.Processor<Component, RuntimeException> MM = stringTemplate -> {
        String interpolated = STR.process(stringTemplate);
        return toComponent(interpolated);
    };

    public static Component toComponent(String string) {
        return AmongUs.getMiniMessage().deserialize("<!i>" + string);
    }

    public static String fromComponent(Component component) {
        return PlainTextComponentSerializer.plainText().serialize(component);
    }
}



