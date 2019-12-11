package Intranet.Objects;

import Intranet.IO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Course implements Cloneable, Comparable, Serializable {

    Teacher teacher;
    String courseID;
    String name;

    int numberOfCredits;
    HashMap<String, List<Integer>> grades;

    public Course(Teacher teacher, String courseID, int numberOfCredits) {
        this.teacher = teacher;
        this.courseID = courseID;
        this.numberOfCredits = numberOfCredits;
        grades = new HashMap<>();
    }

    public Course() {

    }

    public void putMark(String studentID, int grade) {
        if (grades.containsKey(studentID)) {

        }
    }

    public void showMarks(Student student) {
        IO.print(this.getCourseID() + "Marks: ");
        try {
            List<Integer> curMarks = grades.get(student.getID());
            for (Integer curMark : curMarks) {
                IO.print(String.valueOf(curMark.intValue()));
            }
        } catch (NullPointerException e) {
            IO.print(e.getMessage());
        }
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return 0; // TODO
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return numberOfCredits == course.numberOfCredits &&
                Objects.equals(teacher, course.teacher) &&
                Objects.equals(courseID, course.courseID) &&
                Objects.equals(grades, course.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacher, courseID, numberOfCredits, grades);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseFile=" +
                ", teacher=" + teacher +
                ", courseId='" + courseID + '\'' +
                ", numberOfCredits=" + numberOfCredits +
                ", marks=" + grades +
                '}';
    }

}
