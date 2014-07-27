
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dossier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
  * @author Shawn Deol
 * Date: Saturday, March 30
 * School: Robert Bateman High School
 * Computer used: Windows 7 pc, 84GB RAM, 1 TB HDD,  Intel I7~Q70
 * IDE used: netbeans 7.0.1
 * Created on Mar 28, 2012, 12:28:17 AM
 */
public class secretSantaStore {
    //Declare variables

    /**
     * 
     */
    public static Participant[] participantsList;
    /**
     * 
     */
    public static Event[] eventsListArray;
    /**
     * 
     */
    public static int numberOfParticipantsInStore;
    /**
     * 
     */
    public static int numberOfEventsInStore;

    //Method sets all of the arrays and reference values for for loops
    /**
     * 
     */
    public secretSantaStore() {
        participantsList = new Participant[1000];
        eventsListArray = new Event[1000];
        numberOfEventsInStore = 0;
        numberOfParticipantsInStore = 0;
    }

    
   
    /**This method adds an event to the event list array
     * 
     * @param p
     * @return -1
     */
    public static int addEvent(Event p) {
        //Sets the smallest open slot to the input event
        eventsListArray[numberOfEventsInStore] = p;
        //Increase number of events
        numberOfEventsInStore++;
        //Sort
        sortEventsByTitleAndGrade();
        return -1;
    }

    
    /**
     * This method fetches the index value off a deleted event and shifts all of the other events on the right of it to the left
     * @param a Integer a
     * @return eventsListArray
     */
    public static Event[] shiftEventLeft(int a) {
        //For loop to set all the values, starting at the deleted event, to the one on the right
        for (a = a; eventsListArray.length - 1 > a; a++) {
            eventsListArray[a] = eventsListArray[a + 1];
        }
        //Deletes the last value in the participant array 
        eventsListArray[eventsListArray.length - 1] = null;

        return eventsListArray;
    }

    
    /**
     * This method fetches the title and author of an event, deletes that event and returns an invalid index point
     * @param Title
     * @param Author
     * @return -1
     */
    public static int removeEventByTitle(String Title, String Author) {
        //Set index to a value gotten from the find search
        int indexOfEvent = findEventByTitle(Title, Author);
        //If the index is valid then it deletes the element at that index and shifts the whole array to the left
        if (indexOfEvent > -1) {
            eventsListArray[indexOfEvent] = null;
            secretSantaStore.shiftEventLeft(indexOfEvent);
            //Decreases number of events in store
            numberOfEventsInStore--;
        }
        return -1;
    }

    
    /**
     * This method fetches the title and author of an event and returns the actual event object
     * @param Title
     * @param Author
     * @return p
     */
    public static Event getByTitle(String Title, String Author) {
        //Finds the index of the object
        int indexOfEvent = findEventByTitle(Title, Author);
        Event p;
        //If the search failed method realizes event doesn't exist so it deletes the event
        if (indexOfEvent == -1) {
            System.out.print("Sorry not found");
            p = null;
        } else {
            //If search returns an actual index the return becomes the index
            p = eventsListArray[indexOfEvent];
        }
        //Event is returned
        return p;
    }

    
    /**
     * This method fetches the title and author of an event and returns an index point on the events list
     * @param Title
     * @param Author
     * @return indexOfEvent
     */
    public static int findEventByTitle(String Title, String Author) {
        //Set index of the event to -1 to start off
        int indexOfEvent = -1;
        //Create new generic event variable
        Event p;
        //For loop to run through all events in the store
        for (int i = 0; i < numberOfEventsInStore; i++) {
            p = eventsListArray[i];
            //If statement to check if the title and author exist
            if (p.getTitle().equalsIgnoreCase(Title) && p.getAuthor().equalsIgnoreCase(Author)) {
                //found
                indexOfEvent = i;
                i = numberOfParticipantsInStore;
            }
        }
        //returns index
        return indexOfEvent;
    }

    
    /**
     * This method sorts all the events in the secret santa store by the grade and then the title of the event
     */
    public static void sortEventsByTitleAndGrade() {
        //For loop to select a value to compare
        for (int j = 0; j < numberOfEventsInStore; j++) {
            //For loop that compares above value to all others in array
            for (int i = j + 1; i < numberOfEventsInStore; i++) {
                //If the compared value is smaller than the initial value than the two are swapped
                if (eventsListArray[i].grade > eventsListArray[j].grade) {
                    //Three step swap using a temporary variable
                    Event t = eventsListArray[j];
                    eventsListArray[j] = eventsListArray[i];
                    eventsListArray[i] = t;
                } //If the values were equal 
                else if (eventsListArray[i].grade == eventsListArray[j].grade) {
                    //Compared the titles of the events to see which comes first alphabeticall and swaps accordingly
                    if (eventsListArray[i].title.compareTo(eventsListArray[j].title) < 0) {
                        Event t = eventsListArray[i];
                        eventsListArray[i] = eventsListArray[j];
                        eventsListArray[j] = t;
                    }
                }
            }
        }

    }

    
    /**This method Prints out all the participants in the store
     * 
     */
    public static void printEvents() {
        //For loop to cycle through events
        for (int i = 0; numberOfEventsInStore > i; i++) {
            System.out.println(eventsListArray[i]);
        }

    }
    //PARTICIPANT METHODS
    

