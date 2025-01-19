package io.github.jamielu.jamiecache.conf;

import io.github.jamielu.jamiecache.core.CachePlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jamieLu
 * @create 2024-06-25
 */
@Component
public class JmApplicationListener implements ApplicationListener<ApplicationEvent> {
    @Autowired
    List<CachePlugin> cachePlugins;
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof  ApplicationEvent) {
            cachePlugins.forEach(plugin -> {
                plugin.init();
                plugin.startup();
            });

        } else if (event instanceof ContextClosedEvent) {
            cachePlugins.forEach(CachePlugin::shutdown);
        }
    }
}
