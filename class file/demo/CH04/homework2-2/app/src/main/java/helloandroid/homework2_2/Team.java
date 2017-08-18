package helloandroid.homework2_2;

/**
 * Created by hadesshark on 2017/8/17.
 */

public class Team {
    private int num;
    private String name;
    private int logo;

    public Team() {
    }

    public Team(int num, int logo, String name) {
        this.num = num;
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

    public int getNum() { return num; }

    public void setNum(int num) {
        this.num = num;
    }
}


