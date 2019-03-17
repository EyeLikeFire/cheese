package org.launchcode.cheesemvc.models;

public class Cheese {

    private String name; //if these are public then one change of the class changes them all
    private String description;

    public Cheese(String name, String description){
        //This is the initializer
        this.name = name;
        this.description = description;
    }

    public void setName (String aName){
        name = aName;
    }

    public String getName(){
        return name;
    }

    public void setDescription (String aDescription){
        description = aDescription;
    }

    public String getDescription (){
        return description;
    }
}
