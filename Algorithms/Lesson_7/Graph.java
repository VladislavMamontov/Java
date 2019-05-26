package Lesson_7;

import java.util.LinkedList;

public class Graph {
    private int vertexCount;
    private int edgeCount;
    private LinkedList<Integer>[] adjLists;

    public Graph (int vertexCount){
        if (vertexCount < 0){
            throw new IllegalArgumentException("Vertex count can not be negativ.");
        }
        this.vertexCount = vertexCount;
        adjLists = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    public int vertexCount (){return vertexCount;}

    public int edgeCount () { return edgeCount;}

    public void addEdgeCount (int v1, int v2){
        if (v1 < 0 || v2 < 0 || v1 > vertexCount - 1 || v2 > vertexCount - 1){
            throw new IllegalArgumentException("Vertex count can not be negativ.");
        }
        adjLists[v1].add(v2);
        adjLists[v2].add(v1);
        edgeCount++;
    }

    public LinkedList<Integer> adjList (int vertex){
        if (vertex < 0 || vertex > vertexCount - 1){
            throw new IllegalArgumentException("Vertex count can not be negativ.");
        }
        return adjLists[vertex];
    }
}
