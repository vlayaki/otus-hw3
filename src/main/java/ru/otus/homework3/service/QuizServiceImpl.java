package ru.otus.homework3.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.homework3.dao.QuizDao;
import ru.otus.homework3.pojo.UserInfo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuizServiceImpl implements QuizService {
    private static final Scanner scanner = new Scanner(System.in);

    private final QuizDao quizDao;
    private final PrintService printService;
    private final MessageService messageService;

    @Override
    public void startQuiz() {
        UserInfo userInfo = collectUserInfo();
        Map<String, String> questionsToAnswers = conductQuiz();
        log.info(printService.getPrintResultsAsString(userInfo, questionsToAnswers));
    }

    private UserInfo collectUserInfo(){
        log.info(messageService.getMessage("msg.name.first"));
        String firstName = scanner.nextLine();
        log.info(messageService.getMessage("msg.name.last"));
        String lastName = scanner.nextLine();
        return new UserInfo(firstName, lastName);
    }

    private Map<String, String> conductQuiz(){
        log.info(messageService.getMessage("msg.answer.questions"));
        List<String> questions = quizDao.getQuestions();
        Map<String, String> questionsToAnswers = new LinkedHashMap<>();
        for (String question : questions) {
            log.info(question);
            questionsToAnswers.put(question, scanner.nextLine());
        }
        return questionsToAnswers;
    }
}
