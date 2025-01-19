package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Srem command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class SremCommand implements Command {
    @Override
    public String name() {
        return "SREM";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        String[] vals = getParamsNoKey(args);
        return Reply.integer(cache.srem(key, vals));
    }
}
