package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Mget command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class MgetCommand implements Command {
    @Override
    public String name() {
        return "MGET";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String[] keys = getParams(args);
        return Reply.array(cache.mget(keys));
    }
    
}
