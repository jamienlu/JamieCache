package io.github.jamielu.jamiecache.core;

import io.github.jamielu.jamiecache.command.CommandCommand;
import io.github.jamielu.jamiecache.command.DecrCommand;
import io.github.jamielu.jamiecache.command.DelCommand;
import io.github.jamielu.jamiecache.command.ExistsCommand;
import io.github.jamielu.jamiecache.command.GetCommand;
import io.github.jamielu.jamiecache.command.HdelCommand;
import io.github.jamielu.jamiecache.command.HexistsCommand;
import io.github.jamielu.jamiecache.command.HgetCommand;
import io.github.jamielu.jamiecache.command.HgetallCommand;
import io.github.jamielu.jamiecache.command.HlenCommand;
import io.github.jamielu.jamiecache.command.HmgetCommand;
import io.github.jamielu.jamiecache.command.HsetCommand;
import io.github.jamielu.jamiecache.command.IncrCommand;
import io.github.jamielu.jamiecache.command.InfoCommand;
import io.github.jamielu.jamiecache.command.LindexCommand;
import io.github.jamielu.jamiecache.command.LlenCommand;
import io.github.jamielu.jamiecache.command.LpopCommand;
import io.github.jamielu.jamiecache.command.LpushCommand;
import io.github.jamielu.jamiecache.command.LrangeCommand;
import io.github.jamielu.jamiecache.command.MgetCommand;
import io.github.jamielu.jamiecache.command.MsetCommand;
import io.github.jamielu.jamiecache.command.PingCommand;
import io.github.jamielu.jamiecache.command.RpopCommand;
import io.github.jamielu.jamiecache.command.RpushCommand;
import io.github.jamielu.jamiecache.command.SaddCommand;
import io.github.jamielu.jamiecache.command.ScardCommand;
import io.github.jamielu.jamiecache.command.SetCommand;
import io.github.jamielu.jamiecache.command.SismemberCommand;
import io.github.jamielu.jamiecache.command.SmembersCommand;
import io.github.jamielu.jamiecache.command.SpopCommand;
import io.github.jamielu.jamiecache.command.SremCommand;
import io.github.jamielu.jamiecache.command.StrlenCommand;
import io.github.jamielu.jamiecache.command.ZaddCommand;
import io.github.jamielu.jamiecache.command.ZcardCommand;
import io.github.jamielu.jamiecache.command.ZcountCommand;
import io.github.jamielu.jamiecache.command.ZrankCommand;
import io.github.jamielu.jamiecache.command.ZremCommand;
import io.github.jamielu.jamiecache.command.ZscoreCommand;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author jamieLu
 * @create 2024-06-25
 */
public class Commands {
    private static Map<String, Command> ALL = new LinkedHashMap<>();

    static {
        // server连上返回所有可执行命令
        initCommands();
    }
    private static void initCommands() {
        // common commands
        register(new PingCommand());
        register(new InfoCommand());
        register(new CommandCommand());

        // string
        register(new SetCommand());
        register(new GetCommand());
        register(new StrlenCommand());
        register(new DelCommand());
        register(new ExistsCommand());
        register(new IncrCommand());
        register(new DecrCommand());
        register(new MsetCommand());
        register(new MgetCommand());

        // list
        register(new LpushCommand());
        register(new LpopCommand());
        register(new RpopCommand());
        register(new RpushCommand());
        register(new LlenCommand());
        register(new LindexCommand());
        register(new LrangeCommand());

        // set
        register(new SaddCommand());
        register(new SmembersCommand());
        register(new SremCommand());
        register(new ScardCommand());
        register(new SpopCommand());
        register(new SismemberCommand());

        // hash
        register(new HsetCommand());
        register(new HgetCommand());
        register(new HgetallCommand());
        register(new HlenCommand());
        register(new HdelCommand());
        register(new HexistsCommand());
        register(new HmgetCommand());

        // zset
        register(new ZaddCommand());
        register(new ZcardCommand());
        register(new ZscoreCommand());
        register(new ZremCommand());
        register(new ZrankCommand());
        register(new ZcountCommand());


    }

    public static void register(Command command) {
        ALL.put(command.name(), command);
    }
    public static Command get(String name) {
        return ALL.get(name);
    }

    public static String[] getCommandNames() {
        return ALL.keySet().toArray(new String[0]);
    }
}
