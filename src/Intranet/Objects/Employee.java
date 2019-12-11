package Intranet.Objects;

import Intranet.IO;

import java.io.Serializable;


public abstract class Employee extends User implements Comparable, Cloneable, Serializable {
    int salary;

    Employee() {
        super();
    }

    public Employee(String login, String password) {
        setPassword(password);
        super.setLogin(login);
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean setSalary() {
        System.out.println("Enter salary");
        String salary = IO.read();
        if (salary.equals("!"))
            return false;
        try {

            this.salary = Integer.parseInt(salary);
        } catch (NumberFormatException e) {
            System.out.println("Enter correct salary number");
            e.printStackTrace();
        }
        return true;

    }


    @Override
    public String toString() {
        return "Employee{" +
                ", salary=" + salary +
                super.toString() +
                '}';
    }
}
