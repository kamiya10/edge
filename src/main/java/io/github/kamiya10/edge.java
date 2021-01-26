package io.github.kamiya10;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class edge implements CommandInterface {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;
        p.sendMessage("Edge Plugin v0.1 by Kamiya");
        return false;
    }
    
}
