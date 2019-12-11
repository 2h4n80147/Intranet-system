package Intranet.Objects;

import java.io.Serializable;

import Intranet.Database;
import Intranet.Enums.Degree;
import Intranet.IO;

public class Student extends User implements Serializable, Comparable, Cloneable {

    private Degree degree;
    private Transcript transcript;
    private double gpa;

    public Student() {
        super();
    }
    // getter setters

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public  void execute(int value) {
        if (value == 1) { // View courses
            showCourses();
        }
        if (value == 2) { // View transcript
            showTranscript();
        }
        if (value == 3) { // register for a course
            String courseID = IO.getCourseID();
            transcript.getCourseId().add(courseID);
        }
        if (value == 5) { // View file of course
            showCourseFiles();
        }
    }

    private void showCourseFiles() {

    }

    private void showCourses() {
        try {
            for (String courseName : transcript.getCourseId()) {
                IO.print(courseName);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    public void showTranscript() {
        try {
            for (String courseId : transcript.getCourseId()) {
                Course course = Database.getCourse(courseId);
                course.showMarks(this);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
