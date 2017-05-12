package lk.harshana.model;

/**
 * Created by cmdhmjayamaha on 5/12/17.
 */
public class Greeting {

    private int id;
    private String name;

    public Greeting(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
