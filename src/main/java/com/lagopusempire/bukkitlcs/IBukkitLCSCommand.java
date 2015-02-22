package com.lagopusempire.bukkitlcs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 *
 * @author MrZoraman
 */
public interface IBukkitLCSCommand
{
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] preArgs, String[] args);
}
