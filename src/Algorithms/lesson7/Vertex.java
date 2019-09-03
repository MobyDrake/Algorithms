package Algorithms.lesson7;

public class Vertex {

    private final String label;
    private boolean visited;


    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }
}
