package david.idv.mylistview;

/**
 * Created by 201t on 2017/8/14.
 */

public class Team {
    private int logo;
    private String name;

    public Team() {
    }

    public Team(int logo, String name) {
        this.logo = logo;
        this.name = name;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
