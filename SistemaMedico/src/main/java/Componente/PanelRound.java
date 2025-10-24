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

    // 🔹 Propiedades personalizables
    private int round = 20; // Radio de las esquinas
    private Color borderColor = Color.BLACK;
    private int borderThickness = 0; // 0 = sin borde
    private float opacity = 1.0f; // Transparencia (1.0 = opaco, 0.0 = invisible)

    public PanelRound() {
        setOpaque(false);
    }

    // =================== MÉTODOS GET/SET ===================
    public int getRound() { return round; }
    public void setRound(int round) { this.round = round; repaint(); }

    public Color getBorderColor() { return borderColor; }
    public void setBorderColor(Color borderColor) { this.borderColor = borderColor; repaint(); }

    public int getBorderThickness() { return borderThickness; }
    public void setBorderThickness(int borderThickness) { this.borderThickness = borderThickness; repaint(); }

    public float getOpacityValue() { return opacity; }
    public void setOpacityValue(float opacity) {
        this.opacity = Math.max(0.0f, Math.min(opacity, 1.0f)); // Limita entre 0 y 1
        repaint();
    }

    // =================== DIBUJO PERSONALIZADO ===================
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);

        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int inset = borderThickness / 2; // Centra el borde

        // 🔹 Crear forma redondeada
        Area area = new Area(new RoundRectangle2D.Double(
                inset, inset,
                width - borderThickness,
                height - borderThickness,
                round * 2, round * 2
        ));

        // 🔹 Fondo con transparencia
        Color bg = getBackground();
        g2.setColor(new Color(bg.getRed(), bg.getGreen(), bg.getBlue(), Math.round(opacity * 255)));
        g2.fill(area);

        // 🔹 Borde
        if (borderThickness > 0) {
            g2.setStroke(new BasicStroke(borderThickness));
            g2.setColor(borderColor);
            g2.draw(area);
        }

        g2.dispose();
    }
}
