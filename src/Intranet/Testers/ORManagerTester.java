package Intranet.Testers;

import Intranet.Database;
import Intranet.IO;
import Intranet.Objects.ORManager;

public class ORManagerTester {

    public static void managerMode() {
        ORManager manager = IO.getORManager();
        while (true) {
            int value = getManagerCommand();
            if (value == -1)
                break;
        }
    }
    public static int getManagerCommand()
    {
        System.out.println("some command 1");
        return -1;
    }

}
