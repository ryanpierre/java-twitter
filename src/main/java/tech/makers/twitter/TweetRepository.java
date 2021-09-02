package tech.makers.twitter;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TweetRepository extends CrudRepository<Tweet, Long> {
    List<Tweet> findAll();
    List<Tweet> findAllByOrderByCreatedAtDesc();
}
