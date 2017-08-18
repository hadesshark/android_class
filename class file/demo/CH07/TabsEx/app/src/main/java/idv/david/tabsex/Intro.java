package idv.david.tabsex;

import java.io.Serializable;

public class Intro implements Serializable{
    private String name;
    private String cName;
    private int imageId;

    public Intro(String name, String cName, int imageId) {
        this.name = name;
        this.cName = cName;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
