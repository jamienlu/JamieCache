package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Lpop command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class LpopCommand implements Command {
    @Override
    public String name() {
        return "LPOP";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        int count = 1;
        if (args.length > 6) {
            String val = getVal(args);
            count = Integer.parseInt(val);
            return Reply.array(cache.lpop(key, count));
        }

        String[] lpop = cache.lpop(key, count);
        return Reply.bulkString(lpop == null ? null : lpop[0]);
    }
}
