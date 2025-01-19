package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Lpush command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class LpushCommand implements Command {
    @Override
    public String name() {
        return "LPUSH";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        String[] vals = getParamsNoKey(args);
        return Reply.integer(cache.lpush(key, vals));
    }
}
