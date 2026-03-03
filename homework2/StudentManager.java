package HW2_ArrayLists_Generics.homework2;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student<?>> students = new ArrayList<>();

    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getStudentId().equals(student.getStudentId())) {
                System.out.println("Cannot add. Duplicate found.");
                return;
            }
        }

        students.add(student);  // Only add AFTER checking everyone
    }

    public boolean removeStudent(String studentId) {
        for (Student s : students) {
            if (studentId.equals(s.getStudentId())) {
                students.remove(s);
                return true;
            }
        }
        return false;
    }

    public Student findStudent(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                return s;
            }
        }
        return null;
    }

    public ArrayList<Student> getStudentsByMajor(String major){
        ArrayList<Student> filtered = new ArrayList<>();
        for (Student s : students) {
            if (s.getMajor().equals(major)) {
                filtered.add(s);
            }
        }
        return filtered;
    }

    public ArrayList<Student> getStudentsByYear(int year) {
        ArrayList<Student> filtered = new ArrayList<>();
        for (Student s : students) {
            if (s.getYear() == year) {
                filtered.add(s);
            }
        }
        return filtered;
    }

    public ArrayList<Student> getHonorStudents(double minGpa) {
        ArrayList<Student> filtered = new ArrayList<>();
        for (Student s : students) {
            if (s.getGpa() >= minGpa) {
                filtered.add(s);
            }
        }
        return filtered;
    }

    public double getAverageGpa() {
        double total = 0;
        int divisor = 0;
        for (Student s : students) {
            total += s.getGpa();
            divisor++;
        }
        return total/divisor;
    }

    public double getAverageGpaByMajor(String major) {
        ArrayList<Student> filtered = getStudentsByMajor(major);
        double total = 0;
        int divisor = 0;
        for (Student s : filtered) {
            total += s.getGpa();
            divisor++;
        }
        return total/divisor;
    }

    public void printAllStudents() {
        System.out.println("ID:\t\tName:\t\t\tEmail Address:\tGPA\tMajor\tYear");
        for (Student s : students) {
            System.out.println(s.getStudentId() + "\t" + s.getFirstName() + " " + s.getLastName() + "\t\t" + s.getEmail() + "\t" + s.getGpa() + "\t" + s.getMajor() + "\t" + s.getYear());
        }
    }

    public int getTotalStudents(){
        return students.size();
    }

    public ArrayList<String> getAllMajors() {
        ArrayList<String> filtered = new ArrayList<>();
        for (Student s : students) {
            String major = s.getMajor();
            if (!filtered.contains(major)) {
                filtered.add(major);
            }
        }
        return filtered;
    }

    public ArrayList<Student<?>> getAllStudents() {
        return students;
    }
}
