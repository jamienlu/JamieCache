package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * HDEL command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class HdelCommand implements Command {
    @Override
    public String name() {
        return this.getClass().getSimpleName()
                .replace("Command", "").toUpperCase();
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        String[] hkeys = getParamsNoKey(args);
        return Reply.integer(cache.hdel(key, hkeys));
    }

}
