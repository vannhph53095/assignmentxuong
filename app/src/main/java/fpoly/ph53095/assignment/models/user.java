package fpoly.ph53095.assignment.models;

import java.io.Serializable;

public class user implements Serializable {
    private String name ;
    private String pass;

    public user(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
