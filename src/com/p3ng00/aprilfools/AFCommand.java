package com.p3ng00.aprilfools;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

// Purposely left out 'TabCompleter' interface so that people don't accidentally discover the command
public class AFCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (args.length != 1) {
            sender.sendMessage("/AprilFools [Enable/Disable]");
            return true;
        }
        AprilFools.ENABLED = args[0].equalsIgnoreCase("Enable");
        return true;
    }
}
