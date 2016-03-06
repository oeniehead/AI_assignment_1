package net.oeniehead;


public class Edge {
    private int weight;
    private Vertex from;
    private Vertex to;

    public Edge(Vertex from, Vertex to, int weight)
    {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Vertex other(Vertex from)
    {
        if(this.from == from)
        {
            return this.to;
        }
        else
        {
            return this.from;
        }
    }

    public boolean connectsTo(Vertex vertex)
    {
        return this.to == vertex || this.from == vertex;
    }

    public int getWeight()
    {
        return this.weight;
    }

    public Vertex getFrom()
    {
        return this.from;
    }

    public Vertex getTo()
    {
        return this.to;
    }

}
