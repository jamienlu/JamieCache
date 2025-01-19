package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Zcount command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class ZcountCommand implements Command {
    @Override
    public String name() {
        return "ZCOUNT";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        double min = Double.parseDouble(getVal(args));
        double max = Double.parseDouble(args[8]);
        return Reply.integer(cache.zcount(key, min, max));
    }
}
