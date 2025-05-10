package stackoverflow;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/*

    Feature	                    HashMap	                Collections.synchronizedMap()	          ConcurrentHashMap
    Thread-safe?	            ❌ No	                ✅ Yes (full lock)	                      ✅ Yes (fine-grained locking)
    Performance under load	    ❌ Poor (if shared)	    ⚠️ Slower (locks whole map)	              ✅ Fast (locks only parts)
    Allows concurrent reads	    ❌ Unsafe	            ❌ No (locks entire map on read/write)	  ✅ Yes
    Allows concurrent writes	❌ Unsafe	            ❌ No	                                  ✅ Yes

 */
public class StackOverflow {
    private final Map<Integer, User> users;
    private final Map<Integer, Question> questions;
    private final Map<Integer, Answer> answers;
    private final Map<String, Tag> tags;

    public StackOverflow() {
        this.users = new ConcurrentHashMap<>();
        this.questions = new ConcurrentHashMap<>();
        this.answers = new ConcurrentHashMap<>();
        this.tags = new ConcurrentHashMap<>();
    }

    public User createUser(String name, String email) {
        User user = new User(name, email);
        int id = users.size() + 1;
        users.put(id, user);
        return user;
    }

    public Question askQuestion(User user, String title, String content, List<String> tagName) {
        Question question = user.askQuestion(title, content, tagName);
        questions.put(question.getId(), question);
        for(Tag tag : question.getTags()) {
            this.tags.putIfAbsent(tag.getName(),tag);
        }
        return question;
    }

    public Answer answerQuestion(User user, String content, Question question) {
        Answer answer = user.answerQuestion(content, question);
        answers.put(answer.getId(),answer);
        return answer;
    }

    public Comment addComment(User user, Commentable commentable, String content) {
        return user.addComment(commentable, content);
    }

    public void voteQuestion(User user, Question question, VoteType type) {
        question.vote(user, type);
    }

    public void voteAnswer(User user, Answer answer, VoteType type) {
        answer.vote(user, type);
    }

    public void acceptAnswer(Answer answer) {
        answer.markAnswerAsAccepted();
    }

    public List<Question> searchQuestions(String query) {
        return questions.values().stream()
                .filter(q -> q.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        q.getContent().toLowerCase().contains(query.toLowerCase()) ||
                        q.getTags().stream().anyMatch(t -> t.getName().equalsIgnoreCase(query)))
                .collect(Collectors.toList());
    }

    public List<Question> getQuestionsByUser(User user) {
        return user.getQuestions();
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public Map<Integer, Question> getQuestions() {
        return questions;
    }

    public Map<Integer, Answer> getAnswers() {
        return answers;
    }

    public Map<String, Tag> getTags() {
        return tags;
    }
}
