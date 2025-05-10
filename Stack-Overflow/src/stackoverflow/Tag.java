package stackoverflow;

/*
    - System.currentTimeMillis() in Java returns the current time in milliseconds
    - It returns a long value (not int).
    - Output could be 1715332017682 milliseconds on
      May 10, 2025, 10:06:57 AM UTC (depending on when you run it)
 */
public class Tag {
    private final int id;
    private final String name;

    public Tag(String name) {
        this.id = generateNewId();
        this.name = name;
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
}
