package showroom.ui.components;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {

    public BackgroundPanel() {
        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        Graphics2D g2 = (Graphics2D) g;
        
        
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        int w = getWidth();
        int h = getHeight();
                
        Color colorEdge = new Color(5, 5, 10); 
        Color colorCenter = new Color(0, 60, 70);         
        float radius = Math.max(w, h) * 0.8f; 
                
        if (radius <= 0) radius = 1;

        Point center = new Point(w / 2, h / 2);
        float[] dist = {0.0f, 1.0f}; 
        Color[] colors = {colorCenter, colorEdge};

        try {
            RadialGradientPaint p = new RadialGradientPaint(center, radius, dist, colors);
            g2.setPaint(p);
            g2.fillRect(0, 0, w, h);
        } catch (Exception e) {            
            g2.setColor(Color.BLACK);
            g2.fillRect(0, 0, w, h);
        }
    }
}