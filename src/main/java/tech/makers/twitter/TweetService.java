package tech.makers.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.List;

@Service
public class TweetService {
    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private IClockService clockService;

    List<Tweet> findAll() {
        return tweetRepository.findAll();
    }

    List<Tweet> findAllReverse() {
        return tweetRepository.findAllByOrderByCreatedAtDesc();
    }

    Tweet create(String body) {
        return new Tweet(body, LocalDateTime.now(clockService.getClock()));
    }

    void save(Tweet tweet) {
        tweetRepository.save(tweet);
    }

}
