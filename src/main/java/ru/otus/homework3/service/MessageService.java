package ru.otus.homework3.service;

public interface MessageService {
    String getMessage(String s);

    String getMessage(String s, Object... args);
}
