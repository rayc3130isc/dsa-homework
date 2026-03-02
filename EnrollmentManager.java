package HW2_ArrayLists_Generics;

import java.util.ArrayList;

public class EnrollmentManager {

    private ArrayList<Enrollment> enrollments;
    private CourseManager courseManager;

    public EnrollmentManager(CourseManager courseManager) {
        this.courseManager = courseManager;
        enrollments = new ArrayList<>();
    }

    public void enrollStudent(String studentId, String courseCode, String semester) {
        Course course = courseManager.findCourse(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        if (getEnrollmentCount(courseCode) >= course.getCapacity()) {
            System.out.println("Course is full.");
            return;
        }
        String enrollmentId = String.format("E%03d", enrollments.size() + 1);
        enrollments.add(new Enrollment(enrollmentId, studentId, courseCode, semester));
    }

    public boolean dropEnrollment(String enrollmentId) {
        for (int i = 0; i < enrollments.size(); i++) {
            if (enrollments.get(i).getEnrollmentId().equals(enrollmentId)) {
                enrollments.remove(i);
                return true;
            }
        }
        return false;
    }

    public Enrollment findEnrollment(String enrollmentId) {
        for (Enrollment e : enrollments) {
            if (e.getEnrollmentId().equals(enrollmentId)) {
                return e;
            }
        }
        return null;
    }

    public ArrayList<Enrollment> getEnrollmentsByStudent(String studentId) {
        ArrayList<Enrollment> result = new ArrayList<>();

        for (Enrollment e : enrollments) {
            if (e.getStudentId().equals(studentId)) {
                result.add(e);
            }
        }

        return result;
    }

    public ArrayList<Enrollment> getEnrollmentsByCourse(String courseCode) {
        ArrayList<Enrollment> result = new ArrayList<>();

        for (Enrollment e : enrollments) {
            if (e.getCourseCode().equals(courseCode)) {
                result.add(e);
            }
        }

        return result;
    }

    public void assignGrade(String enrollmentId, String grade) {
        Enrollment e = findEnrollment(enrollmentId);
        if (e != null) {
            e.setGrade(grade);
        }
    }

    public double calculateStudentGpa(String studentId) {

        ArrayList<Enrollment> list =
                getEnrollmentsByStudent(studentId);

        double total = 0;
        int count = 0;

        for (Enrollment e : list) {
            if (e.getGrade() != null) {
                total += e.getGradePoints();
                count++;
            }
        }

        if (count == 0) return 0.0;

        return total / count;
    }

    public ArrayList<String> getStudentsInCourse(String courseCode) {
        ArrayList<String> students = new ArrayList<>();

        for (Enrollment e : enrollments) {
            if (e.getCourseCode().equals(courseCode)) {
                students.add(e.getStudentId());
            }
        }

        return students;
    }

    public int getEnrollmentCount(String courseCode) {
        int count = 0;

        for (Enrollment e : enrollments) {
            if (e.getCourseCode().equals(courseCode)) {
                count++;
            }
        }

        return count;
    }

    public void printAllEnrollments() {
        for (Enrollment e : enrollments) {
            System.out.println(e);
        }
    }
}