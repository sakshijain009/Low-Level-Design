package stackoverflow;

import java.util.Date;

public class Comment {
    private final int id;
    private final Date creationDate;
    private final User author;
    private final String content;

    public Comment(User author, String content) {
        this.creationDate = new Date();
        this.author = author;
        this.content = content;
        this.id = generateNewId();
    }

    int generateNewId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
