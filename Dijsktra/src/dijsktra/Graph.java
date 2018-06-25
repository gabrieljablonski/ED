/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijsktra;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Set<Vertex> vertices;
    private Set<Edge> edges;
    private Map<Vertex, Set<Edge>> adjList;
    
    public Graph() {
        vertices = new HashSet<>();
        edges = new HashSet<>();
        adjList = new HashMap<>();
    }
    
    public void addVertex(String label) {
        this.vertices.add(new Vertex(label));
    }

    private void addEdge(Edge e) {
        if (edges.add(e)){
            this.adjList.putIfAbsent(e.getV1(), new HashSet<>());
            this.adjList.putIfAbsent(e.getV2(), new HashSet<>());

            this.adjList.get(e.getV1()).add(e);
            this.adjList.get(e.getV2()).add(e);
        }
    }

    public void addEdge(String v1Label, String v2Label, int weight) {
       this.addEdge(new Edge(new Vertex(v1Label), new Vertex(v2Label), weight));
    }
        


    public Set<Vertex> getVertices() {
        return Collections.unmodifiableSet(vertices);
    }

    public Set<Edge> getEdges() {
        return Collections.unmodifiableSet(edges);
    }

    public Map<Vertex, Set<Edge>> getAdjList() {
        return Collections.unmodifiableMap(adjList);
    }
    
    
}
