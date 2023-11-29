package user;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.List;
import sportfacility.*;

public class Admin extends User {
    private static Admin adminInstance = new Admin("admin", "AstralTrapez0idB0dy");
    private LocalDateTime clock;
    private Admin(String username, String password) {
        super(username, password);
        clock = LocalDateTime.now();
    }
    // where do i add facility )):
    // consider editing facility(booking fee change)

    public boolean receiveCancelRequest(Customer customer, int bookingId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy H");

        // Parsing booking start time to LocalDateTime
        String bookingStartTimeString = customer.getBookingStartTime(bookingId);
        LocalDateTime bookingStartTime = LocalDateTime.parse(bookingStartTimeString, formatter);

        long hoursBetween = ChronoUnit.HOURS.between(bookingStartTime, clock);

        if (hoursBetween >= 6) {
            customer.cancelBooking(bookingId);
            return true;
        } else {
            System.out.print("Sorry, this booking cannot be cancelled and is therefore non-refundable.\n" +
                    "A booking can only be cancelled 6 hours or more in advance.\n");
            return false;
        }
    }
    public boolean receiveBookingRequest(Customer customer, SportFacility facility, String bookingDate, int startTime, String paymentString){
        
        if(compareTime(concatenateStringAndInt(bookingDate, startTime))){ //this will solve cannot book in the past. only in future
			return customer.createBooking(facility, bookingDate, startTime, paymentString);
		}
		else{
            System.out.print("Please choose a valid date. Cannot make a booking in the past.\n");
			return false;
		}
    }
    public boolean compareTime(String dateHour){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy H");
        LocalDateTime bookingStartTime = LocalDateTime.parse(dateHour, formatter);

        if(bookingStartTime.isBefore(clock)){
            return false;
        }
        else{
            return true;
        }

    }

    public void changeTime(String date, String hour){
        String[] sepDate = date.split("-");
        clock = LocalDateTime.of(Integer.parseInt(sepDate[2]), Integer.parseInt(sepDate[1]), Integer.parseInt(sepDate[0]), Integer.parseInt(hour), 0, 0);
    }

    public void resetTime(){
        clock = LocalDateTime.now();
    }

    public void printTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateNtime = clock.format(formatter);
        System.out.print(dateNtime + "\n");
    }

    public static Admin getInstance(){
        return adminInstance;
    }
    public static String concatenateStringAndInt(String str, int number) {
		return str + " " + number;
	}
}
