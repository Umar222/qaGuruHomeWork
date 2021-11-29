package ru.umar.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:configs/configs.properties"})
public interface CredentialsConfig extends Config {
    String login();
    String password();
    String urlType();
    String URL(String login, String password, String urlType);
}
