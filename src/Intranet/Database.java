package Intranet;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import Intranet.Objects.*;

public class Database implements Serializable {
    static private HashMap<String, User> users = new HashMap<String, User>(); // key: login value: User
    static private HashMap<String, Course> courses = new HashMap<String, Course>(); // key: name of the course value: Course
    private static FileInputStream fis;
    private static FileOutputStream fos;
    private static ObjectOutputStream oos;
    private static ObjectInputStream oin;

    public static void desCourses() throws IOException, ClassNotFoundException {
        fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Intranet\\src\\courses");
        oin = new ObjectInputStream(fis);
        if (oin.available() > 0)
            courses = (HashMap) oin.readObject();
        oin.close();
        fis.close();
    }

    public static void serCourses() throws IOException {
        fos = new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\Intranet\\src\\courses", true);
        oos = new ObjectOutputStream(fos);
        oos.writeObject(courses);
        oos.flush();
        oos.close();
        fos.close();
    }

    public static void desUsers() throws IOException, ClassNotFoundException {
        fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Intranet\\src\\users");
        oin = new ObjectInputStream(fis);
        if (oin.available() > 0)
            users = (HashMap) oin.readObject();
        oin.close();
        fis.close();
    }

    public static void serUsers() throws IOException {
        fos = new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\Intranet\\src\\users", true);
        oos = new ObjectOutputStream(fos);
        oos.writeObject(users);
        oos.flush();
        oos.close();
        fos.close();

    }
    public static void showUsers () {
        IO.print(users.size() + " entries found");
        for (Map.Entry<String, User> entry : users.entrySet()) {
            Object value = entry.getValue();
            IO.print(value.toString());
        }
    }

    public static void showCourses () {
        IO.print(courses.size() + " entries found");
        for (Map.Entry<String, Course> entry : courses.entrySet()) {
            Object value = entry.getValue();
            IO.print(value.toString());
        }
    }
    public static void addUser(User user) {
		try {
			saveData();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public static void addCourse(Course course) throws IOException {
        courses.put(course.getCourseID(), course);
        saveData();
    }

    public static void saveData() throws IOException { // Serialization data
        serCourses();
        serUsers();
    }

    public static void loadData() throws IOException, ClassNotFoundException {
        desCourses();
        desUsers();
    }

    public static boolean doesUserExist(String login) { // check
        return users.containsKey(login);
    }

    public static boolean doesCourseExist(String courseID) { // check
        return courses.containsKey(courseID);
    }

    public static void createAdmin() {  // Add admin
        users.put("admin", new Admin("admin", "admin"));
    }

    public static void createTechSupport() {
        users.put("techsupport", new TechSupport("techsupport", "techsupport"));
    }

    public static User getUser(String login) {
        return users.get(login);
    }


	public static void deleteUser(String login) throws IOException, ClassNotFoundException { // remove User by login
		users.remove(login);
		saveData();
	}


	public static void deleteCourse(String name) throws IOException, ClassNotFoundException { // remove course by name
		courses.remove(name);
		saveData();
	}
	public static Course getCourse(String courseId) {
    	return courses.get(courseId);
	}
}
