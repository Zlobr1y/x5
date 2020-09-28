package Task2;

public class CpuSpecifications {

    float cpuFrequency = 3.2f;
    int cpuCores = 4;
    float cpuCache = 6;
    String cpuName = "i5";
    String cpuBrand = "Intel";

    public void showCpuSpecs() {
        System.out.println("cpuBrand: " + cpuBrand);
        System.out.println("cpuName: " + cpuName);
        System.out.println("cpuFrequency: " + cpuFrequency + "Hz");
        System.out.println("cpuCores: " + cpuCores);
        System.out.println("cpuCache: " + cpuCache + "Mb");
        System.out.println("\n");
    }

}
