package Intranet.Objects;
import Intranet.Database;
import Intranet.IO;
import Intranet.Objects.*;

public class ORManager extends Employee {

    public ORManager(String login, String password) {
        super(login, password);
    }
    public ORManager(){}


    public void execute(int value) {
        if (value == 1) { // View info about a student
            String login = IO.getLogin();
            User user = Database.getUser(login);
            if(!(user instanceof Student)) {
                IO.print("Given login is not login of the student");
            } else {
                IO.print(user.toString());
            }
        }
        if (value == 2) { // Add a course
            Course course = IO.getNewCourse();

        }
        if (value == 3) { // Send a message to the teachers
//            IO.print(sendMessage);
//
//            String message = IO.read();
//            if (message.equals("!")) return;
//            Database.addMessagForTeacher(message);
        }
        if (value == 4) { // View info about a teacher

            User user = IO.getUser();
            if(!(user instanceof Teacher)) {
                IO.print("Given login is not login of the teacher");
            } else {
                IO.print(user.toString());
            }
        }
    }
}
