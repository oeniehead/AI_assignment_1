package net.oeniehead;


public class Edge {
    private int weight;
    private Vertex from;
    private Vertex to;

    /**
     * Maak een nieuwe edge
     * @param from De eerste knoop
     * @param to De tweede knoop
     * @param weight Het gewicht van de verbinding
     */
    public Edge(Vertex from, Vertex to, int weight)
    {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    /**
     * Geef de overstaande vertex
     * @param from
     * @return
     */
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

    /**
     * Kijk of deze edge een vertex verbindt
     * @param vertex
     * @return
     */
    public boolean connectsTo(Vertex vertex)
    {
        return this.to == vertex || this.from == vertex;
    }

    /**
     * Geef het gewicht van deze edge
     * @return
     */
    public int getWeight()
    {
        return this.weight;
    }

    /**
     * Geef de ene vertex
     * @return
     */
    public Vertex getFrom()
    {
        return this.from;
    }

    /**
     * Geef de andere vertex
     * @return
     */
    public Vertex getTo()
    {
        return this.to;
    }

}
