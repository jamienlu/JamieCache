package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Incr command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class IncrCommand implements Command {
    @Override
    public String name() {
        return "INCR";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        return Reply.integer(cache.incr(key));
    }
}
