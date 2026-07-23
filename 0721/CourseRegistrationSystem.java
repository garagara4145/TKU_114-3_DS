import java.util.ArrayList;

public class CourseRegistrationSystem {

    public static void main(String[] args) {

        ArrayList<Course> courses = new ArrayList<>();

        addCourse(courses, new Course("C001", "Java", 2));
        addCourse(courses, new Course("C002", "Python", 3));
        addCourse(courses, new Course("C003", "Database", 1));

        enrollCourse(courses, "C001");
        enrollCourse(courses, "C001");
        enrollCourse(courses, "C001"); // 額滿

        enrollCourse(courses, "C003");

        dropCourse(courses, "C001");

        removeCourse(courses, "C002");

        System.out.println("===== 課程清單 =====");
        showCourses(courses);

        System.out.println("\n總課程數：" + courses.size());
        System.out.println("總選課人次：" + totalEnrollments(courses));

        System.out.println("\n===== 額滿課程 =====");
        showFullCourses(courses);
    }

    public static void addCourse(ArrayList<Course> courses, Course course) {

        if (findCourse(courses, course.getCode()) == null) {
            courses.add(course);
        } else {
            System.out.println("課程代碼不可重複！");
        }
    }

    public static Course findCourse(ArrayList<Course> courses, String code) {

        for (Course course : courses) {
            if (course.getCode().equalsIgnoreCase(code)) {
                return course;
            }
        }

        return null;
    }

    public static void enrollCourse(ArrayList<Course> courses, String code) {

        Course course = findCourse(courses, code);

        if (course == null) {
            System.out.println("找不到課程！");
            return;
        }

        if (course.enroll()) {
            System.out.println("選課成功！");
        } else {
            System.out.println("課程已額滿！");
        }
    }
    
    public static void dropCourse(ArrayList<Course> courses, String code) {

        Course course = findCourse(courses, code);

        if (course == null) {
            System.out.println("找不到課程！");
            return;
        }

        if (course.drop()) {
            System.out.println("退選成功！");
        } else {
            System.out.println("目前無學生可退選！");
        }
    }

    public static void removeCourse(ArrayList<Course> courses, String code) {

        Course course = findCourse(courses, code);

        if (course == null) {
            System.out.println("找不到課程！");
            return;
        }

        courses.remove(course);
        System.out.println("刪除成功！");
    }

    public static void showCourses(ArrayList<Course> courses) {

        if (courses.isEmpty()) {
            System.out.println("沒有課程！");
            return;
        }

        for (Course course : courses) {
            System.out.println(course);
        }
    }
    public static int totalEnrollments(ArrayList<Course> courses) {

        int total = 0;

        for (Course course : courses) {
            total += course.getEnrolled();
        }

        return total;
    }

    public static void showFullCourses(ArrayList<Course> courses) {

        boolean found = false;

        for (Course course : courses) {
            if (course.isFull()) {
                System.out.println(course);
                found = true;
            }
        }

        if (!found) {
            System.out.println("沒有額滿課程！");
        }
    }
}