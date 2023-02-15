package com.orderneat.orderneat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YamlConfig {

    private String name;
    private String environment;
    private boolean enabled;
    private List<String> servers = new ArrayList<>();
    private String jwtSecretKey = "1222DJFAF324GHAEUIBA23424BAUFAUI3242awaefjaeiajfeairjaadfaAEGAEGAEAEFAEFA342532rjeahahahaeheheh";
    private long jwtTokenExpiration = 30;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }

    public String getJwtSecretKey() {
        return jwtSecretKey;
    }

    public void setJwtSecretKey(String jwtSecretKey) {
        this.jwtSecretKey = jwtSecretKey;
    }

    public long getJwtTokenExpiration() {
        return jwtTokenExpiration;
    }

    public void setJwtTokenExpiration(long jwtTokenExpiration) {
        this.jwtTokenExpiration = jwtTokenExpiration;
    }
}
