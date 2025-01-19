package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Hset command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class HsetCommand implements Command {
    @Override
    public String name() {
        return "HSET";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        String[] hkeys = getHkeys(args);
        String[] hvals = getHvals(args);
        return Reply.integer(cache.hset(key, hkeys, hvals));
    }

}
