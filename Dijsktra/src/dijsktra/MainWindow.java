/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijsktra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import javax.swing.JPanel;

/**
 *
 * @author gabri
 */
public class MainWindow extends javax.swing.JFrame {

    private Map<String, JPanel> panels;
    
    private Map<String, EdgeLine> line_edges;
    private Graph graph;
    private String origin;
    private String destination;
    private int selection_stage; // 0 -> None; 1 -> Select origin; 2 -> Select destination
    
    private Set<EdgeLine> lines_to_paint;

     
    public MainWindow() {
        this.line_edges = new HashMap();
        this.graph = new Graph();
        this.selection_stage = 0;
        this.panels = new HashMap();
        this.origin = "";
        this.destination = "";
        this.lines_to_paint = new HashSet<>();
      
        initComponents();
        
        this.setupGraph();
        this.setupGUI();
                
    }
    
    private void setupGUI(){
        
        this.getContentPane().setBackground(Color.white);
        this.buttonDijkstra.setEnabled(false);
        
        this.setLayout(null);
        
        this.panels.put("1B", this.panel1B);
        this.panels.put("1C", this.panel1C);
        this.panels.put("1E", this.panel1E);
        this.panels.put("1N", this.panel1N);
        this.panels.put("1U", this.panel1U);
        this.panels.put("3M", this.panel3M);
        this.panels.put("3Q", this.panel3Q);
        this.panels.put("5R", this.panel5R);
        
        for(JPanel panel: this.panels.values()){
            panel.setBackground(Color.gray);
        }
        
        this.line_edges.put("1E1N", new EdgeLine(this.weight_0, new Point(195, 198), new Point(345, 136)));
        this.line_edges.put("1E3Q", new EdgeLine(this.weight_10, new Point(113, 282), new Point( 87, 442)));
        this.line_edges.put("1E3M", new EdgeLine(this.weight_5, new Point(165, 280), new Point(257, 340)));
        this.line_edges.put("3Q3M", new EdgeLine(this.weight_11, new Point(139, 458), new Point(263, 366)));
        this.line_edges.put("3Q1B", new EdgeLine(this.weight_9, new Point(140, 530), new Point(585, 530)));
        this.line_edges.put("3M1N", new EdgeLine(this.weight_2, new Point(330, 268), new Point(368, 158)));
        this.line_edges.put("3M1C", new EdgeLine(this.weight_8, new Point(358, 352), new Point(446, 404)));
        this.line_edges.put("1N5R", new EdgeLine(this.weight_3, new Point(444, 154), new Point(488, 184)));
        this.line_edges.put("1N1U", new EdgeLine(this.weight_1, new Point(444,  70), new Point(694,  78)));
        this.line_edges.put("1C5R", new EdgeLine(this.weight_6, new Point(488, 332), new Point(516, 252)));
        this.line_edges.put("5R1U", new EdgeLine(this.weight_4, new Point(586, 182), new Point(694, 142)));
        this.line_edges.put("5R1B", new EdgeLine(this.weight_7, new Point(576, 252), new Point(600, 435)));


    }
    
