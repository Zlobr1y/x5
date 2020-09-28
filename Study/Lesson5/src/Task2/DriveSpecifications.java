package Task2;

public class DriveSpecifications {

    String driveBrand = "Kingston";
    float driveVolume = 240;
    String driveType = "SSD";
    String driveFormFactor = "2.5";

    public void showDriveSpecs() {
        System.out.println("driveBrand: " + driveBrand);
        System.out.println("driveVolume: " + driveVolume + "Gb");
        System.out.println("driveType: " + driveType);
        System.out.println("driveFormFactor: " + driveFormFactor + " inch");
        System.out.println("\n");
    }
}
