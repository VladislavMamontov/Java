package Lesson_7;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdgeCount(1, 5);
        graph.addEdgeCount(2, 3);
        graph.addEdgeCount(3, 5);
        graph.addEdgeCount(3, 4);
        graph.addEdgeCount(4, 6);
        graph.addEdgeCount(5, 6);
        graph.addEdgeCount(5, 8);
        graph.addEdgeCount(6, 9);
        graph.addEdgeCount(6, 7);
        graph.addEdgeCount(0, 7);

        DepthFirstPaths dfp = new DepthFirstPaths(graph,1);
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph,1);
        System.out.println(graph.adjList(6));
        System.out.println(dfp.pathTo(7));
        System.out.println(bfs.distTo(7));
        System.out.println(bfs.pathTo(7));



    }
}
