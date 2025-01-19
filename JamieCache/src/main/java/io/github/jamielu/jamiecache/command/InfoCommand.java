package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * Info command.
 *
 * @Author : jamieLu
 * @create 2024/6/25
 */
public class InfoCommand implements Command {

    private static final String INFO = "CacheMemory Server[v1.0.1], created by kimmking." + CRLF
            + "Mock Redis Server, at 2024-06-19 in Beijing." + CRLF;


    @Override
    public String name() {
        return "INFO";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        return Reply.bulkString(INFO);
    }
}
