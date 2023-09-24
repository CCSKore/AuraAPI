# AuraAPI
AuraAPI allows you to make your plugin with ease, providing simplier methods for sending messages to players in the & format and more!

## Development
To add AuraAPI into your Gradle project you can use the JAR file from the download
```groovy
dependencies {
  compileOnly fileTree(dir: 'folder/path/where/jar/is', include: '*.jar')
}
```

Now in your plugin's main class you can import the following classes/interfaces
```java
import net.kore.aura.Aura;
import net.kore.aura.AuraAPI;
```

In your plugin's main class make sure that aura is defined
```java
public AuraAPI aura;
```

Next in your `onEnable` function you can get the API (This example includes error handling)
```java
@Override
public void onEnable() {
    try {
        aura = Aura.getAPI();
    } catch (Exception e) {
        Bukkit.getLogger().severe("Missing AuraAPI! Plugin will now disable. You can see details of why AuraAPI was not found below");
        getServer().getPluginManager().disablePlugin(this);
        throw new RuntimeException(e);
    }
}
```

Now using AuraAPI is simple! Let's give an example, send a welcome message when a player joins the server
```java
public class PlayerJoin implements Listener {
    MyPluginMainClass plugin;

    public PlayerJoin(MyPluginMainClass plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event) {
        plugin.aura.getChat().SendMessage(event.getPlayer(), "&6Welcome "+event.getPlayer().displayName()+"!");
    }
}
```

To keep things efficient you may consider only calling `aura.getChat()` once
```java
public Chat achat; //Remember to import `net.kore.aura.api.Chat`

@Override
public void onEnable() {
    try {
        aura = Aura.getAPI();
        achat = aura.getChat();
    } catch (Exception e) {
        Bukkit.getLogger().severe("Missing AuraAPI! Plugin will now disable. You can see details of why AuraAPI was not found below");
        getServer().getPluginManager().disablePlugin(this);
        throw new RuntimeException(e);
    }
}
```

More soon...
