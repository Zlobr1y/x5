package Task2;

public class GpuSpecifications {

    String gpuBrand = "GIGABYTE";
    float vramVolume = 6;
    String gpuCollingType = "Active";
    String vramType = "GDDR5";

    public void showGpuSpecs() {
        System.out.println("gpuBrand: " + gpuBrand);
        System.out.println("vramVolume: " + vramVolume + "Gb");
        System.out.println("videoRamType: " + vramType);
        System.out.println("gpuCollingType: " + gpuCollingType);
        System.out.println("\n");
    }

}
