package tech.makers.twitter;

public class TweetForm {
    private String body;

    protected TweetForm() {};

    public TweetForm(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
