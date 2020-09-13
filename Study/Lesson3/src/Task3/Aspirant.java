package Task3;

public class Aspirant extends Student {
    String scientificWork;
    @Override
    int getScholarship() {
        if (avgMark == 5){
            return 200;
        }
        return 180;
    }
}
