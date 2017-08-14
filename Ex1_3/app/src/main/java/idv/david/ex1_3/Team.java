package idv.david.ex1_3;

public class Team {
    private String name;
    //drawable's ID
    private int logo;

    public Team(int logo, String name) {
        this.name = name;
        this.logo = logo;
    }

    public Team() {
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
