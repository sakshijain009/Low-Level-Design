package stackoverflow;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int id;
    private final String name;
    private final String email;
    private final List<Comment> comments;
    private final List<Answer> answers;
    private final List<Question> questions;
    private int reputation;

    private final int QUESTION_REPUTATION = 5;
    private final int ANSWER_REPUTATION = 10;
    private final int COMMENT_REPUTATION = 1;

    public User(String name, String email) {
        this.id = generateNewId();
        this.name = name;
        this.email = email;
        this.answers = new ArrayList<>();
        this.questions = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.reputation = 0;
    }

    public Question askQuestion(String title, String content, List<String> tags) {
        Question question = new Question(content, title, this, tags);
        questions.add(question);
        updateReputation(QUESTION_REPUTATION);
        return question;
    }

    public Answer answerQuestion(String content, Question question) {
        Answer answer = new Answer(content, this, question);
        answers.add(answer);
        question.addAnswer(answer);
        updateReputation(ANSWER_REPUTATION);
        return answer;
    }

    public Comment addComment(Commentable commentable, String content) {
        Comment comment = new Comment(this, content);
        comments.add(comment);
        commentable.addComment(comment);
        updateReputation(COMMENT_REPUTATION);
        return comment;
    }

    public synchronized void updateReputation(int count) {
        this.reputation += count;
        if (this.reputation < 0) {
            this.reputation = 0;
        }
    }

    int generateNewId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getReputation() {
        return reputation;
    }
}