    /**
     * //This method sorts all the participants in the secret Santa store by the last name and then the first name of the participant
     */
    public static void sortParticipantByName() {
        //For loop to select a value to compare
        for (int j = 0; j < numberOfParticipantsInStore; j++) {
            //For loop that compares above value to all others in array
            for (int i = j + 1; i < numberOfParticipantsInStore; i++) {
                //Compared the last names of the events to see which comes first alphabeticall and swaps accordingly
                if (participantsList[i].lastName.compareTo(participantsList[j].lastName) < 0) {
                    Participant t = participantsList[j];
                    participantsList[j] = participantsList[i];
                    participantsList[i] = t;
                    //If the values were equal 
                } else if (participantsList[i].lastName == (participantsList[j].lastName)) {
                    //Compared the titles of the first names to see which comes first alphabeticall and swaps accordingly
                    if (participantsList[i].firstName.compareTo(participantsList[j].firstName) < 0) {
                        Participant t = participantsList[i];
                        participantsList[i] = participantsList[j];
                        participantsList[j] = t;
                    }
                }
            }
        }

    }

   
    /**
     * Adds a participant to the store
     * @param p
     * @return -1
     */
    public static int addParticipant(Participant p) {

        participantsList[numberOfParticipantsInStore] = p;
        numberOfParticipantsInStore++;
        //Sort
        sortParticipantByName();
        return -1;
    }

    
    /**
     * This method fetches the index value of a deleted participant  and shifts all of the other participants on the right of it to the left
     * @param p
     * @param a
     * @return
     */
    public static Participant[] shiftParticipantsLeft(Participant[] p, int a) {

        for (a = a; numberOfParticipantsInStore > a; a++) {
            p[a] = p[a + 1];
        }
        p[p.length - 1] = null;

        return p;
    }

    
    /**
     * removes a participant from the tore using its first and last name
     * @param firstName
     * @param lastName
     * @return -1
     */
    public static int removeParticipantByName(String firstName, String lastName) {
        int indexOfParticipant = findParticipantByName(firstName, lastName);
        if (indexOfParticipant > -1) {
            participantsList[indexOfParticipant] = null;
            secretSantaStore.shiftParticipantsLeft(participantsList, indexOfParticipant);
            numberOfParticipantsInStore--;
        }
        return -1;
    }

    
    /**
     * This method gets a participant by his first name and last name
     * @param firstName
     * @param lastName
     * @return p
     */
    public static Participant getParticipantByName(String firstName, String lastName) {
        int indexOfParticipant = findParticipantByName(firstName, lastName);
        Participant p;
        if (indexOfParticipant == -1) {
            System.out.print("Sorry not found");
            p = null;
        } else {
            p = participantsList[indexOfParticipant];
        }
        return p;
    }

   
    /**
     * This method finds a participant by his name
     * @param firstName
     * @param lastName
     * @return indexOfParticipant
     */
    public static int findParticipantByName(String firstName, String lastName) {
        int indexOfParticipant = -1;
        Participant p;
        for (int i = 0; i < numberOfParticipantsInStore; i++) {
            p = participantsList[i];
            if (p.getlastName().equalsIgnoreCase(lastName) && p.getFirstName().equalsIgnoreCase(firstName)) {
                //found
                indexOfParticipant = i;
                i = numberOfParticipantsInStore;
            }

        }
        return indexOfParticipant;
    }

    
    /**
     * Prints out all the participants in the store
     */
    public static void printParticipants() {
        //For loop to cycle through participants
        for (int i = 0; numberOfParticipantsInStore > i; i++) {
            System.out.println(participantsList[i]);
        }

    }

    
    /**
     * This method checks if a string has numbers in it or not
     * @param s
     * @return true or false
     */
    public static boolean hasNum(String s) {
        //Try and catch to catch int
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }

   

