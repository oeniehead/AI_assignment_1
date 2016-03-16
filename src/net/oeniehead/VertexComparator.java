package net.oeniehead;

import java.util.Comparator;

public class VertexComparator implements Comparator<Vertex> {
    /**
     * Vergelijk twee vertices op basis van hun gewicht
     * @param v1
     * @param v2
     * @return
     */
    @Override
    public int compare(Vertex v1, Vertex v2) {
        return Integer.compare(v1.getWeight(), v2.getWeight());
    }
}
