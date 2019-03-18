package ru.otus.homework3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.homework3.dao.QuizDao;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CsvQuizDaoTest {

    @Autowired
    QuizDao quizDao;

    @Test
    public void shouldReturnQuestionsInEnglishForUsersWithEnglishLocale() {
        List<String> questions = quizDao.getQuestions();
        assertThat(questions, hasSize(3));
        assertThat(questions, contains("What is your favorite color?", "How old are you?", "Do you have any pets?"));
    }
}

