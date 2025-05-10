package stackoverflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements Commentable, Votable{
    private final int id;
    private final String content;
    private final User author;
    private final Question question;
    private final List<Comment> comments;
    private final List<Vote> votes;
    private boolean isAccepted;
    private final Date creationDate;

    public Answer(String content, User author, Question question) {
        this.id = generateNewId();
        this.content = content;
        this.author = author;
        this.question = question;
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.creationDate = new Date();
        this.isAccepted = false;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public void vote(User voter, VoteType voteType) {
        votes.removeIf(v -> v.getUser().equals(voter));
        votes.add(new Vote(voter, voteType));
        author.updateReputation(voteType == VoteType.UPVOTE ? 2 : -2);
    }

    @Override
    public int getVoteCount() {
        return votes.stream()
                .mapToInt(v -> v.getVoteType() == VoteType.UPVOTE ? 1 : -1)
                .sum();
    }

    public void markAnswerAsAccepted() {
        if (isAccepted) {
            throw new IllegalStateException("The answer is already accepted!");
        }
        isAccepted = true;
        author.updateReputation(10);
    }

    int generateNewId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
