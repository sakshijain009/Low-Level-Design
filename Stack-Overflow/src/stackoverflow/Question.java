package stackoverflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Votable, Commentable{
    private final int id;
    private final String content;
    private final String title;
    private final User author;
    private final List<Comment> comments;
    private final List<Vote> votes;
    private final List<Tag> tags;
    private final List<Answer> answers;
    private Answer acceptedAnswer;
    private final Date creationDate;

    public Question(String content, String title, User author, List<String> tagNames) {
        this.id = generateNewId();
        this.content = content;
        this.title = title;
        this.author = author;
        this.creationDate = new Date();
        this.answers = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        for (String tag : tagNames) {
            tags.add(new Tag(tag));
        }
    }

    int generateNewId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    public synchronized void addAnswer(Answer answer) {
        if (!answers.contains(answer)) {
            answers.add(answer);
        }
    }

    public synchronized void setAcceptedAnswer(Answer answer) {
        this.acceptedAnswer = answer;
        answer.markAnswerAsAccepted();
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

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public User getAuthor() {
        return author;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public Answer getAcceptedAnswer() {
        return acceptedAnswer;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
