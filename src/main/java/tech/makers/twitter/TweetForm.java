package tech.makers.twitter;

public class TweetForm {
    private String body;

    public String getBody() {
        return this.body;
    }

    protected TweetForm() {}

    public TweetForm(String body) {
        this.body = body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
