package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * HGET command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class HgetCommand implements Command {
    @Override
    public String name() {
        return "HGET";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        String hkey = getVal(args);
        return Reply.bulkString(cache.hget(key, hkey));
    }

}
