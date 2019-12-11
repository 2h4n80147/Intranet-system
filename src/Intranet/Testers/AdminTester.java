package Intranet.Testers;

import Intranet.Database;
import Intranet.IO;
import Intranet.Objects.Admin;

import java.io.IOException;

public  class AdminTester {
    public static void adminMode() {
        Admin admin = IO.getAdmin();
        while (true) {
            int value = getCommand();
            if (value == -1)
                break;
            admin.execute(value);
        }
    }
    public static int getCommand()
    {
        IO.print("Choose a command");
        IO.print("1)Remove a user");
        IO.print("2)Add a student");
        IO.print("3)Enter student mode");
        //IO.print("4)Update user info by login");
        IO.print("5)Add a teacher");
        IO.print("6)Add an OR Manager");
        IO.print("7)Show raw courses");
        IO.print("8)Show raw users");
        int value = IO.getInt();
        return value;
    }
}
