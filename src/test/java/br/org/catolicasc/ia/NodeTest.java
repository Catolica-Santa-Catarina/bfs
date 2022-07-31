package br.org.catolicasc.ia;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void getValue() {
        int value = 2;
        Node<Integer> node = new Node<>(value);

        assertEquals(value, node.getValue());
    }

    @Test
    void getNeighbors() {
        Node<Integer> node = new Node<>(1);
        Node<Integer> neighbor = new Node<>(2);
        node.connect(neighbor);
        Set<Node<Integer>> nodeSet = new HashSet<>();
        nodeSet.add(neighbor);

        assertEquals(nodeSet, node.getNeighbors());
    }
}