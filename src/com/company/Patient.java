package com.company;

public class Patient {

    private String name;
    private String problem;
    private String key;

    public Patient(String name, String problem, String key) {
        this.name = name;
        this.problem = problem;
        this.key = key;
    }
    public String getKey(){
        return key;
    }
    @Override
    public int CompareTo(Patient other){
        return this.getKey().compareTo(other.getKey());
    }


}
