package ru.otus.homework3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.homework3.pojo.UserInfo;
import ru.otus.homework3.service.PrintService;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrintServiceTest {

    @Autowired
    PrintService printService;

    @Test
    public void shouldReturnQuizResultsInEnglishForUsersWithEnglishLocale() {
        Map<String, String> questionsToAnswers = new HashMap<>();
        questionsToAnswers.put("How old are you?", "11");
        questionsToAnswers.put("Do you have any pets?", "no");
        String quizResults = printService.getPrintResultsAsString(new UserInfo("Ivan", "Ivanov"), questionsToAnswers);
        String expected = "=============================================================" +
                System.lineSeparator() +
                "Quiz results for Ivan Ivanov:" +
                System.lineSeparator() +
                System.lineSeparator() +
                "question: How old are you?" +
                System.lineSeparator() +
                "answer: 11" +
                System.lineSeparator() +
                System.lineSeparator() +
                "question: Do you have any pets?" +
                System.lineSeparator() +
                "answer: no" +
                System.lineSeparator() +
                "=============================================================";
        assertThat(quizResults, equalTo(expected));
    }
}
