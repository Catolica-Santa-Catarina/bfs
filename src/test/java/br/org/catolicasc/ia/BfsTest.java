package br.org.catolicasc.ia;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BfsTest {

    @Test
    void search() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        Node<Integer> start = new Node<>(10);
        Node<Integer> firstNeighbor = new Node<>(2);
        start.connect(firstNeighbor);
        firstNeighbor.connect(start);

        Node<Integer> firstNeighborNeighbor = new Node<>(3);
        firstNeighbor.connect(firstNeighborNeighbor);
        firstNeighborNeighbor.connect(firstNeighbor);
        firstNeighborNeighbor.connect(start);
        start.connect(firstNeighborNeighbor);

        Node<Integer> secondNeighbor = new Node<>(4);
        start.connect(secondNeighbor);
        secondNeighbor.connect(start);

        Bfs.search(4, firstNeighborNeighbor);

        String expectedString = """
                Visitando nó com o valor 3
                Visitando nó com o valor 10
                Visitando nó com o valor 2
                Visitando nó com o valor 4
                """;

        assertEquals(expectedString, bos.toString());
    }
}