/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijsktra;

import java.awt.Point;


class Weight {
    
    private final int weight;
    private final Point position;
    
    public Weight(int weight, Point position){
        this.weight = weight;
        this.position = position;
    }

    public int getWeight() {
        return weight;
    }

    public Point getPosition() {
        return position;
    }
        

}