    /**
     * This method writes the participant array in the store to a text file
     */
    public static void writeParticpantToFile() {
        try {
            //Creates new file 
            File file = new File("Participant.txt");
            file.createNewFile();
            FileWriter output = new FileWriter(file);
            //Writes out participants into text form on new file
            for (int index = 0; index < numberOfParticipantsInStore; index++) {
                output.write(participantsList[index] + "\r\n");
            }
            //close file
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method writes the event array in the store to a text file
     */
    public static void writeEventToFile() {
        try {
            //Same as above
            File file = new File("Event.txt");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter output = new FileWriter(file);
            for (int index = 0; index < numberOfEventsInStore; index++) {
                output.write(eventsListArray[index] + "\r\n");
            }
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method populates the participant array with participants from the TXT file
     */
    public static void populateParticipantArrayFromFile() {

        String line = "";
        Participant p;

        StringTokenizer st = new StringTokenizer(line, ",");
        try {
            //Finds file
            File file = new File("participant.txt");
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                line = input.nextLine();
                //Creates tokenizer
                st = new StringTokenizer(line, ",");
                // Populate New Participant
                p = new Participant(null, null, 0, null, null, null, null, null);
                if (st.hasMoreTokens()) {
                    //Sets proper tokens to proper properties
                    try {
                        p.setFirstName(st.nextToken());
                    } catch (Exception NoSuchElementException) {
                        p.setFirstName(null);
                    }
                    try {
                        p.setLastName(st.nextToken());
                    } catch (Exception NoSuchElementException) {
                        p.setLastName(null);
                    }
                    try {
                        p.setGrade(Integer.parseInt(st.nextToken()));
                    } catch (Exception NoSuchElementException) {
                        p.setGrade(0);
                    }
                    try {
                        p.setFirstParticipantPreference(st.nextToken());
                    } catch (Exception NoSuchElementException) {
                        p.setFirstParticipantPreference(null);
                    }
                    try {
                        p.setSecondParticipantPreference(st.nextToken());
                    } catch (Exception NoSuchElementException) {
                        p.setSecondParticipantPreference(null);
                    }
                    try {
                        p.setThirdParticipantPreference(st.nextToken());
                    } catch (Exception NoSuchElementException) {
                        p.setThirdParticipantPreference(null);
                    }
                    try {
                        p.setUsername(st.nextToken());
                    } catch (Exception NoSuchElementException) {
                        p.setUsername(null);
                    }
                    try {
                        p.setPassword(st.nextToken());
                    } catch (Exception NoSuchElementException) {
                        p.setPassword(null);
                    }

                }
                addParticipant(p);
            }
            input.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This method populates the event array using the event objects in written text from the file
     */
    public static void populateEventArrayFromFile() {

        String line = "";
        Event e;

        StringTokenizer st = new StringTokenizer(line, ",");
        try {
            //Finds file
            File file = new File("event.txt");
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                line = input.nextLine();
                //Creates tokenizer
                st = new StringTokenizer(line, ",");
                // Populate New Participant
                e = new Event(null, null, 0, 0);
                if (st.hasMoreTokens()) {
                    //Sets proper tokens to proper properties
                    try {
                        e.setTitle(st.nextToken());
                    } catch (Exception NoSuchElementException) {
                        e.setTitle(null);
                    }
                    try {
                        e.setAuthor(st.nextToken());
                    } catch (Exception NoSuchElementException) {
                        e.setAuthor(null);
                    }
                    try {
                        e.setGrade(Integer.parseInt(st.nextToken()));
                    } catch (Exception NoSuchElementException) {
                        e.setGrade(0);
                    }
                    try {
                        e.setEventSize(Integer.parseInt(st.nextToken()));
                    } catch (Exception NoSuchElementException) {
                        e.setEventSize(0);
                    }


                }
                addEvent(e);
            }
            input.close();

        } catch (Exception f) {
            f.printStackTrace();
        }

    }
}
