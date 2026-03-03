package HW2_ArrayLists_Generics.homework2;

import java.util.ArrayList;

public class ReportGenerator {

    
    // Student Report
    public void generateStudentReport(String studentId, StudentManager sm, EnrollmentManager em) {
        System.out.println("===== STUDENT REPORT =====");
        Student<?> student = sm.findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println("Student Info:");
        System.out.println(student);
        System.out.println("\nEnrolled Courses:");
        ArrayList<Enrollment> enrollments =
                em.getEnrollmentsByStudent(studentId);
        for (Enrollment e : enrollments) {
            System.out.println(e);
        }
        double gpa = em.calculateStudentGpa(studentId);
        System.out.println("\nGPA: " + gpa);
        System.out.println("==========================");
    }

    
    // Course Report
    public void generateCourseReport(String courseCode, CourseManager cm, EnrollmentManager em) {
        System.out.println("===== COURSE REPORT =====");
        Course course = cm.findCourse(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }
        System.out.println("Course Info:");
        System.out.println(course);
        System.out.println("\nEnrolled Students:");
        ArrayList<Enrollment> enrollments =
                em.getEnrollmentsByCourse(courseCode);
        double total = 0;
        int gradedCount = 0;
        for (Enrollment e : enrollments) {
            System.out.println(e);
            if (e.getGrade() != null) {
                total += e.getGradePoints();
                gradedCount++;
            }
        }
        if (gradedCount > 0) {
            System.out.println("\nAverage Grade: " + (total / gradedCount));
        } else {
            System.out.println("\nNo grades assigned yet.");
        }
        System.out.println("=========================");
    }

    
    // Major Report
    public void generateMajorReport(String major, StudentManager sm) {
        System.out.println("===== MAJOR REPORT =====");
        System.out.println("Major: " + major);
        ArrayList<Student<?>> students = sm.getAllStudents();
        double totalGpa = 0;
        int count = 0;
        for (Student<?> s : students) {
            if (s.getMajor().equalsIgnoreCase(major)) {
                System.out.println(s);
                totalGpa += s.getGpa();
                count++;
            }
        }
        if (count > 0) {
            System.out.println("\nAverage GPA: " + (totalGpa / count));
        } else {
            System.out.println("No students found in this major.");
        }

        System.out.println("========================");
    }

    // Honor Roll Report
    public void generateHonorRollReport(StudentManager sm, double minGpa) {
        System.out.println("===== HONOR ROLL =====");
        System.out.println("Minimum GPA: " + minGpa);
        ArrayList<Student<?>> students = sm.getAllStudents();
        for (Student<?> s : students) {
            if (s.getGpa() >= minGpa) {
                System.out.println(s);
            }
        }
        System.out.println("======================");
    }
}
