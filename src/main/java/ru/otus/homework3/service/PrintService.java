package ru.otus.homework3.service;


import ru.otus.homework3.pojo.UserInfo;

import java.util.Map;

public interface PrintService {
    String getPrintResultsAsString(UserInfo userInfo, Map<String, String> questionsToAnswers);
}
