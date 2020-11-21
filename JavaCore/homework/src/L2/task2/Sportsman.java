package L2.task2;

public class Sportsman {
    private String name;
    private boolean hasRecord;
    private boolean hasTeam;

    public Sportsman(String name, boolean hasRecord, boolean hasTeam) {
        this.name = name;
        this.hasRecord = hasRecord;
        this.hasTeam = hasTeam;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasRecord() {
        return hasRecord;
    }

    public void setHasRecord(boolean hasRecord) {
        this.hasRecord = hasRecord;
    }

    public boolean isHasTeam() {
        return hasTeam;
    }

    public void setHasTeam(boolean hasTeam) {
        this.hasTeam = hasTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Sportsman) {
            if (this.hasRecord == ((Sportsman) o).isHasRecord() && this.hasTeam == ((Sportsman) o).isHasTeam()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
