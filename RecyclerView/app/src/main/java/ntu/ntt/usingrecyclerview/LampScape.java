package ntu.ntt.usingrecyclerview;

public class LampScape {
    String landImageFileName;
    String landCation;

    //Constructor
    public LampScape(String landImageFileName, String landCation) {
        this.landImageFileName = landImageFileName;
        this.landCation = landCation;
    }

    //Getter Setter
    public String getLandImageFileName() {
        return landImageFileName;
    }
    public void setLandImageFileName(String landImageFileName) {
        this.landImageFileName = landImageFileName;
    }
    public String getLandCation() {
        return landCation;
    }
    public void setLandCation(String landCation) {
        this.landCation = landCation;
    }
}
