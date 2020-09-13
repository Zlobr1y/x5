package Task3;

public class Aspirant extends Student {
    @Override
    int getScholarship() {
        if (avgMark == 5){
            return 200;
        }
        return 180;
    }
}
