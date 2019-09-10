package Algorithms.lesson7.test;

import Algorithms.lesson7.Graph;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class GraphTest {

    private Graph graph;

    @Before
    public void setUp() throws Exception {
        graph = new Graph(10);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");
    }

    @Test
    public void addVertex() {
        graph.addVertex("Магадан");
        assertEquals(11, graph.getSize());
    }

    @Test
    public void addEdges() {
        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");

        graph.display();

    }

    @Test
    public void addEdge() {
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");

        graph.display();
    }

    @Test
    public void dfs() {
        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");

        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");

        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Саратов", "Воронеж");

        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Курск", "Воронеж");

        graph.dfs("Москва");
//      Москва, Тула, Липецк, Воронеж, Саратов, Тамбов, Рязань, Курск, Орел, Калуга
    }

    @Test
    public void bfs() {
        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");

        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Липецк", "Воронеж");

        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Саратов", "Воронеж");

        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Курск", "Воронеж");

        graph.bfs("Москва");
    }

    @Test
    public void dfsTest() {
        Graph graph1 = new Graph(7);

        graph1.addVertex("A");
        graph1.addVertex("B");
        graph1.addVertex("C");
        graph1.addVertex("D");
        graph1.addVertex("E");
        graph1.addVertex("F");
        graph1.addVertex("G");

        graph1.addEdges("A", "B", "C", "D");
        graph1.addEdge("B", "E");
        graph1.addEdge("D", "F");
        graph1.addEdge("F", "G");

        graph1.dfs("A");
        //ABECDFG
    }

    @Test
    public void bfsTest() {
        Graph graph = new Graph(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdges("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("E", "H");
        graph.addEdge("C", "F");
        graph.addEdge("D", "G");

        graph.bfs("A");
        //ABCDEFGH
    }

    @Test
    public void search() {
        Graph graph1 = new Graph(9);

        graph1.addVertex("A");
        graph1.addVertex("B");
        graph1.addVertex("C");
        graph1.addVertex("D");
        graph1.addVertex("E");
        graph1.addVertex("F");
        graph1.addVertex("G");
        graph1.addVertex("H");
        graph1.addVertex("R");

        graph1.addEdges("A", "B", "C", "D");
        graph1.addEdge("B", "E");
        graph1.addEdge("E", "H");
        graph1.addEdge("H", "R");
        graph1.addEdge("C", "F");
        graph1.addEdge("D", "G");
        graph1.addEdge("G", "R");

        Stack<String> stack = graph1.searchBfs("A", "R");
        showShortPath(stack);

    }

    private void showShortPath(Stack<String> path) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        while ( !path.isEmpty() ) {
            if (!isFirst) {
                sb.append(" -> ");
            }
            isFirst = false;
            sb.append(path.pop());
        }

        System.out.println(sb);
    }
}