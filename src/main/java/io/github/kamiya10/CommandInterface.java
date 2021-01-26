package io.github.kamiya10;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

//IMPORTANT: This is an interface, not a class.
public interface CommandInterface {

    // Every time I make a command, I will use this same method.
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args);

}