package Task2;

public class RamSpecifications {

    String ramBrand = "Kingston";
    float ramVolume = 6;
    float ramFrequency = 2666;
    String ramType = "DDR3";

    public void showRamSpecs() {
        System.out.println("ramBrand: " + ramBrand);
        System.out.println("ramVolume: " + ramVolume + "Gb");
        System.out.println("ramFrequency: " + ramFrequency + "MHz");
        System.out.println("ramType: " + ramType);
        System.out.println("\n");
    }

}