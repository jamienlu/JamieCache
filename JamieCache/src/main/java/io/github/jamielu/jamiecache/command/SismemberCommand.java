package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Sismember command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class SismemberCommand implements Command {
    @Override
    public String name() {
        return "SISMEMBER";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        String val = getVal(args);
        return Reply.integer(cache.sismember(key, val));
    }
}
