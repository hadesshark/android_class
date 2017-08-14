package hadesshark.idv.newproject;

/**
 * Created by 201 on 2017/8/14.
 */

public class Team {
    private String name;
    private int logo;

    public Team() {
    }

    public Team(int logo, String name) {
        this.name = name;
        this.logo = logo;
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
