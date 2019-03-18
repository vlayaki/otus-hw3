package ru.otus.homework3.dao;

import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.homework3.config.YamlProps;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CsvQuizDao implements QuizDao {

    private static final String FILE_PREFIX = "questions";
    private final YamlProps yamlProps;

    @Override
    public List<String> getQuestions() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream(buildFileName(yamlProps.getLocale()));
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(is))){
            return csvReader.readAll().
                    stream().
                    map(line -> line[0]).
                    collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String buildFileName(Locale locale) {
        return FILE_PREFIX + "_" + locale.toString() + ".csv";
    }
}
