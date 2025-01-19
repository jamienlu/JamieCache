package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Lindex command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class LindexCommand implements Command {
    @Override
    public String name() {
        return "LINDEX";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        int index = Integer.parseInt(getVal(args));
        return Reply.bulkString(cache.lindex(key, index));
    }
}
