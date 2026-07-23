public class Course {

    private String code;
    private String name;
    private int capacity;
    private int enrolled;

    public Course(String code, String name) {
        this.code = code;
        this.name = name;
        this.capacity = Integer.MAX_VALUE;
        this.enrolled = 0;
    }

    public Course(String code, String name, int capacity) {
        this.code = code;
        this.name = name;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    public String getCode() {
        return code;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public boolean enroll() {
        if (enrolled >= capacity) {
            return false;
        }
        enrolled++;
        return true;
    }

    public boolean drop() {
        if (enrolled == 0) {
            return false;
        }
        enrolled--;
        return true;
    }

    public boolean isFull() {
        return enrolled >= capacity;
    }

    @Override
    public String toString() {
        return code + " | " + name + " | enrolled="
                + enrolled + "/" + capacity;
    }
}