package Componente;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class PanelRound extends JPanel {

    private int round = 20; 
    private Color borderColor = Color.BLACK;
    private int borderThickness = 0; 
    private float opacity = 1.0f;

    public PanelRound() {
        setOpaque(false);
    }

    public int getRound() { return round; }
    public void setRound(int round) { this.round = round; repaint(); }

    public Color getBorderColor() { return borderColor; }
    public void setBorderColor(Color borderColor) { this.borderColor = borderColor; repaint(); }

    public int getBorderThickness() { return borderThickness; }
    public void setBorderThickness(int borderThickness) { this.borderThickness = borderThickness; repaint(); }

    public float getOpacityValue() { return opacity; }
    public void setOpacityValue(float opacity) {
        this.opacity = Math.max(0.0f, Math.min(opacity, 1.0f)); 
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);

        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int inset = borderThickness / 2;

        Area area = new Area(new RoundRectangle2D.Double(
                inset, inset,
                width - borderThickness,
                height - borderThickness,
                round * 2, round * 2
        ));

        Color bg = getBackground();
        g2.setColor(new Color(bg.getRed(), bg.getGreen(), bg.getBlue(), Math.round(opacity * 255)));
        g2.fill(area);

        if (borderThickness > 0) {
            g2.setStroke(new BasicStroke(borderThickness));
            g2.setColor(borderColor);
            g2.draw(area);
        }

        g2.dispose();
    }
}
