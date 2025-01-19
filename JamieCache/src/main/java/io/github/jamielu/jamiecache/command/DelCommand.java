package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Del command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class DelCommand implements Command {
    @Override
    public String name() {
        return "DEL";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String[] key = getParams(args);
        return Reply.integer(cache.del(key));
    }
}
