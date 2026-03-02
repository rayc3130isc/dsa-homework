package HW2_ArrayLists_Generics.homework2;

import java.util.ArrayList;

public class Course {

    private String courseCode;
    private String title;
    private String instructor;
    private int credits, capacity;
    private ArrayList<String> prerequisites;

    public Course(String courseCode, String title, int credits,
                  String instructor, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.instructor = instructor;
        this.capacity = capacity;
        this.prerequisites = new ArrayList<>();
    }

    public String getCourseCode() { return courseCode; }
    public String getTitle() { return title; }
    public String getInstructor() { return instructor; }
    public int getCapacity() { return capacity; }
    public ArrayList<String> getPrerequisites() { return prerequisites; }

    public void addPrerequisite(String courseCode) {
        prerequisites.add(courseCode);
    }

    @Override
    public String toString() {
        return courseCode + " - " + title +
                " | Instructor: " + instructor +
                " | Capacity: " + capacity;
    }
}