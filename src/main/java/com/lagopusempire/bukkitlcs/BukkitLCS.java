package com.lagopusempire.bukkitlcs;

import com.lagopusempire.lagopuscommandsystem.CommandResult;
import com.lagopusempire.lagopuscommandsystem.CommandSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author MrZoraman
 */
public class BukkitLCS implements CommandExecutor 
{
    private final CommandSystem<IBukkitLCSCommand> lcs = new CommandSystem<>();
    
    public void registerCommand(String syntax, IBukkitLCSCommand command)
    {
        lcs.registerCommand(syntax, command);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args)
    {
        final StringBuilder builder = new StringBuilder(256);
        builder.append(cmd.getName()).append(" ");
        for(int ii = 0; ii < args.length; ii++)
        {
            builder.append(args[ii]).append(" ");
        }
        final String input = builder.toString();
        
        final CommandResult<IBukkitLCSCommand> result = lcs.getCommand(input);
        if(result.command == null) return false;
        return result.command.onCommand(sender, cmd, alias, result.preArgs, result.args);
    }
}
