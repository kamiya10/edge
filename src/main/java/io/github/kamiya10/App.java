package io.github.kamiya10;

import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin {

    public void registerCommands() {
        CommandHandler handler = new CommandHandler();
 
        handler.register("edge", new edge());
        handler.register("gift", new gift());
        getCommand("edge").setExecutor(handler);
    }

    @Override
    public void onEnable() {
        this.registerCommands();
        getLogger().info("O 已啟用插件");
    }

    @Override
    public void onDisable() {
        getLogger().info("X 已停用插件");
    }
}