package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Ping command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class PingCommand implements Command {
    @Override
    public String name() {
        return "PING";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String ret = "PONG";
        if(args.length >= 5) {
            ret = args[4];
        }
        return Reply.string(ret);
    }
}
