package Intranet.Testers;

import Intranet.Database;
import Intranet.IO;
import Intranet.Objects.ORManager;
import Intranet.Objects.Student;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.Serializable;

public class Tester implements Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        IO.print("Enter 1 for adding some sample users to database\nEnter 2 for other\nEnter 3 for creating admin");
        String testinput = IO.read();
        if (testinput .equals( "1")) {

            Student s1 = new Student();
            s1.setID("18BD10101");
            s1.setLogin("vasyyya");
            s1.setFirstname("Vasya");
            s1.setLastname("Pupkin");
            s1.setPassword("123");
            Database.addUser(s1);
            ORManager m1 = new ORManager();

            m1.setID("14M00");
            m1.setLogin("boryyya");
            m1.setFirstname("Borys");
            Database.addUser(m1);
            Database.saveData();
            return;
        }
        if (testinput.equals("3"))
        {
            Database.createAdmin();
            Database.saveData();
            return;
        }
        Database.loadData();
        Database.showUsers();;
        Database.showCourses();
        IO.welcomeMessage();
        int mode = IO.getMode();
        if (mode == 1) {
            AdminTester.adminMode();
        }
        if (mode == 2) {
            StudentTester.studentMode();
        }
        if (mode == 3) {
            ORManagerTester.managerMode();
        }
        if (mode == 4) {
            TeacherTester.teacherMode();
        }
        IO.close();
    }
}
