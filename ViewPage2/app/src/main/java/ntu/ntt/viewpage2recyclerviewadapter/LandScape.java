package ntu.ntt.viewpage2recyclerviewadapter;

public class LandScape {
    String landImageFileName;
    String landCapion;

    //Constructor

    public LandScape(String landImageFileName, String landCapion) {
        this.landImageFileName = landImageFileName;
        this.landCapion = landCapion;
    }


    //Getter Setter

    public String getLandImageFileName() {
        return landImageFileName;
    }

    public void setLandImageFileName(String landImageFileName) {
        this.landImageFileName = landImageFileName;
    }

    public String getLandCapion() {
        return landCapion;
    }

    public void setLandCapion(String landCapion) {
        this.landCapion = landCapion;
    }
}
