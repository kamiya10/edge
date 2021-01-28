package io.github.kamiya10;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    public static Main plugin;
    FileConfiguration config = getConfig();

    public void registerCommands() {
        CommandHandler handler = new CommandHandler();
 
        handler.register("edge", new edge());
        handler.register("gift", new gift());
        getCommand("edge").setExecutor(handler);
        getCommand("edge").setTabCompleter(new TabComplete());
    }

    @Override
    public void onEnable() {
        config.addDefault("MessageOnGet", "你獲得了Discord帳號連結獎勵");
        config.addDefault("item", "TRIPWIRE_HOOK");
        config.options().copyDefaults(true);
        saveConfig();
        plugin = this;
        this.registerCommands();
        getLogger().info("⭕️ 已啟用插件");
    }

    @Override
    public void onDisable() {
        getLogger().info("❌ 已停用插件");
    }
}