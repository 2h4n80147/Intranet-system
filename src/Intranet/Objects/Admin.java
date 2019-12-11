package Intranet.Objects;

import java.io.IOException;

import Intranet.Database;
import Intranet.IO;
import Intranet.Testers.StudentTester;

public class Admin extends Employee {

    public Admin(String login, String password) {
        super(login, password);
    }
    public Admin() {
        super();

    }

    public void execute(int value) {
        if (value == 1) { // Remove a user
            String login = IO.getLogin();
            try {
                Database.deleteUser(login);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (value == 2) {
            // Add a Student
            User user = IO.getNewUser();
            Student student = (Student) user;
            Database.addUser(student);

        }
        if (value == 3) {
            StudentTester.studentMode();
        }
        if (value == 5) { // Add a teacher
            User user = IO.getNewUser();
            Teacher teacher = (Teacher)user;
            Database.addUser(teacher);

        }
        if (value == 6) { // Add OR Manager
            ORManager orManager = (ORManager) IO.getNewUser();
            Database.addUser(orManager);
        }
        if (value == 7) {
            // show Course files
            Database.showCourses();
        }
        if (value == 8) {
            // show users
            Database.showUsers();
        }
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
