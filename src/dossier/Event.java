/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dossier;

import java.util.Random;

/**
 *
  * @author Shawn Deol
 * Date: Saturday, March 30
 * School: Robert Bateman High School
 * Computer used: Windows 7 pc, 84GB RAM, 1 TB HDD,  Intel I7~Q70
 * IDE used: netbeans 7.0.1
 * Created on Mar 28, 2012, 12:28:17 AM
 */
public class Event {

    static int numberOfEventsCreated = 0;
    String title;
    String author;
    /**
     * 
     */
    public static Participant[] participantsInEvent;
    int eventSize;
    int grade;
    /**
     * 
     */
    public static int numberOfParticipantsInEvent = 0;
    Boolean lock;

    /**
     * 
     * @param Title
     * @param Author
     * @param eventSize
     * @param grade
     */
    public Event(String Title, String Author, int eventSize, int grade) {
        this.title = Title;
        this.grade = grade;
        this.author = Author;
        this.eventSize = eventSize;
        participantsInEvent = new Participant[eventSize];
        numberOfEventsCreated++;
        lock = false;
    }

    /**
     * 
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @return
     */
    public int getEventSize() {
        return eventSize;
    }

    /**
     * 
     * @return
     */
    public static int getNumberOfEventsCreated() {
        return numberOfEventsCreated;
    }

    /**
     * 
     * @param Name
     */
    public void setTitle(String Name) {
        this.title = Name;
    }

    /**
     * 
     * @param eventSize
     */
    public void setEventSize(int eventSize) {
        this.eventSize = eventSize;
    }

    /**
     * 
     * @param Author
     */
    public void setAuthor(String Author) {
        this.author = Author;
    }

    /**
     * 
     * @param p
     * @return
     */
    public int add(Participant p) {

        participantsInEvent[numberOfParticipantsInEvent] = p;
        numberOfParticipantsInEvent++;
        sort();

        return -1;
    }


    /**
     * Removes the selected user from the participant array on the Event
     * @param firstName
     * @param lastName
     * @return
     */
    public int remove(String firstName, String lastName) {
        //Sets index to index value gotten from find method
        int indexOfParticipant = findParticipantByName(firstName, lastName);
        //If index is not invalid the spot becomes null and the array is shifted to the left and the number of participants in the event decreases
        if (indexOfParticipant > -1) {
            participantsInEvent[indexOfParticipant] = null;
            shiftParticipantLeft(participantsInEvent, indexOfParticipant);
            numberOfParticipantsInEvent--;
        }
        return -1;
    }


    /**
     * This method sorts all of the participants located inside the event
     */
    public void sort() {
        for (int j = 0; j < numberOfParticipantsInEvent; j++) {
            for (int i = j + 1; i < numberOfParticipantsInEvent; i++) {
                if (participantsInEvent[i].lastName.compareTo(participantsInEvent[j].lastName) < 0) {
                    Participant t = participantsInEvent[j];
                    participantsInEvent[j] = participantsInEvent[i];
                    participantsInEvent[i] = t;
                } else if (participantsInEvent[i].lastName == (participantsInEvent[j].lastName)) {
                    if (participantsInEvent[i].firstName.compareTo(participantsInEvent[j].firstName) < 0) {
                        Participant t = participantsInEvent[i];
                        participantsInEvent[i] = participantsInEvent[j];
                        participantsInEvent[j] = t;
                    }
                }
            }
        }

    }
//Shuffles the array and mixes up the indexes randomly

    /**
     * This method shuffles the current order of participants inside the event
     */
    public void shuffle() {
        Random generator = new Random();
        int j = 0;
        //for loop generates random number and assigns the current index value given by the for loop to the random value this is done by swapping the two
        for (int i = 0; numberOfParticipantsInEvent > i; i++) {
            j = generator.nextInt(numberOfParticipantsInEvent - 1);
            //Swap
            Participant temp = participantsInEvent[i];
            participantsInEvent[i] = participantsInEvent[j];
            participantsInEvent[j] = temp;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Event other = (Event) obj;
        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
            return false;
        }
        if ((this.author == null) ? (other.author != null) : !this.author.equals(other.author)) {
            return false;
        }
        if (this.eventSize != other.eventSize) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return title + "" + author + "" + eventSize + "" + grade;
    }

    /**
     * 
     */
    public void print() {
        for (int i = 0; numberOfParticipantsInEvent > i; i++) {
            System.out.println(participantsInEvent[i]);
        }

    }

    //Uncalled Methods
    //Same as in secretSantaStore
    /**
     * This method finds a participant by name
     * @param firstName
     * @param lastName
     * @return indexOfParticipant
     */
    public static int findParticipantByName(String firstName, String lastName) {
        int indexOfParticipant = -1;
        Participant p;
        for (int i = 0; i < numberOfParticipantsInEvent; i++) {
            p = participantsInEvent[i];
            if (p.getlastName().equalsIgnoreCase(lastName) && p.getFirstName().equalsIgnoreCase(firstName)) {
                //found
                indexOfParticipant = i;
                i = numberOfParticipantsInEvent;
            }

        }
        return indexOfParticipant;
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
     * @param grade
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }
    //Same as in secretSantaStore

    /**
     * This method shifts participants to the left 
     * @param p
     * @param a
     * @return p
     */
    public static Participant[] shiftParticipantLeft(Participant[] p, int a) {
        for (a = a; numberOfParticipantsInEvent > a; a++) {
            p[a] = p[a + 1];
        }
        p[p.length - 1] = null;

        return p;
    }
}
