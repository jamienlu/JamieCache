package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Lrange command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class LrangeCommand implements Command {
    @Override
    public String name() {
        return "LRANGE";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        String[] params = getParamsNoKey(args);
        int start = Integer.parseInt(params[0]);
        int end = Integer.parseInt(params[1]);
        return Reply.array(cache.lrange(key, start, end));
    }
}
