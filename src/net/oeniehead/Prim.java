package net.oeniehead;


import java.util.PriorityQueue;

public class Prim {
    private Graph subject;
    private Graph mst;

    private Vertex root;
    private int edgeHits;
    private long runTime;
    private int totalWeight;

    private PriorityQueue<Vertex> frontier;

    public Prim(Graph subject)
    {
        this.subject = subject;
    }

    /**
     * Voer Prim's algoritme uit
     * @return
     */
    public Graph solve()
    {
        long startTime = System.currentTimeMillis();

        this.prepare();
        this.run();
        this.buildMST();

        long endTime = System.currentTimeMillis();

        this.runTime = (endTime - startTime);

        return this.mst;
    }

    /**
     * Prepareer de klasse voor uitvoer
     */
    private void prepare()
    {
        this.mst = new Graph();
        this.frontier = new PriorityQueue<>(new VertexComparator());
        this.edgeHits = 0;
        this.totalWeight = 0;

        for(Vertex vertex :this.subject.getVertices())
        {
            vertex.setWeight(Integer.MAX_VALUE);
            vertex.setParent(null);
            vertex.setDone(false);

            this.frontier.add(vertex);

            this.mst.addVertex(vertex);
        }

        this.root = this.frontier.peek();
        this.root.setWeight(0);
    }

    /**
     * Voer Prim's algoritme uit
     */
    private void run()
    {
        while(this.frontier.size() > 0)
        {
            Vertex current = this.frontier.poll();

            // Skip vertices die al gedaan zijn
            if(current.isDone()) continue;

            current.setDone(true);

            for(Edge edge : this.subject.getConnection(current))
            {
                Vertex other = edge.other(current);

                int newWeight = edge.getWeight();

                if(other.getWeight() > newWeight && !other.isDone()) {
                    this.edgeHits++;

                    other.setWeight(newWeight);
                    other.setParent(current);

                    // Omdat de priorityqueue NIET reordered, voeg dit element opnieuw toe
                    this.frontier.add(other);
                }
            }
        }
    }

    /**
     * Bouw een graaf op basis van de gevonden waarden
     */
    private void buildMST()
    {
        for(Vertex vertex: this.subject.getVertices())
        {
            if(vertex.getParent() == null) continue;

            this.totalWeight += vertex.getWeight();

            this.mst.connect(vertex, vertex.getParent(), vertex.getWeight());
        }
    }

    /**
     * Geef alle edge hits
     * @return
     */
    public int getEdgeHits()
    {
        return this.edgeHits;
    }

    /**
     * Geef alle niet-optimale edge hits
     * @return
     */
    public int getExtraEdgeHits()
    {
        return this.edgeHits - this.subject.getVertices().size() + 1;
    }

    /**
     * Geef de run-time
     * @return
     */
    public long getRunTime() { return this.runTime; }

    /**
     * Geef het totale gewicht van de gevonden boom
     * @return
     */
    public int getTotalWeight() { return this.totalWeight; }

    /**
     * Geef de graaf
     * @return
     */
    public Graph getMST()
    {
        return this.mst;
    }
}
