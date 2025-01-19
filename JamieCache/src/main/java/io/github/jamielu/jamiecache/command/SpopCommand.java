package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Spop command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class SpopCommand implements Command {
    @Override
    public String name() {
        return "SPOP";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        int count = 1;
        if (args.length > 6) {
            String val = getVal(args);
            count = Integer.parseInt(val);
            return Reply.array(cache.spop(key, count));
        }

        String[] spop = cache.spop(key, count);
        return Reply.bulkString(spop == null ? null : spop[0]);
    }
}
