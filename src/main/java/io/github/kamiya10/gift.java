package io.github.kamiya10;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.dependencies.jda.api.entities.User;
import github.scarsz.discordsrv.util.DiscordUtil;

public class gift implements CommandInterface {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;
 
        //We don't have to check if the args length is equal to one, but you will have to check if it is greater than 1.
        if(args.length > 1) return false;
        String discordId = DiscordSRV.getPlugin().getAccountLinkManager().getDiscordId(p.getUniqueId());
        if (discordId == null) {
            p.sendMessage(ChatColor.RED + "你沒有連結到Discord帳號");
            return false;
        }

        User user = DiscordUtil.getJda().getUserById(discordId);
        if (user == null) {
            p.sendMessage(ChatColor.YELLOW + "找不到你連結的Discord帳號");
            return false;
        }
        
        ItemStack[] items = {new ItemStack(Material.getMaterial(Main.plugin.getConfig().getString("item")))};
        p.getInventory().addItem(items);
        p.sendMessage(Main.plugin.getConfig().getString("MessageOnGet"));
        return false;
    }
    
}
