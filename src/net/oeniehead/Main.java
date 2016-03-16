package net.oeniehead;

public class Main {

    public static void main(String[] args) {

        //De graaf van de slides
        Graph graph = new Graph();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");
        Vertex i = new Vertex("I");

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);
        graph.addVertex(g);
        graph.addVertex(h);
        graph.addVertex(i);

        graph.connect(a, b, 4);
        graph.connect(a, h, 8);
        graph.connect(b, c, 8);
        graph.connect(b, h, 11);
        graph.connect(c, d, 7);
        graph.connect(c, f, 4);
        graph.connect(c, i, 2);
        graph.connect(d, e, 9);
        graph.connect(d, f, 14);
        graph.connect(e, f, 10);
        graph.connect(g, f, 2);
        graph.connect(g, h, 1);
        graph.connect(g, i, 6);
        graph.connect(h, i, 7);

        /*
        // Bouw een random graaf met 200 vertices die met 40% kans verbonden zijn:
        Graph graph = new Graph();
        graph.makeRandom(10, 0.0f);

        //System.out.println(graph.toString());
        */

        // Los de graaf op:
        Prim p = new Prim(graph);

        System.out.println(p.solve().toString());
        System.out.println(p.getEdgeHits() + " edge considerations (" + p.getExtraEdgeHits() + " extra)");
        System.out.println("Total weight: " + p.getTotalWeight());
        System.out.println("Done in " + p.getRunTime() + " ms");

        /*
        //Test for different number of vertices
        getAverage(10, 0.4f);
        getAverage(20, 0.4f);
        getAverage(50, 0.4f);
        getAverage(100, 0.4f);
        getAverage(200, 0.4f);
        getAverage(300, 0.4f);
        getAverage(500, 0.4f);
        getAverage(750, 0.4f);
        getAverage(1000, 0.4f);
        getAverage(2000, 0.4f);
        getAverage(5000, 0.4f);
        */

        /*
        //Test for different number of edges
        getAverage(100, 0.0f);
        getAverage(100, 0.1f);
        getAverage(100, 0.2f);
        getAverage(100, 0.3f);
        getAverage(100, 0.4f);
        getAverage(100, 0.5f);
        getAverage(100, 0.6f);
        getAverage(100, 0.7f);
        getAverage(100, 0.8f);
        getAverage(100, 0.9f);
        getAverage(100, 1.0f);
        */

        /*
        //Test for different number of edges
        getAverage(100, 0.0f);
        getAverage(100, 0.1f);
        getAverage(100, 0.2f);
        getAverage(100, 0.3f);
        getAverage(100, 0.4f);
        getAverage(100, 0.5f);
        getAverage(100, 0.6f);
        getAverage(100, 0.7f);
        getAverage(100, 0.8f);
        getAverage(100, 0.9f);
        getAverage(100, 1.0f);
        */

        //For tests with edge weights
        //getAverage(100, 0.5f);
        //getAverage(250, 0.5f);
        //getAverage(500, 0.5f);
    }

    private static void getAverage(int verticeCount, float density){
        int averageEdge = 0;

        for(int i = 0; i < 5; i++) {
            Graph graph = new Graph();
            graph.makeRandom(verticeCount, density);

            // Los de graaf op:
            Prim p = new Prim(graph);
            p.solve();

            averageEdge += p.getEdgeHits();
        }
        System.out.println(verticeCount + " Average edge considerations = " + (averageEdge/5));
    }
}
