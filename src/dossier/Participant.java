/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dossier;

/**
 *
 * @author Shawn Deol
 * Date: Saturday, March 30
 * School: Robert Bateman High School
 * Computer used: Windows 7 pc, 84GB RAM, 1 TB HDD,  Intel I7~Q70
 * IDE used: netbeans 7.0.1
 * Created on Mar 28, 2012, 12:28:17 AM
 */
public class Participant {
    //class variables
//Declare variables

    static int numberOfParticipantsCreated = 0;
    //Object variables
    String firstName;
    String lastName;
    int grade;
    String firstParticipantPreference;
    String secondParticipantPreference;
    String thirdParticipantPreference;
    //user is true on default
    boolean user = true;
    String username;
    String password;
//Constructs object

    /**
     * 
     * @param firstName
     * @param lastName
     * @param grade
     * @param preference1
     * @param preference2
     * @param preference3
     * @param username
     * @param password
     */
    public Participant(String firstName, String lastName, int grade, String preference1, String preference2, String preference3, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.firstParticipantPreference = preference1;
        this.secondParticipantPreference = preference2;
        this.thirdParticipantPreference = preference3;
        this.username = username;
        this.password = password;
        numberOfParticipantsCreated++;
    }

    /**
     * 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Participant other = (Participant) obj;
        if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.equals(other.firstName)) {
            return false;
        }
        if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.equals(other.lastName)) {
            return false;
        }
        if (this.grade != other.grade) {
            return false;
        }
        if ((this.firstParticipantPreference == null) ? (other.firstParticipantPreference != null) : !this.firstParticipantPreference.equals(other.firstParticipantPreference)) {
            return false;
        }
        if ((this.secondParticipantPreference == null) ? (other.secondParticipantPreference != null) : !this.secondParticipantPreference.equals(other.secondParticipantPreference)) {
            return false;
        }
        if ((this.thirdParticipantPreference == null) ? (other.thirdParticipantPreference != null) : !this.thirdParticipantPreference.equals(other.thirdParticipantPreference)) {
            return false;
        }
        return true;
    }
//Getts are setters get and get values
    /**
     * 
     * @return
     */
    public boolean isUser() {
        return user;
    }

    /**
     * 
     * @param user
     */
    public void setUser(boolean user) {
        this.user = user;
    }

    /**
     * 
     * @return
     */
    public String getPassword() {

        return password;
    }

    /**
     * 
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @return
     */
    public int getGrade() {
        return grade;
    }

    /**
     * 
     * @param password
     */
    public void setPassword(String password) {

        this.password = password;
    }

    /**
     * 
     * @param grade
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * 
     * @return
     */
    public static int getNumberOfParticipantsCreated() {
        return numberOfParticipantsCreated;
    }

    /**
     * 
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        System.out.println("First Name has been updated!");

    }

    /**
     * 
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = firstName;

        System.out.println("First Name has been updated!");
    }

    /**
     * 
     * @param numberOfParticipantsCreated
     */
    public static void setNumberOfParticipantsCreated(int numberOfParticipantsCreated) {
        Participant.numberOfParticipantsCreated = numberOfParticipantsCreated;
    }

    /**
     * 
     * @param Preference1
     */
    public void setFirstParticipantPreference(String Preference1) {
        this.firstParticipantPreference = Preference1;
        System.out.println("First preference has been updated!");
    }

    /**
     * 
     * @param Preference2
     */
    public void setSecondParticipantPreference(String Preference2) {
        this.secondParticipantPreference = Preference2;
        System.out.println("Second preference has been updated!");
    }

    /**
     * 
     * @param Preference3
     */
    public void setThirdParticipantPreference(String Preference3) {
        this.thirdParticipantPreference = Preference3;
        System.out.println("Third preference has been updated!");
    }

    /**
     * 
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @return
     */
    public String getlastName() {
        return lastName;
    }

    /**
     * 
     * @return
     */
    public String getfirstPreference() {
        return firstParticipantPreference;
    }

    /**
     * 
     * @return
     */
    public String getSecondPreference() {
        return secondParticipantPreference;
    }

    /**
     * 
     * @return
     */
    public String getThirdPreference() {
        return thirdParticipantPreference;
    }
//Converts objecti nto string
    @Override
    public String toString() {
        return firstName + "," + lastName + "," + grade + "," + firstParticipantPreference + "," + secondParticipantPreference + "," + thirdParticipantPreference + "," + username + "," + password;
    }
}
