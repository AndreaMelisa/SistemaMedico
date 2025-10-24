package Componente;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

public class ButtonRound extends JButton {

    private int round = 20;
    private Color colorInicio = new Color(70, 130, 180);
    private Color colorFin = new Color(100, 149, 237);
    private Color colorHover = new Color(120, 180, 250);
    private Color colorClick = new Color(30, 144, 255);
    private Color borderColor = Color.BLACK;
    private int borderThickness = 0;
    private float opacity = 1.0f;

    public ButtonRound() {
        setContentAreaFilled(false);
        setFocusPainted(false);
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { repaint(); }
            @Override
            public void mouseExited(MouseEvent e) { repaint(); }
            @Override
            public void mousePressed(MouseEvent e) { repaint(); }
            @Override
            public void mouseReleased(MouseEvent e) { repaint(); }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        Color inicio = colorInicio;
        Color fin = colorFin;

        if (getModel().isPressed()) {
            inicio = colorClick;
            fin = colorClick;
        } else if (getModel().isRollover()) {
            inicio = colorHover;
            fin = colorHover;
        }

        GradientPaint gradiente = new GradientPaint(0, 0, inicio, 0, height, fin);
        g2.setPaint(gradiente);
        g2.fill(new RoundRectangle2D.Double(0, 0, width, height, round, round));

        if (borderThickness > 0) {
            g2.setStroke(new BasicStroke(borderThickness));
            g2.setColor(borderColor);
            g2.draw(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, round, round));
        }

        g2.dispose();
        super.paintComponent(g);
    }

    public int getRound() { return round; }
    public void setRound(int round) { this.round = round; repaint(); }

    public Color getColorInicio() { return colorInicio; }
    public void setColorInicio(Color colorInicio) { this.colorInicio = colorInicio; repaint(); }

    public Color getColorFin() { return colorFin; }
    public void setColorFin(Color colorFin) { this.colorFin = colorFin; repaint(); }

    public Color getColorHover() { return colorHover; }
    public void setColorHover(Color colorHover) { this.colorHover = colorHover; repaint(); }

    public Color getColorClick() { return colorClick; }
    public void setColorClick(Color colorClick) { this.colorClick = colorClick; repaint(); }

    public Color getBorderColor() { return borderColor; }
    public void setBorderColor(Color borderColor) { this.borderColor = borderColor; repaint(); }

    public int getBorderThickness() { return borderThickness; }
    public void setBorderThickness(int borderThickness) { this.borderThickness = borderThickness; repaint(); }

    public float getOpacity() { return opacity; }
    public void setOpacity(float opacity) {
        this.opacity = Math.max(0f, Math.min(opacity, 1f));
        repaint();
    }
}
