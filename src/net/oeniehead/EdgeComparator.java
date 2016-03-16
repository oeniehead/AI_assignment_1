package net.oeniehead;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> {
    /**
     * Vergelijk twee edges op basis van hun gewicht
     * @param e1
     * @param e2
     * @return
     */
    @Override
    public int compare(Edge e1, Edge e2) {
        return Integer.compare(e1.getWeight(), e2.getWeight());
    }
}
