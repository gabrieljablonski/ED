/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijsktra;

import java.util.LinkedList;


class DistPath {
    private final int distance;
    private final LinkedList<String> path;
    
    public DistPath(int distance, LinkedList<String> path){
        this.distance = distance;
        this.path = path;
    }
    
    public int getDistance(){
        return this.distance;
    }
    
    public LinkedList<String> getPath(){
        return this.path;
    }
}
