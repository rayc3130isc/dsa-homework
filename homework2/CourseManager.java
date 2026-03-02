package HW2_ArrayLists_Generics.homework2;

import java.util.ArrayList;

public class CourseManager {

    private ArrayList<Course> courses;

    public CourseManager() {
        courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Course findCourse(String courseCode) {
        for (Course c : courses) {
            if (c.getCourseCode().equals(courseCode)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Course> getCoursesByInstructor(String instructor) {
        ArrayList<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getInstructor().equals(instructor)) {
                result.add(c);
            }
        }
        return result;
    }

    public ArrayList<Course> getAvailableCourses(
            String studentId,
            StudentManager studentManager,
            EnrollmentManager enrollmentManager) {

        ArrayList<Course> available = new ArrayList<>();

        for (Course course : courses) {

            boolean alreadyEnrolled = false;

            for (Enrollment e :
                    enrollmentManager.getEnrollmentsByStudent(studentId)) {

                if (e.getCourseCode().equals(course.getCourseCode())) {
                    alreadyEnrolled = true;
                    break;
                }
            }

            if (!alreadyEnrolled) {
                available.add(course);
            }
        }

        return available;
    }

    public void printAllCourses() {
        for (Course c : courses) {
            System.out.println(c);
        }
    }

    public int getTotalCourses() {
        return courses.size();
    }
}