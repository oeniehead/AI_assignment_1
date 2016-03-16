package net.oeniehead;


import java.util.PriorityQueue;

public class Prim {
    private Graph subject;
    private Graph mst;

    private Vertex root;
    private int edgeHits;
    private long runTime;

    private PriorityQueue<Vertex> frontier;

    public Prim(Graph subject)
    {
        this.subject = subject;
    }

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

    private void prepare()
    {
        this.mst = new Graph();
        this.frontier = new PriorityQueue<>(new VertexComparator());
        this.edgeHits = 0;

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

    private void run()
    {
        while(this.frontier.size() > 0)
        {
            Vertex current = this.frontier.poll();

            if(current.isDone()) continue;

            current.setDone(true);

            System.out.println("Current: " + current.getLabel() + " " + current.getWeight());

            for(Edge edge : this.subject.getConnection(current))
            {
                Vertex other = edge.other(current);

                System.out.println(" - connects: " + other.getLabel() + "  " + edge.getWeight());

                int newWeight = edge.getWeight();

                System.out.println(" - weight: " + other.getWeight() + " new weight: " + newWeight);

                if(other.getWeight() > newWeight && !other.isDone()) {
                    System.out.println(" - " + current.getLabel() + " is parent of " + other.getLabel() + " with weight " + newWeight);

                    this.edgeHits++;

                    other.setWeight(newWeight);
                    other.setParent(current);
                    this.frontier.add(other);
                }
            }
        }
    }

    private void buildMST()
    {
        //int totalWeight = 0;

        for(Vertex vertex: this.subject.getVertices())
        {
            if(vertex.getParent() == null) continue;

            //totalWeight += vertex.getWeight();

            this.mst.connect(vertex, vertex.getParent(), vertex.getWeight());
        }

        //System.out.println("Total weight: " + totalWeight);
    }

    public int getEdgeHits()
    {
        return this.edgeHits;
    }
    public int getExtraEdgeHits()
    {
        return this.edgeHits - this.subject.getVertices().size() + 1;
    }

    public long getRunTime() { return this.runTime; }

    public Graph getMST()
    {
        return this.mst;
    }
}
