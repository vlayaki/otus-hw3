package ru.otus.homework3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.otus.homework3.config.AppConfig;
import ru.otus.homework3.config.YamlProps;
import ru.otus.homework3.service.QuizService;

@SpringBootApplication
@EnableConfigurationProperties(YamlProps.class)
public class Homework3Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework3Application.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        QuizService quizService = context.getBean(QuizService.class);
        quizService.startQuiz();
    }

}
