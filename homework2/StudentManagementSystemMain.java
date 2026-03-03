package HW2_ArrayLists_Generics.homework2;

import java.util.ArrayList;

public class StudentManagementSystemMain {
    public static void main(String[] args) {
        StudentManager sm1 = new StudentManager();
        CourseManager cm1 = new CourseManager();
        EnrollmentManager em1 = new EnrollmentManager(cm1);

        // Add Students
        sm1.addStudent(new Student<>("S100", "John", "Doe", "johndoe100@gmail.com", 3.5, "Computer Science", 2));
        sm1.addStudent(new Student<>("S101", "Jane", "Doe", "janedoe101@gmail.com", 3.4, "Computer Science", 2));
        sm1.addStudent(new Student<>("S102", "Joe", "Donn", "joedonn102@gmail.com", 3.0, "Architecture", 3));
        sm1.addStudent(new Student<>("S103", "Jimmy", "Dah", "jda103@gmail.com", 2.2, "Undeclared", 1));
        sm1.addStudent(new Student<>("S104", "Joseph", "Joe", "jojoe104@gmail.com", 4.0, "Psychology", 4));
        sm1.addStudent(new Student<>("S105", "Timmy", "Brown", "tbrown105@gmail.com", 1.2, "Gender Studies", 2));
        sm1.addStudent(new Student<>("S106", "Bibi", "Horchas", "106jenhorchas@gmail.com", 2.7, "Chemistry", 3));
        sm1.addStudent(new Student<>("S107", "Wilson", "Williams", "ww107@gmail.com", 1.0, "Undeclared", 2));
        sm1.addStudent(new Student<>("S108", "Ocho", "Moe", "ocho108@gmail.com", 4.0, "Math", 1));
        sm1.addStudent(new Student<>("S109", "Emmie", "Lin", "elin109@gmail.com", 4.0, "English", 4));

        
        // Add Courses
        cm1.addCourse(new Course("MUSC01", "Introduction to Music Theory", 3, "John Professor", 30));
        cm1.addCourse(new Course("MATH03", "Algebra II", 4, "Elliot Rodriguez", 50));
        cm1.addCourse(new Course("ENGL06", "Classics", 3, "Staff", 25));
        cm1.addCourse(new Course("PHYS99", "Advanced Applications of Quantum Mechanics", 3, "Einstein II", 12));
        cm1.addCourse(new Course("CISC01", "Introduction to Java", 3, "Steven Hulse", 35));

        
        // Enrollments
        em1.enrollStudent("S100", "CISC01", "Fall 2026");
        em1.enrollStudent("S101", "CISC01", "Fall 2026");
        em1.enrollStudent("S108", "ENGL06", "Spring 2026");
        em1.enrollStudent("S104", "MUSC01", "Fall 2026");
        em1.enrollStudent("S107", "PHYS99", "Winter 2027");

        sep();
        System.out.println("ALL STUDENTS:");
        sm1.printAllStudents();

        sep();
        System.out.println("ALL COURSES:");
        cm1.printAllCourses();

        
        // Find + Remove
        sep();
        System.out.println("FIND STUDENT S100:");
        System.out.println(sm1.findStudent("S100"));

        sep();
        System.out.println("REMOVE STUDENT S109:");
        sm1.removeStudent("S109");
        sm1.printAllStudents();

        
        // Assign Grades (TO CISC STUDENTS) + GPA
        sep();
        System.out.println("ASSIGN GRADES:");
        for (Enrollment e : em1.getEnrollmentsByCourse("CISC01")) {
            em1.assignGrade(e.getEnrollmentId(), "A");
        }
        System.out.println("Students S100 and S101 have been graded.");

        sep();
        System.out.println("CALCULATE GPA:");
        System.out.println("S100 GPA: " + em1.calculateStudentGpa("S100"));

        
        // Reports
        sep();
        System.out.println("GENERATE ENROLLMENT REPORT:");
        em1.printAllEnrollments();

        
        // Generic Utilities
        sep();
        System.out.println("GENERIC UTILITY METHODS:");

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("Sum: " + ArrayListUtils.sum(numbers));
        System.out.println("Average: " + ArrayListUtils.average(numbers));

        
        // Demonstrate Stack
        sep();
        System.out.println("STACK DEMO:");

        GenericStack<String> stack = new GenericStack<>();
        stack.push("First");
        stack.push("Second");

        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());

        
        // Demonstrate Queue
        sep();
        System.out.println("QUEUE DEMO:");

        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.enqueue(100);
        queue.enqueue(200);

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Peek: " + queue.peek());

        // Demonstrate Pair
        sep();
        System.out.println("PAIR DEMO:");

        Pair<String, Double> grade = new Pair<>("CISC01", 4.0);
        System.out.println(grade);

        // Report System
        ReportGenerator rg = new ReportGenerator();
        sep();
        rg.generateStudentReport("S101", sm1, em1);
        sep();
        rg.generateCourseReport("CISC01", cm1, em1);
        sep();
        rg.generateMajorReport("Computer Science", sm1);
        sep();
        rg.generateHonorRollReport(sm1, 3.5);
    }

    public static void sep() {
        System.out.println("==========");
    }
}