    private void setupGraph(){
        this.graph.addVertex("1E");
        this.graph.addVertex("3Q");
        this.graph.addVertex("3M");
        this.graph.addVertex("1N");
        this.graph.addVertex("1B");
        this.graph.addVertex("1C");
        this.graph.addVertex("5R");
        this.graph.addVertex("1U");
        
        this.graph.addEdge("1E", "1N", 50);
        this.graph.addEdge("1N", "1U", 35);
        this.graph.addEdge("3M", "1N", 35);
        this.graph.addEdge("1N", "5R", 15);
        this.graph.addEdge("5R", "1U", 15);
        this.graph.addEdge("1C", "5R", 15);
        this.graph.addEdge("1B", "5R", 80);
        this.graph.addEdge("3M", "1C", 15);
        this.graph.addEdge("3Q", "1B", 39);
        this.graph.addEdge("1E", "3Q", 98);
        this.graph.addEdge("3Q", "3M", 17);
        this.graph.addEdge("1E", "3M", 25);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        this.recolorWeights();

        
        for (EdgeLine line : this.line_edges.values()) {
            Point start = line.getStart();
            Point end = line.getEnd();
            g.setColor(Color.black);
            g.drawLine(start.x, start.y, end.x, end.y);
        }
        
        if(this.lines_to_paint.size() > 0){
            for(EdgeLine line: this.lines_to_paint){
                Point start = line.getStart();
                Point end = line.getEnd();
                g.setColor(Color.red);
                g.drawLine(start.x, start.y, end.x, end.y);
                line.getWeight().setForeground(Color.red);
            }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1E = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        panel3M = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        panel1N = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        panel3Q = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        panel1B = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        panel1C = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        panel5R = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        panel1U = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        weight_0 = new javax.swing.JLabel();
        weight_5 = new javax.swing.JLabel();
        weight_1 = new javax.swing.JLabel();
        weight_7 = new javax.swing.JLabel();
        weight_3 = new javax.swing.JLabel();
        weight_2 = new javax.swing.JLabel();
        weight_6 = new javax.swing.JLabel();
        weight_4 = new javax.swing.JLabel();
        weight_9 = new javax.swing.JLabel();
        weight_8 = new javax.swing.JLabel();
        weight_10 = new javax.swing.JLabel();
        weight_11 = new javax.swing.JLabel();
        buttonDijkstra = new javax.swing.JButton();
        buttonOrigin = new javax.swing.JButton();
        buttonDestination = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dijkstra");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(300, 150));
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMaximumSize(new java.awt.Dimension(1000, 560));
        setMinimumSize(new java.awt.Dimension(1000, 560));
        setPreferredSize(new java.awt.Dimension(1000, 560));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1E.setPreferredSize(new java.awt.Dimension(100, 100));
        panel1E.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel1EMousePressed(evt);
            }
        });

        jLabel9.setText("1E");

        javax.swing.GroupLayout panel1ELayout = new javax.swing.GroupLayout(panel1E);
        panel1E.setLayout(panel1ELayout);
        panel1ELayout.setHorizontalGroup(
            panel1ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1ELayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel9)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        panel1ELayout.setVerticalGroup(
            panel1ELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1ELayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel9)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        getContentPane().add(panel1E, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 156, -1, -1));

        panel3M.setPreferredSize(new java.awt.Dimension(100, 100));
        panel3M.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel3MMousePressed(evt);
            }
        });

        jLabel18.setText("3M");

        javax.swing.GroupLayout panel3MLayout = new javax.swing.GroupLayout(panel3M);
        panel3M.setLayout(panel3MLayout);
        panel3MLayout.setHorizontalGroup(
            panel3MLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3MLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel18)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        panel3MLayout.setVerticalGroup(
            panel3MLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3MLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel18)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        getContentPane().add(panel3M, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 240, -1, -1));

        panel1N.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel1NMousePressed(evt);
            }
        });

        jLabel19.setText("1N");

        javax.swing.GroupLayout panel1NLayout = new javax.swing.GroupLayout(panel1N);
        panel1N.setLayout(panel1NLayout);
        panel1NLayout.setHorizontalGroup(
            panel1NLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1NLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel19)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panel1NLayout.setVerticalGroup(
            panel1NLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1NLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel19)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        getContentPane().add(panel1N, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 32, -1, -1));

        panel3Q.setPreferredSize(new java.awt.Dimension(100, 100));
        panel3Q.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel3QMousePressed(evt);
            }
        });

        jLabel20.setText("3Q");

        javax.swing.GroupLayout panel3QLayout = new javax.swing.GroupLayout(panel3Q);
        panel3Q.setLayout(panel3QLayout);
        panel3QLayout.setHorizontalGroup(
            panel3QLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3QLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel20)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        panel3QLayout.setVerticalGroup(
            panel3QLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3QLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel20)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        getContentPane().add(panel3Q, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 416, -1, -1));

        panel1B.setPreferredSize(new java.awt.Dimension(100, 100));
        panel1B.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel1BMousePressed(evt);
            }
        });

        jLabel21.setText("1B");

        javax.swing.GroupLayout panel1BLayout = new javax.swing.GroupLayout(panel1B);
        panel1B.setLayout(panel1BLayout);
        panel1BLayout.setHorizontalGroup(
            panel1BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1BLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel21)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panel1BLayout.setVerticalGroup(
            panel1BLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1BLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel21)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        getContentPane().add(panel1B, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, -1, -1));

        panel1C.setPreferredSize(new java.awt.Dimension(100, 100));
        panel1C.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel1CMousePressed(evt);
            }
        });

        jLabel22.setText("1C");

        javax.swing.GroupLayout panel1CLayout = new javax.swing.GroupLayout(panel1C);
        panel1C.setLayout(panel1CLayout);
        panel1CLayout.setHorizontalGroup(
            panel1CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1CLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel22)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panel1CLayout.setVerticalGroup(
            panel1CLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1CLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(40, 40, 40))
        );

        getContentPane().add(panel1C, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 306, -1, -1));

        panel5R.setPreferredSize(new java.awt.Dimension(100, 100));
        panel5R.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel5RMousePressed(evt);
            }
        });

        jLabel23.setText("5R");

        javax.swing.GroupLayout panel5RLayout = new javax.swing.GroupLayout(panel5R);
        panel5R.setLayout(panel5RLayout);
        panel5RLayout.setHorizontalGroup(
            panel5RLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5RLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel23)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panel5RLayout.setVerticalGroup(
            panel5RLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5RLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel23)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        getContentPane().add(panel5R, new org.netbeans.lib.awtextra.AbsoluteConstraints(483, 126, -1, -1));

        panel1U.setPreferredSize(new java.awt.Dimension(100, 100));
        panel1U.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel1UMousePressed(evt);
            }
        });

        jLabel24.setText("1U");

        javax.swing.GroupLayout panel1ULayout = new javax.swing.GroupLayout(panel1U);
        panel1U.setLayout(panel1ULayout);
        panel1ULayout.setHorizontalGroup(
            panel1ULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1ULayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel24)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panel1ULayout.setVerticalGroup(
            panel1ULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1ULayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel24)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        getContentPane().add(panel1U, new org.netbeans.lib.awtextra.AbsoluteConstraints(689, 32, -1, -1));

        weight_0.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weight_0.setText("50");
        getContentPane().add(weight_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        weight_5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weight_5.setText("25");
        getContentPane().add(weight_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        weight_1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weight_1.setText("35");
        getContentPane().add(weight_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        weight_7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weight_7.setText("80");
        getContentPane().add(weight_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, -1, -1));

        weight_3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weight_3.setText("15");
        getContentPane().add(weight_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, -1, -1));

        weight_2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weight_2.setText("35");
        getContentPane().add(weight_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, -1, -1));

        weight_6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weight_6.setText("15");
        getContentPane().add(weight_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, -1, -1));

        weight_4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weight_4.setText("15");
        getContentPane().add(weight_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, -1, -1));

        weight_9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weight_9.setText("39");
        getContentPane().add(weight_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, -1, -1));

        weight_8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weight_8.setText("15");
        getContentPane().add(weight_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, -1, -1));

        weight_10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weight_10.setText("98");
        getContentPane().add(weight_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        weight_11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weight_11.setText("17");
        getContentPane().add(weight_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, -1, -1));

        buttonDijkstra.setText("Achar menor caminho");
        buttonDijkstra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonDijkstraMousePressed(evt);
            }
        });
        getContentPane().add(buttonDijkstra, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 480, 170, 40));

        buttonOrigin.setText("Selecionar origem");
        buttonOrigin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonOriginMousePressed(evt);
            }
        });
        getContentPane().add(buttonOrigin, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 350, 170, 40));

        buttonDestination.setText("Selecionar destino");
        buttonDestination.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonDestinationMousePressed(evt);
            }
        });
        getContentPane().add(buttonDestination, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 400, 170, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panel1NMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1NMousePressed
        JPanel panel = this.panel1N;
        String panel_label = "1N";
        if(this.selection_stage == 1) this.selectOrigin(panel, panel_label);
        else if(this.selection_stage == 2) this.selectDestination(panel, panel_label);
    }//GEN-LAST:event_panel1NMousePressed

    private void panel1UMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1UMousePressed
        JPanel panel = this.panel1U;
        String panel_label = "1U";
        if(this.selection_stage == 1) this.selectOrigin(panel, panel_label);
        else if(this.selection_stage == 2) this.selectDestination(panel, panel_label);
    }//GEN-LAST:event_panel1UMousePressed

    private void panel1EMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1EMousePressed
        JPanel panel = this.panel1E;
        String panel_label = "1E";
        if(this.selection_stage == 1) this.selectOrigin(panel, panel_label);
        else if(this.selection_stage == 2) this.selectDestination(panel, panel_label);
    }//GEN-LAST:event_panel1EMousePressed

    private void panel5RMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel5RMousePressed
        JPanel panel = this.panel5R;
        String panel_label = "5R";
        if(this.selection_stage == 1) this.selectOrigin(panel, panel_label);
        else if(this.selection_stage == 2) this.selectDestination(panel, panel_label);
    }//GEN-LAST:event_panel5RMousePressed

    private void panel3MMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel3MMousePressed
        JPanel panel = this.panel3M;
        String panel_label = "3M";
        if(this.selection_stage == 1) this.selectOrigin(panel, panel_label);
        else if(this.selection_stage == 2) this.selectDestination(panel, panel_label);
    }//GEN-LAST:event_panel3MMousePressed

    private void panel1CMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1CMousePressed
        JPanel panel = this.panel1C;
        String panel_label = "1C";
        if(this.selection_stage == 1) this.selectOrigin(panel, panel_label);
        else if(this.selection_stage == 2) this.selectDestination(panel, panel_label);
    }//GEN-LAST:event_panel1CMousePressed

    private void panel3QMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel3QMousePressed
        JPanel panel = this.panel3Q;
        String panel_label = "3Q";
        if(this.selection_stage == 1) this.selectOrigin(panel, panel_label);
        else if(this.selection_stage == 2) this.selectDestination(panel, panel_label);
    }//GEN-LAST:event_panel3QMousePressed

    private void panel1BMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1BMousePressed
        JPanel panel = this.panel1B;
        String panel_label = "1B";
        if(this.selection_stage == 1) this.selectOrigin(panel, panel_label);
        else if(this.selection_stage == 2) this.selectDestination(panel, panel_label);
    }//GEN-LAST:event_panel1BMousePressed

    private void buttonOriginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonOriginMousePressed
        this.selection_stage = 1;
    }//GEN-LAST:event_buttonOriginMousePressed

    private void buttonDestinationMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDestinationMousePressed
        this.selection_stage = 2;
    }//GEN-LAST:event_buttonDestinationMousePressed

    private void buttonDijkstraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDijkstraMousePressed
        this.shortestPath();
    }//GEN-LAST:event_buttonDijkstraMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDestination;
    private javax.swing.JButton buttonDijkstra;
    private javax.swing.JButton buttonOrigin;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel panel1B;
    private javax.swing.JPanel panel1C;
    private javax.swing.JPanel panel1E;
    private javax.swing.JPanel panel1N;
    private javax.swing.JPanel panel1U;
    private javax.swing.JPanel panel3M;
    private javax.swing.JPanel panel3Q;
    private javax.swing.JPanel panel5R;
    private javax.swing.JLabel weight_0;
    private javax.swing.JLabel weight_1;
    private javax.swing.JLabel weight_10;
    private javax.swing.JLabel weight_11;
    private javax.swing.JLabel weight_2;
    private javax.swing.JLabel weight_3;
    private javax.swing.JLabel weight_4;
    private javax.swing.JLabel weight_5;
    private javax.swing.JLabel weight_6;
    private javax.swing.JLabel weight_7;
    private javax.swing.JLabel weight_8;
    private javax.swing.JLabel weight_9;
    // End of variables declaration//GEN-END:variables

    
    private void selectOrigin(JPanel panel, String label) {
        this.lines_to_paint.clear();
        this.repaint();

        if(this.destination.equals(label)){
            this.destination = "";
            this.buttonDestination.setText("Selecionar destino");
        }
        this.origin = label;
        panel.setBackground(Color.green);
        this.buttonOrigin.setText("Selecionar origem (" + label + ")");

        
        for(String panel_label: this.panels.keySet()){
            if(!panel_label.equals(this.origin) &&
               !panel_label.equals(this.destination)){
                this.panels.get(panel_label).setBackground(Color.gray);
            }
        }
        
        if(!this.origin.equals("") && !this.destination.equals("")){
            this.buttonDijkstra.setEnabled(true);
        }
        else{
            this.buttonDijkstra.setEnabled(false);
        }
    }

    private void selectDestination(JPanel panel, String label) {
        this.lines_to_paint.clear();
        this.repaint();
        
        if(this.origin.equals(label)) {
            this.origin = "";
            this.buttonOrigin.setText("Selecionar origem");
        }
        this.destination = label;
        panel.setBackground(Color.yellow);
        this.buttonDestination.setText("Selecionar destino (" + label + ")");

        for(String panel_label: this.panels.keySet()){
            if(!panel_label.equals(this.origin) &&
               !panel_label.equals(this.destination)){
                this.panels.get(panel_label).setBackground(Color.gray);
            }
        }
        
        if(!this.origin.equals("") && !this.destination.equals("")){
            this.buttonDijkstra.setEnabled(true);
        }
        else{
            this.buttonDijkstra.setEnabled(false);
        }
    }

    private void shortestPath() {
        Vertex v_origin = null;
        Vertex v_destination = null;
        
        for(Vertex vertex: this.graph.getVertices()){
            if(vertex.getLabel().equals(this.origin)) v_origin = vertex;
            if(vertex.getLabel().equals(this.destination)) v_destination = vertex;
        }
        
        LinkedList<String> path = new DijkstraAlgorithm(this.graph).shortestPath(v_origin, v_destination);
        
        this.paintPanels(path);
        
        Set<String> lines = new HashSet<>();
        
        for(int i=0; i<path.size()-1; i++){
            lines.add(path.get(i) + path.get(i+1));
            lines.add(path.get(i+1) + path.get(i));
        }
        this.paintLines(lines);
                
    }

    private void paintPanels(LinkedList<String> panel_labels) {
        for(String panel_label: panel_labels){
            if(!panel_label.equals(this.origin) && !panel_label.equals(this.destination))
                this.panels.get(panel_label).setBackground(Color.red);
        }
    }

    private void paintLines(Set<String> lines) {
        this.lines_to_paint = new HashSet<>();
        for(String label: lines){
            EdgeLine line = this.line_edges.get(label);
            if(line != null){
                this.lines_to_paint.add(line);
            }
        }
        this.repaint();
    }

    private void recolorWeights() {
        this.weight_0.setForeground(Color.black);
        this.weight_1.setForeground(Color.black);
        this.weight_2.setForeground(Color.black);
        this.weight_3.setForeground(Color.black);
        this.weight_4.setForeground(Color.black);
        this.weight_5.setForeground(Color.black);
        this.weight_6.setForeground(Color.black);
        this.weight_7.setForeground(Color.black);
        this.weight_8.setForeground(Color.black);
        this.weight_9.setForeground(Color.black);
        this.weight_10.setForeground(Color.black);
        this.weight_11.setForeground(Color.black);
    }
}
