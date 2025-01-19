package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Hexists command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class HexistsCommand implements Command {
    @Override
    public String name() {
        return "HEXISTS";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        String hkey = getVal(args);
        return Reply.integer(cache.hexists(key, hkey));
    }

}
