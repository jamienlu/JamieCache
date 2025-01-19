package io.github.jamielu.jamiecache.core;

/**
 * @author jamieLu
 * @create 2024-06-25
 */
public interface CachePlugin {
    void init();
    void startup();
    void shutdown();

}
