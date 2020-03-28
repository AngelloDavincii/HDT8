package com.company;
//@author Angel David Cuellar 18382
//Clase extraida de la documentacion de Douglas subida a canvas
import java.util.Vector;


public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    /**
     * Creamos variable del tipo vector
     */
    protected Vector<E> data;

    /**
     * Creamos el constructor de la clase
     */
    public VectorHeap() //
    {
        data = new Vector<E>();
    }

    /**
     *
     * @return Primer elemento del vector
     */
    @Override
    public E getFirst() {
        return data.get(0);
    }

    /**
     * Se imprimen todos los pacientes
     */
    public void printAll(){

        for(int i=0 ; i < size();i++){
            System.out.println(data.get(i).toString());
        }
    }

    /**
     *
     * @param v es para agregar cualquier elemento
     */
    public VectorHeap(Vector<E> v)
    {
        int i;
        data = new Vector<E>(v.size()); // we know ultimate size
        for (i = 0; i < v.size(); i++) { // add elements to heap
            add(v.get(i));
        }
    }

    /**
     *
     * @param i el indice donde se encuentra el hijo
     * @return el numero donde se encuentra el padre
     */
    protected static int parent(int i){
        return (i - 1) / 2;
    }

    /**
     *
     * @param i es un indice
     * @return un entero con la posicion del hijo
     */
    protected static int right(int i) // post: returns index of right child of node at location i
    {
        return (2 * i + 1) + 1;
    }

    /**
     *
     * @param leaf es el indice de una hoja para agregar algo
     *             por arriba
     */
    protected void percolateUp(int leaf) // pre: 0 <= leaf < size
    // post: moves node at index leaf up to appropriate position
    {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0
                && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    /**
     *
     * @return el elemento que se elimino
     */
    @Override
    public E remove() // pre: !isEmpty()
    // post: returns and removes minimum value from queue
    {
        E minVal = getFirst();
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) {
            pushDownRoot(0);
        }
        return minVal;
    }

    /**
     *
     * @param root el indice de donde se encuentra la raiz
     */
    protected void pushDownRoot(int root) // pre: 0 <= root < size
    // post: moves node at index root down
    // to appropriate position in subtree
    {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize)
                        && ((data.get(childpos + 1)).compareTo(data.get(childpos)) < 0)) {
                    childpos++;
                }
                // Assert: childpos indexes smaller of two children
                if ((data.get(childpos)).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    data.set(root, value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root, value);
                return;
            }
        }
    }

    /**
     * Es para vaciar el vector
     */
    @Override
    public void clear() {
        data.clear();
    }

    /**
     *
     * @param value se agrega elemento al vector heap
     */
    @Override
    public void add(E value) // pre: value is non-null comparable
    // post: value is added to priority queue
    {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    protected static int left(int i) // pre: 0 <= i < size
    // post: returns index of left child of node at location i
    {
        return 2 * i + 1;
    }

    /**
     * Se revisa si esta vacio el vector
     * @return true si esta vacio
     */
    @Override
    public boolean isEmpty() {
        return data.size() == 0;
    }

    /**
     *
     * @return el tamano del vector
     */
    @Override
    public int size() {
        return data.size();
    }


}