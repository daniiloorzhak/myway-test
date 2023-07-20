package ru.oorzhak.mywaytest.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import ru.oorzhak.mywaytest.MainView;
import ru.oorzhak.mywaytest.MywayTestApplication;
import ru.oorzhak.mywaytest.repository.ChangeRepository;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = MywayTestApplication.class)
@TestPropertySource(locations = "classpath:test.yml")
@ActiveProfiles("integration")
class MainViewTest {
    @Autowired
    private MainView mainView;
    @Autowired
    private ChangeRepository changeRepository;

    @Test
    void mainTest() {
        // startup value
        Assertions.assertTrue(changeRepository.existsByValue((long) 0));

        mainView.incrementButton.click();
        Assertions.assertTrue(changeRepository.existsByValue((long) 1));

        mainView.decrementButton.click();
        mainView.decrementButton.click();
        Assertions.assertTrue(changeRepository.existsByValue((long) -1));

        mainView.integerField.setValue(123);
        Assertions.assertTrue(changeRepository.existsByValue((long) 123));

        mainView.integerField.setValue(-123);
        Assertions.assertTrue(changeRepository.existsByValue((long) -123));
    }
}
