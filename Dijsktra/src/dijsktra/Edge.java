/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijsktra;


public class Edge {
    private final int weight;
    private final Vertex v1;
    private final Vertex v2;
    
    public Edge(Vertex v1, Vertex v2, int weight){
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }
    
    
}
