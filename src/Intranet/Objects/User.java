package Intranet.Objects;

import java.io.Serializable;
import java.util.Objects;

import Intranet.Enums.Gender;

public  class User implements Comparable, Cloneable, Serializable {

    private String firstname;
    private String lastname;
    private String ID;
    private Gender gender;
    private String email;
    private String phoneNumber;
    private String birthDay;
    private String password;
    private String login;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public static int getHashedPassword(String password) {
        return Objects.hash(password);
    }

    boolean authentificate(String login, String password) {

        return (login.equals(this.login) && password.equals(this.password));
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, password);
    }

    // getter setter
    public String getName() {
        return firstname + " " + lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        ID = ID;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

	public void setLogin(String login) {
    	this.login = login;
	}

    @Override
    public String toString() {
        return super.toString();
    }

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}
