package Intranet.Objects;
import Intranet.Database;
import Intranet.IO;
import Intranet.Objects.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teacher extends Employee {
    private List<String> courses;

    public Teacher() {
        super();
        courses = new ArrayList<String>();
    }
    public void execute(int value) {
        if (value == 1) { // Add a course
            Course course = IO.getNewCourse();
            try {
                Database.addCourse(course);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (value == 2) { // View courses
            try {
                for (String courseId : courses) {
                    IO.print(courseId);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        if (value == 3) { // Edit courseFile

        }
        if (value == 4) { // Put marks
            String courseId = IO.getCourseID();
            String studentId = IO.getLogin();
            int newMark = IO.getMark();
            putMark(courseId, studentId, newMark);

        }
        if (value == 5) { // View messages from ORManager
           // Database.printMessageForTeacher();
        }
        if (value == 6) { // Send order to IT support guy
            String order = IO.read();
            TechSupport.getOrder(order);
        }
    }
    private void putMark(String courseID, String studentID, int newMark) {
        Course course = Database.getCourse(courseID);
        course.putMark(studentID, newMark);
    }
}
