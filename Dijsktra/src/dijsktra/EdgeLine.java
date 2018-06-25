/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dijsktra;

import java.awt.Point;
import javax.swing.JLabel;


class EdgeLine {
    
    private final JLabel weight;
    private final Point start;
    private final Point end;
    
    public EdgeLine(JLabel weight, Point start, Point end){
        this.weight = weight;
        this.start = start;
        this.end = end;
    }

    public JLabel getWeight(){
        return weight;
    }
    
    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }
    

}
