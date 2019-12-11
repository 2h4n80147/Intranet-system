package Intranet.Objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TechSupport extends User implements Serializable, Comparable, Cloneable {
    public static ArrayList<String> orders = new ArrayList<String>();

    public TechSupport(String login, String password) {
        super(login, password);
    }


    public void execute(int value) {
        Scanner scanner = new Scanner(System.in);
        String order;
        if (value == 1) { // Accept orders
            orders.clear();
        }
        if (value == 2) { // View new orders
            for (String curOrder : orders) {
                System.out.println(curOrder);
            }
        }
    }

    public static void getOrder(String order) {
        orders.add(order);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
