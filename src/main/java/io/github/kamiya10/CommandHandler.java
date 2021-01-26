package io.github.kamiya10;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class CommandHandler implements CommandExecutor {

    // 保存指令的地方ouo
    private static HashMap<String, CommandInterface> commands = new HashMap<String, CommandInterface>();

    // 在onEnable()登錄指令會用到
    public void register(String name, CommandInterface cmd) {

        // 丟進hashmap的東東
        commands.put(name, cmd);
    }

    public boolean exists(String name) {
        return commands.containsKey(name);
    }

    public CommandInterface getExecutor(String name) {
        return commands.get(name);
    }

    // template
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (sender instanceof Player) {

            if (args.length == 0) {
                getExecutor("edge").onCommand(sender, cmd, commandLabel, args);
                return true;
            }

            if (args.length > 0) {

                if (exists(args[0])) {
                    getExecutor(args[0]).onCommand(sender, cmd, commandLabel, args);
                    return true;
                } else {
                    sender.sendMessage("未知的指令 (。>︿<)_θ");
                    return true;
                }

            }
        } else {
            sender.sendMessage(ChatColor.RED + "執行這個指令要是玩家");
            return true;
        }
        
        return false;
    }
}