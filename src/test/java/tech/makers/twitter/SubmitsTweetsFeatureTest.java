package tech.makers.twitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.htmlunit.webdriver.MockMvcHtmlUnitDriverBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SubmitsTweetsFeatureTest {
    WebDriver driver;

    @TestConfiguration
    public static class TestTwitterApplicationConfig
    {
        @Bean
        public IClockService clockService()
        {
            return new MockedClockService();
        }

        private class MockedClockService implements IClockService {
            private Clock clock;

            public MockedClockService() {
                String instantExpected = "2021-01-01T01:00:00Z";
                ZoneId zoneId = ZoneId.systemDefault();
                clock = Clock.fixed(Instant.parse(instantExpected), zoneId);
            }

            public Clock getClock() {
                return this.clock;
            }
        }
    }

    @BeforeEach
    void setup(WebApplicationContext context) {
        driver = MockMvcHtmlUnitDriverBuilder
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void tweetIndexShouldSubmitAndDisplayTweets() throws Exception {
        driver.get("http://localhost:9990/");
        driver.findElement(By.id("tweet-form-body")).sendKeys("This is a tweet!");
        driver.findElement(By.id("tweet-form-submit")).click();
        assertThat(driver.findElement(By.tagName("body")).getText()).contains("This is a tweet!");
        assertThat(driver.findElement(By.tagName("body")).getText()).contains("2021-01-01 01:00");
    }
}
