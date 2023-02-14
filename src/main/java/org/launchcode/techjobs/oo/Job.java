package org.launchcode.techjobs.oo;

import java.lang.reflect.Field;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
       id = nextId;
       nextId ++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object obj) {
       if(this == obj){
           return true;
       } if(obj == null || getClass() != obj.getClass()){
           return false;
        } Job job = (Job) obj;
       return id == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public  String toString(){
       String label = "\nID: " + id;
       if(name != null && name != ""){
           label += "\nName: " + name;
       }else {
           label += "\nName: Data not available";
       }
       if(employer != null && !employer.getValue().equals("")){
           label += "\nEmployer: " + employer;
       }else {
           label += "\nEmployer: Data not available";
       }
       if(location != null && !location.getValue().equals("")){
           label += "\nLocation: " + location;
       }else {
           label += "\nLocation: Data not available";
       }
       if(positionType !=null && !positionType.getValue().equals("")){
           label += "\nPosition Type: " + positionType;
       }else {
           label += "\nPosition Type: Data not available";
       }
       if(coreCompetency != null && !coreCompetency.getValue().equals("")){
           label += "\nCore Competency: " + coreCompetency;
       } else {
           label += "\nCore Competency: Data not available";
       }

      return label + "\n";
    }

}
