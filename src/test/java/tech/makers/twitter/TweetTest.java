package tech.makers.twitter;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TweetTest {
    @Test
    void testConstructs() {
        LocalDateTime now = LocalDateTime.now();
        Tweet subject = new Tweet("Hello, world!", now);
        assertEquals("Hello, world!", subject.getBody());
        assertEquals(null, subject.getId());
        assertEquals(now, subject.getCreatedAt());
    }

    @Test
    void testToString() {
        LocalDateTime now = LocalDateTime.now();
        Tweet subject = new Tweet("Hello, world!", now);
        assertEquals("Tweet[id=null, body='Hello, world!']", subject.toString());
    }
}
