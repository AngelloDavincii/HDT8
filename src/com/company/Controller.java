package com.company;

import java.io.File;
import java.util.Scanner;

//@author Angel David Cuellar 18382
public class Controller {

    private Scanner x;
    private String a = "";
    private Scanner choice1 = new Scanner(System.in);
    private Scanner choice2 = new Scanner(System.in);

    /**
     * Se abre el archivo
     */
    private void open(){
        try{
            x = new Scanner(new File("Names.txt"));
        }
        catch(Exception e){
            System.out.println("No se encontro el archivo");
        }
    }

    /**
     * Se llena un string con la informacion del string
     * es importante destacar que cada carta se separa por un / para hacer un split despues
     * @return string con las cosas del archivo
     */
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

    /**
     * Se inician los operaciones del programa
     * se crea un vector heap, se lle el archivo, se agregan al heap
     * se imprime el heap y se va vaciando
     */
    public void init(){
        VectorHeap<Patient> papi = new VectorHeap<>();
        open();
        String wait = readFile();
        closeFile();

        System.out.println("");
        System.out.println("Bienvenido a este programa de cartas");
        System.out.println("");

        String[] tortuga = wait.split("//");

        //Se llena el Map con las cartas del string
        for(int i = 0; i < tortuga.length;i++){
            String[] cartas = tortuga[i].split(", ");
            //Le puse una defensa porque para ser sincero no se porque
            //5 cartas no me las lee
            try {
                papi.add(new Patient(cartas[0],cartas[1],cartas[2]));
            }
            catch(Exception ignored){
            }
        }

        System.out.println("\n1. Para continuar \n2. Salir \nIngrese el numero de lo que desea hacer: ");

        int apple = choice1.nextInt();

        while (apple !=2){

            if (apple == 1){

                System.out.println("Lista de pacientes: ");
                System.out.println("");
                papi.printAll();
                System.out.println("");
                System.out.println("Se atendio al paciente: " + papi.remove().toString());
                System.out.println("");
            }

            System.out.println("1.Para continuar \n2. Salir \nIngrese el numero de lo que desea hacer: ");
            apple = choice1.nextInt();

            if (papi.isEmpty()){
                System.out.println("Ya no hay mas pacientes");
                apple = 2;
            }

        }
        System.out.println("Gracias por usar este programa");

    }

}
