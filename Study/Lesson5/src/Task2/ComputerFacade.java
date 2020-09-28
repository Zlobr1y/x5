package Task2;

public class ComputerFacade {

    private CpuSpecifications cpuSpecs;
    private RamSpecifications ramSpecs;
    private GpuSpecifications gpuSpecs;
    private DriveSpecifications driveSpecs;

    public ComputerFacade() {
        this.cpuSpecs = new CpuSpecifications();
        this.ramSpecs = new RamSpecifications();
        this.gpuSpecs = new GpuSpecifications();
        this.driveSpecs = new DriveSpecifications();
    }

    public void computerSpecifications() {
        cpuSpecs.showCpuSpecs();
        ramSpecs.showRamSpecs();
        gpuSpecs.showGpuSpecs();
        driveSpecs.showDriveSpecs();
    }

}