package model;

public class Sandwich {
    private int id;
    private String sauce;

    public Sandwich(){}

    public Sandwich(int id, String sauce) {
        this.id = id;
        this.sauce = sauce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }
}
