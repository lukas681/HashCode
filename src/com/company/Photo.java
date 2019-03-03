package com.company;

import java.util.ArrayList;

public class Photo {
    String type;
    String id;
    ArrayList<String> tags;

    public String getId() {
        return id;
    }

    public int getNumTags(){
        return tags.size();
    }
    public Photo(String type, String name, ArrayList<String> tags) {
        this.type = type;
        this.id = name;
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
