package lk.harshana.model;

/**
 * Created by cmdhmjayamaha on 5/12/17.
 */
public class Greeting {

    /** The id. */
    private int id;
    
    /** The name. */
    private String name;

    /**
     * Instantiates a new greeting.
     *
     * @param id the id
     * @param name the name
     */
    public Greeting(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }
}
