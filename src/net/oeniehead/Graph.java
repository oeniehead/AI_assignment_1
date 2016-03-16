package net.oeniehead;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class Graph {
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
    private Hashtable<Vertex, ArrayList<Edge>> connections;
    private Random dice;

    public Graph()
    {
        this.connections = new Hashtable<>();
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    /**
     * Geef een representatie van dit object als string
     * @return
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for(Vertex vertex: vertices)
        {
            sb.append("V: " + vertex.toString() + '\n');

            for(Edge edge: connections.get(vertex))
            {
                sb.append(" -> " + edge.other(vertex).toString() + " (" + edge.getWeight() + ")\n");
            }
        }

        return sb.toString();
    }

    /**
     * Voeg een vertex toe
     * @param v
     */
    public void addVertex(Vertex v)
    {
        this.vertices.add(v);
        connections.put(v, new ArrayList<>());
    }

    /**
     * Geef alle vertices
     * @return
     */
    public ArrayList<Vertex> getVertices()
    {
        return this.vertices;
    }

    /**
     * Verbind twee vertices met elkaar
     * @param from De eerste vertex
     * @param to De tweede vertex
     * @param weight Het gewicht van deze verbinding
     */
    public void connect(Vertex from, Vertex to, int weight)
    {
        Edge edge = new Edge(from, to , weight);

        for(Edge current: connections.get(from))
        {
            if(current.other(from) == to)
            {
                return;
            }
        }

        connections.get(from).add(edge);
        connections.get(to).add(edge);
    }

    public ArrayList<Edge> getConnection(Vertex vertex)
    {
        return this.connections.get(vertex);
    }

    /**
     * Maak de huidige graaf willekeurig
     * @param vertices De hoeveelheid vertices
     * @param density Met welke kans de knopen met elkaar moeten zijn verbonden
     */
    public void makeRandom(int vertices, float density)
    {
        this.connections = new Hashtable<>();
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.dice = new Random();

        Vertex prev = new Vertex("0");
        this.addVertex(prev);
        for(int i = 1; i < vertices; i++)
        {
            Vertex next = new Vertex(i + "");
            this.addVertex(next);
            this.connect(prev, next, this.randomWeight());

            prev = next;
        }

        for(Vertex a: this.getVertices())
        {
            for(Vertex b: this.getVertices())
            {
                if(a == b) continue;

                if(dice.nextFloat() <= density)
                    this.connect(a, b, this.randomWeight());
            }
        }
    }

    /**
     * Geef een willekeurig gewicht
     * @return
     */
    private int randomWeight()
    {
        return dice.nextInt(1000000);
    }
}
