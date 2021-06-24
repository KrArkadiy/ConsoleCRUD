package model;

import com.google.gson.annotations.SerializedName;

public class Label {
    private Integer id;

    private String name;

    public Label(String name, Integer id){
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
