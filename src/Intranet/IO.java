package Intranet;

import Intranet.Objects.*;

import java.util.Scanner;

import javax.xml.crypto.Data;

public class IO {

    static Scanner scanner = new Scanner(System.in);

    public static String read() {
        return scanner.nextLine();

    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static void welcomeMessage() {
        System.out.println("Welcome to our Intranet!");
        System.out.println("\n Enter ! any time to exit");
    }

    public static int getMode() {
        System.out.println("Choose your mode");
        System.out.println("1)Admin");
        System.out.println("2)Student");
        System.out.println("3)Manager");
        System.out.println("4)Teacher");
        int mode = scanner.nextInt();
        return mode;
    }
	public static User getUser()
	{
		//IO.print("Enter credentials");
		String login = getLogin();
		String password = "";
		User user = Database.getUser(login);
		while (!user.getPassword().equals(password))
		{
			IO.print("Enter password");
			password = IO.read();
		}
		return user;
	}
	public static Student getStudent( ) {
		User user = getUser();
		if (user instanceof Student)
			return (Student) user;
		else
			return null;
	}

	public static ORManager getORManager() {
		User user = getUser();
		if (user instanceof ORManager)
			return (ORManager) user;
		else
			return null;
	}
	public static Admin getAdmin() {
		User user = getUser();
		if (user instanceof Admin)
			return (Admin) user;
		else
			return null;
	}
	public static Teacher getTeacher( ) {
		User user = getUser();
		if (user instanceof Teacher)
			return (Teacher) user;
		else
			return null;
	}
	public static String getLogin() {
		String login = "";
		while (!Database.doesUserExist(login)) {
			print("Enter login");
			login = IO.read();
		}
		return login;
	}
	public static int getInt() {
    	String line = read();
    	int result = -1;
    	try {
    		result = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
    	return result;
	}

	public static String getCourseID() {
    	String courseId = "";
    	while (!Database.doesCourseExist(courseId))
		{
			print("Enter course id");
			courseId = read();
		}
    	return courseId;
	}

	public static User getNewUser() {
    	String login;
    	String password;
    	print("Creating new user...");
    	print("Enter login");
    	login = IO.read();
    	print("Enter password");
    	password = IO.read();
		User user = new User(login,password);

		print("Enter firstname");
		user.setFirstname(IO.read());
    	print("Enter lastname");
    	user.setLastname(IO.read());
    	print("Enter ID");
    	user.setID(IO.read());
    	print("Enter email");
    	user.setEmail(IO.read());
    	return user;
	}

	public static Course getNewCourse() {
    	print("Enter course name");
    	Course course = new Course();
    	course.setName(IO.read());
    	print("Enter course ID");
    	course.setCourseID(IO.read());
    	print("Enter number of credits ");
    	course.setNumberOfCredits(Integer.parseInt(IO.read()));
    	return course;
	}

	public static void close() {
        scanner.close();
    }
    public static String getCourseId() {
        String id = "";
        while (!Database.doesCourseExist(id)) {
            System.out.println("Enter course id");
            id = IO.read();
        }
        return id;
    }

    public static Integer getMark() {
        int mark = 0;
        try {
            while (!(mark >= 1 && mark <= 100)) {
                print("Enter mark");
                mark = Integer.parseInt(read());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return mark;
    }

    public static String getNewCourseId() {
        String newCourseId = null;
        while (Database.doesCourseExist(newCourseId)) {
            print("Enter new course");
            newCourseId = read();
        }
        return newCourseId;
    }

}