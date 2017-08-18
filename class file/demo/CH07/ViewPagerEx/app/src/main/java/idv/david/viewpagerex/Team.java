package idv.david.viewpagerex;

import java.io.Serializable;

public class Team implements Serializable {
    private String name;
    //drawable's ID
    private int logo;

    public Team() {

    }

    public Team(int logo, String name) {
        this.logo = logo;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
