package me.eureka.penis.esp;

import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class Addon extends MeteorAddon {
    private final Logger LOG = LoggerFactory.getLogger(Addon.class);

    @Override
    public void onInitialize() {
        LOG.info("Initializing Penis Addon.");
        MeteorClient.EVENT_BUS.registerLambdaFactory("me.eureka.penis.esp", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));

        Modules.get().add(new PenisEsp());

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            LOG.info("Thanks for using Penis-ESP addon, don't forget to star my repo :)");
        }));
    }

    @Override
    public String getPackage() {
        return "me.eureka.penis.esp";
    }
}
