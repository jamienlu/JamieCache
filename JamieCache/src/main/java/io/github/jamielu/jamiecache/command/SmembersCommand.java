package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Smembers command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class SmembersCommand implements Command {
    @Override
    public String name() {
        return "SMEMBERS";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        return Reply.array(cache.smembers(key));
    }
}
