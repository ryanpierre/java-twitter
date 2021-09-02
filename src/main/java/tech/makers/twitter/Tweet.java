package tech.makers.twitter;

import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.time.Clock;
import java.time.LocalDateTime;

// This is a Spring Entity.
// It represents a Model in MVC.
// And each instance, when saved, will refer to a row in the 'tweet' table in the database.
@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="body", length=140)
    private String body;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    protected Tweet() {}

    public Tweet(String body) {
        this.body = body;
        this.createdAt = LocalDateTime.now( Clock.systemUTC() );
    }

    public Tweet(String body, Clock clock) {
        this.body = body;
        this.createdAt = LocalDateTime.now(clock);
    }

    @Override
    public String toString() {
        return String.format("Tweet[id=%d, body='%s']", id, body);
    }

    public Long getId() {
        return this.id;
    }

    public String getBody() {
        return this.body;
    }

    public LocalDateTime getCreatedAt() { return this.createdAt; }
}
