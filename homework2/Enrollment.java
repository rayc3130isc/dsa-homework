package HW2_ArrayLists_Generics.homework2;

public class Enrollment {
    private String enrollmentId, studentId, courseCode, grade, semester;

    public Enrollment(String enrollmentId, String studentId,
                      String courseCode, String semester) {
        this.enrollmentId = enrollmentId;this.studentId = studentId;this.courseCode = courseCode;this.semester = semester;this.grade = null;
    }


    public String getEnrollmentId() {return enrollmentId;}
    public void setEnrollmentId(String enrollmentId) {this.enrollmentId = enrollmentId;}
    public String getStudentId() {return studentId;}
    public void setStudentId(String studentId) {this.studentId = studentId;}
    public String getCourseCode() {return courseCode;}
    public void setCourseCode(String courseCode) {this.courseCode = courseCode;}
    public String getGrade() {return grade;}
    public void setGrade(String grade) {this.grade = grade;}
    public String getSemester() {return semester;}
    public void setSemester(String semester) {this.semester = semester;}

    @Override
    public String toString() {
        return enrollmentId + " | Student: " + studentId +
                " | Course: " + courseCode +
                " | Semester: " + semester +
                " | Grade: " + (grade == null ? "Not graded" : grade);
    }

    public double getGradePoints() {
        double gpa = switch(grade) {
            case "A" -> 4.0;
            case "B" -> 3.0;
            case "C" -> 2.0;
            case "D" -> 1.0;
            default -> 0.0;
        };
        return gpa;
    }

    public boolean isPassing() {
        if (grade.equals("F")) {return false;} else {return true;}
    }
}
