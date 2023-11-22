package user;

import java.util.ArrayList;
import java.util.List;
import sportfacility.*;

public class Admin extends User {

    private Account account;
    private List<SportFacility> facilitiesList = new ArrayList<>();
    private List<Bookings> cancelRequests = new ArrayList<>();

    public Admin(String username, String password) {
        super(username, password);
    }

    public void addFacility(SportFacility facility) {
        facilitiesList.add(facility);
    }

    public void removeFacility(SportFacility facility) {
        facilitiesList.remove(facility);
    }

    public static boolean confirmBooking(Bookings booking) {
        // check for conflicting schedules
        Main.addBooking(booking);
    }

    public void receiveCancelRequest(Customer customer, String bookingId) {
        // Main will feed the booking object the customer wants to cancel here.
        // check if booking is cancellable based on the start time against system time.

        // if booking is cancellable, delete the booking from user list (the user is inside the booking object)
        // else print Booking is not refundable as start time is too soon with system time.
    }

    public void showCancelRequests() {
    }

    public void approveRequest(int requestID) {
    }

    // Create a new facility based on the provided information
    public void createFacility(String facilityType, int openingHours, int closingHours, int bookingFee) {
        SportFacility facility = null;
        switch (facilityType.toLowerCase()) {
            case "badminton court":
                facility = new BadmintonCourt(openingHours, closingHours, bookingFee);
                break;
            case "basketball court":
                facility = new BasketballCourt(openingHours, closingHours, bookingFee);
                break;
            case "swimming pool":
                facility = new SwimmingPool(openingHours, closingHours, bookingFee);
                break;
            case "tennis court":
                facility = new TennisCourt(openingHours, closingHours, bookingFee);
                break;
            default:
                System.out.println("Invalid facility type.");
                return;
        }
        addFacility(facility);
        System.out.println("Facility created successfully.");
    }

    // Remove a facility from the facilitiesList
    public void removeFacility(String facilityType) {
        SportFacility facilityToRemove = null;
        for (SportFacility facility : facilitiesList) {
            if (facility.getClass().getSimpleName().equalsIgnoreCase(facilityType)) {
                facilityToRemove = facility;
                break;
            }
        }
        if (facilityToRemove != null) {
            removeFacility(facilityToRemove);
            System.out.println("Facility removed successfully.");
        } else {
            System.out.println("Facility not found.");
        }
    }
}