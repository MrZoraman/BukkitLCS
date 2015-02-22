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
    
    public boolean registerCommand(String syntax, IBukkitLCSCommand command)
    {
        return lcs.registerCommand(syntax, command);
    }
    
    public void setSafeParsingMode(boolean mode)
    {
        lcs.setSafeParsingMode(mode);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args)
    {
        StringBuilder builder = new StringBuilder(256);
        builder.append(cmd.getName()).append(" ");
        for(int ii = 0; ii < args.length; ii++)
        {
            builder.append(args[ii]).append(" ");
        }
        String input = builder.toString();
        
        CommandResult<IBukkitLCSCommand> result = lcs.getCommand(input);
        if(result.command == null) return false;
        return result.command.onCommand(sender, cmd, alias, result.preArgs, result.args);
    }
}
