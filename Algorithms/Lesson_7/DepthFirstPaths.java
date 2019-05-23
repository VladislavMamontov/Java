package Lesson_7;

import java.util.LinkedList;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DepthFirstPaths (Graph g, int source){
        if (source < 0){
            throw new IllegalArgumentException();
        }
        if (source > g.vertexCount() - 1){
            throw new IndexOutOfBoundsException();
        }
        this.source = source;
        edgeTo = new int[g.vertexCount()];
        marked = new boolean[g.vertexCount()];
        dfp(g,source);
    }

    private void dfp(Graph graph, int vertex){
        marked[vertex] = true;
        for (int w:
             graph.adjList(vertex)) {
            if (!marked[w]){
                edgeTo[w]= vertex;
                dfp(graph, w);
            }
        }
    }

    public boolean hasPathTo (int vertex){
        if(vertex < 0 || vertex > edgeTo.length -1) {
            throw new IllegalArgumentException();
        }
        return marked[vertex];
    }

    public LinkedList<Integer> pathTo (int vertex){
        if (!hasPathTo(vertex)){
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int currentVertex = vertex;
        while (currentVertex != source){
            stack.push(currentVertex);
            currentVertex = edgeTo[currentVertex];
        }
        return stack;
    }





}
