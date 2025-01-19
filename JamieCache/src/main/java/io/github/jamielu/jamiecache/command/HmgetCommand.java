package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * HMGET command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class HmgetCommand implements Command {
    @Override
    public String name() {
        return "HMGET";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        String[] hkeys = getParamsNoKey(args);
        return Reply.array(cache.hmget(key, hkeys));
    }

}
