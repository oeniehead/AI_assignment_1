package net.oeniehead;

public class Main {

    public static void main(String[] args) {

        //De graaf van de slides:
        /*Graph graph = new Graph();

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
        graph.connect(h, i, 7);*/


        // Bouw een random graaf met 200 vertices die met 40% kans verbonden zijn:
        Graph graph = new Graph();
        graph.makeRandom(10, 0.0f);

        System.out.println(graph.toString());

        // Los de graaf op:
        Prim p = new Prim(graph);

        System.out.println(p.solve().toString());
        System.out.println(p.getEdgeHits() + " edge considerations (" + p.getExtraEdgeHits() + " extra)");
        System.out.println("Done in " + p.getRunTime() + " ms");
    }
}
