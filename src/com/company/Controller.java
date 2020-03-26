package com.company;

import java.io.File;
import java.util.Scanner;

//@author Angel David Cuellar 18382
public class Controller {

    private Scanner x;
    private String a = "";
    private Scanner choice1 = new Scanner(System.in);
    private Scanner choice2 = new Scanner(System.in);

    private void open(){
        try{
            x = new Scanner(new File("Names.txt"));
        }
        catch(Exception e){
            System.out.println("No se encontro el archivo");
        }
    }
    //Se llena un string con la informacion del string
    //es importante destacar que cada carta se separa por un / para hacer un split despues
    private String readFile(){
        while(x.hasNextLine()){
            a = a.concat(x.nextLine() + "//");
        }
        System.out.println(a);
        return a;
    }
    // cerrar archvio
    private void closeFile() {
        x.close();
    }

    public void init(){
        open();
        String wait = readFile();
        closeFile();

        System.out.println("");
        System.out.println("Bienvenido a este programa de cartas");
        System.out.println("");

        Factory builder = new Factory();
    }

}
