public class Main {

    public static void main(String[] args) {
        Admin admin = new Admin("admin", "password");

        // Test cases
        admin.createFacility("Basketball Court", 9, 23, 60);
        admin.createFacility("Tennis Court", 10, 22, 80);
        admin.createFacility("Swimming Pool", 8, 20, 70);

        admin.removeFacility("Basketball Court");
        admin.removeFacility("Badminton Court"); // Trying to remove a non-existing facility

        // Print facilities list
        System.out.println("Facilities List:");
        for (SportFacility facility : admin.getFacilitiesList()) {
            System.out.println(facility);
        }
    }
}