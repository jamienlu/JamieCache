package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Set command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class SetCommand implements Command {
    @Override
    public String name() {
        return "SET";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        String val = getVal(args);
        cache.set(key, val);
        return Reply.string(OK);
    }
}
