package Intranet.Testers;

import Intranet.Database;
import Intranet.IO;
import Intranet.Objects.Student;

public class StudentTester {


    public static void studentMode() {
        Student student = IO.getStudent();
        while (true)
        {
            int value = getStudentCommand();
            if (value == -1)
                break;
            student.execute(value);
        }
    }
    public static int getStudentCommand ()
    {
        IO.print("Choose Command ");
        IO.print("1)View courses");
        IO.print("2)View transcript");
        IO.print("3)register for a course");
        IO.print("5)View course files");
        String line = IO.read();
        int number = -1;
        try {
            number = Integer.parseInt(line);
        } catch (NumberFormatException e) {

        }
        return number;
    }
}
