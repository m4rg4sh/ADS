package P04_Baume;

import java.text.*;
import java.util.*;

public final class Competitor implements Comparable<Competitor> {

    private final SimpleDateFormat TIME_FORMAT
            = new SimpleDateFormat("HH:mm:ss.S");

    private int number;
    private String firstName;
    private String lastName;
    private int yearOfBirth;

    private String city;

    private Date time;

    public Competitor(int number, String firstName, String lastName,
                      int yearOfBirth, String city, String timeString)
            throws NullPointerException, ParseException {

        /* Check and adopt parameters. */
        if (firstName == null) {
            throw new NullPointerException("Parameter \"firstName\" is null.");
        }
        if (lastName == null) {
            throw new NullPointerException("Parameter \"lastName\" is null.");
        }
        if (city == null) {
            throw new NullPointerException("Parameter \"city\" is null.");
        }
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.city = city;
        this.time = TIME_FORMAT.parse(timeString);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Competitor) {
            return firstName.equals(((Competitor) object).firstName) && lastName.equals(((Competitor) object).lastName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {

        return new String("#" + number + ": " + firstName + " " + lastName + " (" + yearOfBirth + ") from "
                + city + ", Time: " + TIME_FORMAT.format(time));
    }


    @Override
    public int compareTo(Competitor competitor) {
        Collator collator = Collator.getInstance();

        int result = collator.compare(lastName,competitor.lastName);
        if (result == 0) {
            result = collator.compare(firstName,competitor.firstName);
        }
        return result;
    }

    public int getNumber() {
        return number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getCity() {
        return city;
    }

    public Date getTime() {
        return time;
    }

    public String returnTimeString() {
        return TIME_FORMAT.format(time);
    }
}
