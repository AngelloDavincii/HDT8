package com.company;

public class Patient implements Comparable<Patient> {
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
    public String getName(){
        return name;
    }
    public String getProblem(){
        return problem;
    }

    /**
     *
     * @param other es un generico que compara dos elementos del mismo tipo
     * @return un numero dependiendo si es mayor, menor o igual
     */
    @Override
    public int compareTo(Patient other) {
        return this.getKey().compareTo(other.getKey());
    }

    /**
     *
     * @return un string con atributos del paciente
     */
    @Override
    public String toString(){
        return getName() + " TIENE: "+getProblem()+" CODIGO: "+getKey();
    }
}
