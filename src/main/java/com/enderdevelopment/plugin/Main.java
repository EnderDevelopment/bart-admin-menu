package com.enderdevelopment.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.event.ClickEvent;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("bart")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                openAdminMenu(player);
                return true;
            } else {
                sender.sendMessage("This command can only be run by a player.");
                return false;
            }
        }
        return false;
    }

    private void openAdminMenu(Player player) {
        // Create and send the admin menu components
        Component menuTitle = Component.text("Bart Admin Menu").color(NamedTextColor.GOLD);
        Component menuItem1 = Component.text("Option 1").color(NamedTextColor.AQUA).clickEvent(ClickEvent.runCommand("/option1"));
        Component menuItem2 = Component.text("Option 2").color(NamedTextColor.AQUA).clickEvent(ClickEvent.runCommand("/option2"));
        Component menuItem3 = Component.text("Option 3").color(NamedTextColor.AQUA).clickEvent(ClickEvent.runCommand("/option3"));

        player.sendMessage(menuTitle);
        player.sendMessage(menuItem1);
        player.sendMessage(menuItem2);
        player.sendMessage(menuItem3);
    }
}