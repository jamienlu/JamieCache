package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

import java.util.Arrays;

/**
 * Zadd command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class ZaddCommand implements Command {
    @Override
    public String name() {
        return "ZADD";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        String key = getKey(args);
        String[] scores = getHkeys(args);
        String[] vals = getHvals(args);
        return Reply.integer(cache.zadd(key, vals, toDouble(scores)));
    }

    double[] toDouble(String[] scores) {
        return Arrays.stream(scores).mapToDouble(Double::parseDouble).toArray();
    }
}
