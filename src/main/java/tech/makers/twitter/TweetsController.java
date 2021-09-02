package tech.makers.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Clock;
import java.time.LocalDateTime;

@Controller
public class TweetsController {
    @Autowired
    private TweetService tweetService;

    @Autowired
    private IClockService clockService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newTweet", new TweetForm());
        model.addAttribute("tweets", tweetService.findAllReverse());
        return "index";
    }

    @PostMapping("/tweets")
    public String create(@ModelAttribute TweetForm tweetForm) {
        Tweet newTweet = tweetService.create(tweetForm.getBody());
        tweetService.save(newTweet);
        return "redirect:/";
    }
}
