package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * MSet command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class MsetCommand implements Command {
    @Override
    public String name() {
        return "MSET";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String[] keys = getKeys(args);
        String[] vals = getVals(args);
        cache.mset(keys, vals);
        return Reply.string(OK);
    }

}
