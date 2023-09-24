package net.kore.aura;

import net.kore.aura.api.Chat;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Aura extends JavaPlugin implements AuraAPI {

    public Chat chat;
    public BukkitAudiences audience;
    public Logger logger;

    @Override
    public void onEnable() {
        //Logger
        logger = Bukkit.getLogger();

        //ChatAPI registeration
        audience = BukkitAudiences.create(this);
        chat = new Chat(audience);

        //Log the logo
        logLogo();
    }

    @Override
    public void onDisable() {
        logger.warning("Aura is now disabling, if this was a reload please consider restarting instead of reloading as reloading causes issues! You have been warned.");
    }

    public void logLogo() {
        logger.info("+-----------------------------------------------------------------------------+");
        logger.info("|                                                                             |");
        logger.info("|                                                                             |");
        logger.info("|                                                                             |");
        logger.info("|                   ██████████████████████████████████████                    |");
        logger.info("|                   ██████████████████████████████████████                    |");
        logger.info("|                   ██████████████████████████████████████                    |");
        logger.info("|                   ██████████████████████████████████████                    |");
        logger.info("|                   ██████████████████████████████████████                    |");
        logger.info("|                   ██████████████████████████████████████                    |");
        logger.info("|                   ████████████              ████████████                    |");
        logger.info("|                   ████████████              ████████████                    |");
        logger.info("|                   ████████████              ████████████                    |");
        logger.info("|                   ████████████              ████████████                    |");
        logger.info("|                   ████████████              ████████████                    |");
        logger.info("|                   ████████████              ████████████                    |");
        logger.info("|                   ██████████████████████████████████████                    |");
        logger.info("|                   ██████████████████████████████████████                    |");
        logger.info("|                   ██████████████████████████████████████                    |");
        logger.info("|                   ██████████████████████████████████████                    |");
        logger.info("|                   ██████████████████████████████████████                    |");
        logger.info("|                   ██████████████████████████████████████                    |");
        logger.info("|                   ████████████              ████████████                    |");
        logger.info("|                   ████████████              ████████████                    |");
        logger.info("|                   ████████████              ████████████                    |");
        logger.info("|                   ████████████              ████████████                    |");
        logger.info("|                   ████████████              ████████████                    |");
        logger.info("|                   ████████████              ████████████                    |");
        logger.info("|                                                                             |");
        logger.info("|                                                                             |");
        logger.info("|                                                                             |");
        logger.info("+-----------------------------------------------------------------------------+");
        logger.info("AuraAPI - By the Kore team");
        logger.info("Version - " + getPluginMeta().getVersion());
        logger.info("Main class - " + getPluginMeta().getMainClass());
        logger.info("Authors" + StringUtils.join(getPluginMeta().getAuthors(), ", "));
    }

    @Override
    public Chat getChat() {
        return chat;
    }

    public static AuraAPI getAPI() throws Exception {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("AuraAPI");

        if (plugin instanceof AuraAPI) {
            return (AuraAPI) plugin;
        } else {
            throw new Exception("""
                    PluginManager returns a unknown plugin, here are a few reasons:
                      - AuraAPI was not implemented properly
                      - There is something wrong with the Bukkit PluginManager
                      - Aura is not enabled
                      - Something else unknown
                    """);
        }
    }
}
