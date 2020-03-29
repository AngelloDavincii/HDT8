//@author Angel David Cuellar 18382

import java.util.Iterator;
import java.util.Vector;
import java.util.PriorityQueue;

public class Heap<E>{
    public PriorityQueue heap;

    public Heap(){
        heap = new PriorityQueue<E>();
    }

    /**
     *
     * @param value se agrega nuevo elemento del tipo paciente al priorityQueue
     */
    public void add(E value){
        heap.add(value);
    }

    /**
     * Imprimimos todos los elementos de pacientes
     */
    public void printAll(){
        Iterator itr = heap.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
    }

    /**
     * remueve el paciente que esta hasta arriba
     * @return el toString del paciente que eliminamos
     */
    public String queue(){
        String person = heap.poll().toString();
        return person;
    }

    /**
     *
     * @return boolean para ver si esta vacio o no
     */
    public boolean isEmpty(){
        return heap.isEmpty();
    }


}