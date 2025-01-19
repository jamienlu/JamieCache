package io.github.jamielu.jamiecache.command;

import io.github.jamielu.jamiecache.core.CacheMemory;
import io.github.jamielu.jamiecache.core.Command;
import io.github.jamielu.jamiecache.core.Commands;
import io.github.jamielu.jamiecache.core.Reply;

/**
 * @author jamieLu
 * @create 2024-06-25
 */
public class CommandCommand implements Command {
    @Override
    public String name() {
        return "COMMAND";
    }

    @Override
    public Reply<?> exec(CacheMemory cache, String[] args) {
        return Reply.array(Commands.getCommandNames());
    }
}
