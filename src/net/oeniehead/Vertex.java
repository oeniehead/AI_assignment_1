package net.oeniehead;


public class Vertex {
    private String label;

    private int weight = Integer.MAX_VALUE;
    private Vertex parent;

    private boolean done;

    public Vertex(String label)
    {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString()
    {
        return this.getLabel();
    }

    public int getWeight()
    {
        return this.weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
