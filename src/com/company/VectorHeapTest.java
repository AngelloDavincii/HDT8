package com.company;

import java.util.Vector;
import static org.junit.jupiter.api.Assertions.*;

class VectorHeapTest {


    @org.junit.Test
    public void add() {
        VectorHeap bros = new VectorHeap();
        bros.add(new Patient("Hola","que","hace"));
    }

    @org.junit.Test
    public void remove() {
        VectorHeap bros = new VectorHeap();
        bros.add(new Patient("Hola","que","hace"));
        Object c1 = bros.getFirst();
        Object c2 = bros.remove();
        assertEquals(c1, c2);

    }

}