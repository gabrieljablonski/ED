/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijsktra;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class DijkstraAlgorithm {

    private final Set<Vertex> vertices;
    private final Set<Edge> edges;
    private Map<Vertex, Set<Edge>> adjList;
    private Set<Vertex> settledNodes;
    private Set<Vertex> unsettledNodes;
    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Integer> distances;

    public DijkstraAlgorithm(Graph graph) {
        // create a copy of the array so that we can operate on this array
        this.vertices = new HashSet<>(graph.getVertices());
        this.edges = new HashSet<>(graph.getEdges());
        this.adjList = new HashMap<>(graph.getAdjList());
    }
    
    private Set<Vertex> getNeighbors(Vertex node) {
        Set<Vertex> neighbors = new HashSet<>();
        for (Edge edge : edges) {
            if (edge.getV1().getLabel().equals(node.getLabel()) && !isSettled(edge.getV2())) {
                neighbors.add(edge.getV2());
            }
            else if(edge.getV2().getLabel().equals(node.getLabel()) && !isSettled(edge.getV1())){
                neighbors.add(edge.getV1());
            }
        }
        return neighbors;
    }
    
    public LinkedList<String> shortestPath(Vertex origin, Vertex destination){

        this.settledNodes = new HashSet<>();
        this.unsettledNodes = new HashSet<>();
        this.distances = new HashMap<>();
        this.predecessors = new HashMap<>();
        
        distances.put(origin, 0);
        
        unsettledNodes.add(origin);
        
        while(unsettledNodes.size() > 0){
            Vertex node = this.minDist(unsettledNodes);
            settledNodes.add(node);
            unsettledNodes.remove(node);
            Set<Vertex> neighbors = this.getNeighbors(node);
            for(Vertex target: neighbors){
                if(this.shortestDistance(target) >
                   this.shortestDistance(node) + this.getDistance(node, target)){
                    int dist = this.shortestDistance(node) + this.getDistance(node, target);
                    boolean replaced = false;
                    for(Vertex key: distances.keySet()){
                        if(target.getLabel().equals(key.getLabel())){
                            distances.replace(key, dist);
                            replaced = true;
                        }
                    }
                    if(!replaced) distances.put(target, dist);
                    replaced = false;
                    for(Vertex key: predecessors.keySet()){
                        if(target.getLabel().equals(key.getLabel())){
                            predecessors.replace(key, node);
                            replaced = true;
                            break;
                        }
                    }
                    if(!replaced) predecessors.put(target, node);
                    
                    unsettledNodes.add(target);
                }
            }
        }
        LinkedList<String> path = new LinkedList<>();
        Vertex step = null;
        for(Vertex vertex: predecessors.keySet()){
            if(vertex.getLabel().equals(destination.getLabel())){
                step = vertex;
                break;
            }
        }
        
        if(step == null || predecessors.get(step) == null)
            return null;
        
        path.add(step.getLabel());
        // FAILING 1U -> 1E; 1E -> 3M
        while(predecessors.get(step) != null){
            step = predecessors.get(step);
            path.add(step.getLabel());
        }
        Collections.reverse(path);
        return path;
    }
    
    private Vertex minDist(Set<Vertex> vertices){
        Vertex minimum = null;
        for(Vertex vertex: vertices){
            if(minimum == null) minimum = vertex;
            else if(this.shortestDistance(vertex) < this.shortestDistance(minimum)){
                minimum = vertex;
            }
        }
        return minimum;
    }
    
    
    private int shortestDistance(Vertex vertex){
        for(Vertex v: this.distances.keySet()){
            if(v.getLabel().equals(vertex.getLabel())) vertex = v;
        }
        Integer d = this.distances.get(vertex);
        if(d == null) return 9999;
        else return d;
    }
    
     private boolean isSettled(Vertex vertex) {
        return this.settledNodes.contains(vertex);
    }

    private int getDistance(Vertex node, Vertex target) {
        for(Edge edge: edges){
            if((edge.getV1().getLabel().equals(node.getLabel()) && edge.getV2().getLabel().equals(target.getLabel()))||
               (edge.getV1().getLabel().equals(target.getLabel()) && edge.getV2().getLabel().equals(node.getLabel())))
                return edge.getWeight();
        }
        throw new RuntimeException("Error");
    }

}
