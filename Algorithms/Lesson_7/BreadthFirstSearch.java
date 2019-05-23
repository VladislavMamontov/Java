package Lesson_7;

import java.util.LinkedList;

public class BreadthFirstSearch {
    private int source;
    private int[] edgeTo;
    private  int[] distTo;
    private boolean[] marked;
    private int inf = Integer.MAX_VALUE;

    public BreadthFirstSearch (Graph graph, int source){
        if (source < 0 || source > graph.vertexCount() - 1){
            throw new IllegalArgumentException();
        }
        this.source = source;
        edgeTo = new int[graph.vertexCount()];
        distTo = new int[graph.vertexCount()];
        marked = new boolean[graph.vertexCount()];
        for (int i = 0; i < graph.vertexCount(); i++) {
            distTo[i] = inf;
        }
        bfs(graph, source);
    }

    private void bfs (Graph graph, int vertex){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(vertex);
        distTo[vertex] = 0;
        marked[vertex] = true;
        while (!queue.isEmpty()){
            int currentVertex = queue.removeFirst();
            for (int w:
                 graph.adjList(currentVertex)) {
                if (!marked[w]){
                    distTo[w] = distTo[currentVertex] + 1;
                    edgeTo[w] = currentVertex;
                    marked[w] = true;
                    queue.addLast(w);
                }

            }
        }
    }

    public boolean hasPathTo (int vertex){
        if (vertex < 0 || vertex > marked.length - 1){
            throw new IllegalArgumentException();
        }
        return marked[vertex];
    }

    public LinkedList<Integer> pathTo (int vertex){
        if (!hasPathTo(vertex)){
            return null;
        }
        LinkedList<Integer> path = new LinkedList<>();
        int currentVertex = vertex;
        while (currentVertex != source){
            path.push(currentVertex);
            currentVertex = edgeTo[currentVertex];
        }
        return path;
    }

    public int distTo (int vertex){
        if (vertex < 0 || vertex > marked.length - 1){
            throw new IllegalArgumentException();
        }
        return distTo[vertex];
    }




}
