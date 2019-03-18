package ru.otus.homework3.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@ConfigurationProperties
public class YamlProps {
    private String locale;

    public Locale getLocale() {
        return new Locale(locale);
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
