package net.kore.aura.api;

import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class Chat {

    private final BukkitAudiences adventure;

    public Chat(BukkitAudiences audience) {
        this.adventure = audience;
    }
    public @NonNull BukkitAudiences adventure() {
        if(this.adventure == null) {
            throw new IllegalStateException("Cannot access adventure while Aura is disabled!");
        }

        return this.adventure;
    }

    public boolean SendMessage(Player player, String message) {
        try {
            StringBuilder construct = new StringBuilder();
            String[] messageParts = message.split("<br>");
            for (int i = 0; i < messageParts.length; i++) {
                String part = messageParts[i];

                if (i > 0) {
                    construct.append("\n");
                }
                construct.append(part);
            }
            Component component = LegacyComponentSerializer.legacyAmpersand().deserialize(PlaceholderAPI.setPlaceholders(player, construct.toString()));
            adventure().player(player).sendMessage(component);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean SendMessage(CommandSender sender, String message) {
        try {
            StringBuilder construct = new StringBuilder();
            String[] messageParts = message.split("<br>");
            for (int i = 0; i < messageParts.length; i++) {
                String part = messageParts[i];

                if (i > 0) {
                    construct.append("\n");
                }
                construct.append(part);
            }
            OfflinePlayer player;
            String msg;
            try {
                player = (OfflinePlayer) sender;
                msg = PlaceholderAPI.setPlaceholders(player, construct.toString());
            } catch (Exception e) {
                msg = construct.toString();
            }
            Component component = LegacyComponentSerializer.legacyAmpersand().deserialize(msg);
            adventure().sender(sender).sendMessage(component);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Component CreateComponent(String message) {
        try {
            StringBuilder construct = new StringBuilder();
            String[] messageParts = message.split("<br>");
            for (int i = 0; i < messageParts.length; i++) {
                String part = messageParts[i];

                if (i > 0) {
                    construct.append("\n");
                }
                construct.append(part);
            }
            return LegacyComponentSerializer.legacyAmpersand().deserialize(construct.toString());
        } catch (Exception e) {
            return LegacyComponentSerializer.legacyAmpersand().deserialize("&4Unable to create component.");
        }
    }

    public Component CreateComponent(String message, Player player) {
        try {
            StringBuilder construct = new StringBuilder();
            String[] messageParts = message.split("<br>");
            for (int i = 0; i < messageParts.length; i++) {
                String part = messageParts[i];

                if (i > 0) {
                    construct.append("\n");
                }
                construct.append(part);
            }
            return LegacyComponentSerializer.legacyAmpersand().deserialize(PlaceholderAPI.setPlaceholders(player, construct.toString()));
        } catch (Exception e) {
            return LegacyComponentSerializer.legacyAmpersand().deserialize("&4Unable to create component.");
        }
    }

    public boolean SendComponent(Player player, Component component) {
        try {
            adventure().player(player).sendMessage(component);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
