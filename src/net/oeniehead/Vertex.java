package net.oeniehead;


public class Vertex {
    private String label;

    private int weight = Integer.MAX_VALUE;
    private Vertex parent;

    private boolean done;

    /**
     * Maak een vertex met een label
     * @param label
     */
    public Vertex(String label)
    {
        this.label = label;
    }

    /**
     * Geef het label
     * @return
     */
    public String getLabel() {
        return label;
    }

    /**
     * Geef een representatie van deze vertex als string
     * @return
     */
    @Override
    public String toString()
    {
        return this.getLabel();
    }

    /**
     * Geef het gewicht van deze vertex, dit is voor Prim
     * @return
     */
    public int getWeight()
    {
        return this.weight;
    }

    /**
     * Zet het gewicht van deze vertex, dit is voor Prim
     * @param weight
     */
    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    /**
     * Geef de parent van deze vertex, dit is voor Prim
     * @return
     */
    public Vertex getParent() {
        return parent;
    }

    /**
     * Zet de parent van deze vertex, dit is voor Prim
     * @param parent
     */
    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    /**
     * Controleer of deze vertex al behandeld is
     * @return
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Zet de behandeld vlag van deze vertex
     * @param done
     */
    public void setDone(boolean done) {
        this.done = done;
    }
}
