package tech.makers.twitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TweetTest {
    private Clock mockClock;

    @BeforeEach
    void setup() {
        String instantExpected = "2021-01-01T00:00:00Z";
        ZoneId zoneId = ZoneId.systemDefault();
        mockClock = Clock.fixed(Instant.parse(instantExpected), zoneId);
    }

    @Test
    void testConstructs() {
        Tweet subject = new Tweet("Hello, world!", mockClock);
        assertEquals("Hello, world!", subject.getBody());
        assertNull(subject.getId());
        assertEquals(LocalDateTime.now(mockClock), subject.getDate());
    }

    @Test
    void testToString() {
        Tweet subject = new Tweet("Hello, world!");
        assertEquals("Tweet[id=null, body='Hello, world!']", subject.toString());
    }
}
