package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Zscore command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class ZscoreCommand implements Command {
    @Override
    public String name() {
        return "ZSCORE";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        String val = getVal(args);
        Double zscore = cache.zscore(key, val);
        return Reply.string(zscore == null ? null : zscore.toString());
    }
}
