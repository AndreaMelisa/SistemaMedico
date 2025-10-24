package Componente;

import com.toedter.calendar.JCalendar;
import java.awt.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PanelCalendario extends JPanel {

    private JPanel contenedor;
    private JLabel titulo;
    private JCalendar calendario;

    public PanelCalendario() {
        setLayout(new GridBagLayout());
        setBackground(new Color(240, 242, 245));

        contenedor = new JPanel();
        contenedor.setPreferredSize(new Dimension(700, 700));
        contenedor.setLayout(new BorderLayout(0, 20));
        contenedor.setBackground(Color.WHITE);
        contenedor.setBorder(new EmptyBorder(40, 40, 40, 40));

        titulo = new JLabel("Calendario de Citas", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 26));
        titulo.setForeground(new Color(45, 45, 45));

        calendario = new JCalendar();
        calendario.setWeekOfYearVisible(false);
        calendario.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        calendario.setDecorationBackgroundColor(new Color(255, 179, 102));
        calendario.setTodayButtonVisible(true);
        calendario.setTodayButtonText("Hoy");
        calendario.setNullDateButtonVisible(true);
        calendario.setSundayForeground(new Color(255, 102, 102));
        calendario.setWeekdayForeground(new Color(60, 63, 65));
        calendario.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 2, true));

        contenedor.add(titulo, BorderLayout.NORTH);
        contenedor.add(calendario, BorderLayout.CENTER);

        add(contenedor, new GridBagConstraints());
    }

    public JCalendar getCalendario() {
        return calendario;
    }


    public Date getSelectedDate() {
        return calendario.getDate();
    }

}
