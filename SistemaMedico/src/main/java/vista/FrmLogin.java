package vista;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Toolkit;
import modelo.Usuario;
import controlador.Ctrl_usuario;

public final class FrmLogin extends javax.swing.JFrame {

    private final Ctrl_usuario Ctrl_usuario;

    public FrmLogin() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Iniciar sesión - Hospital de Emergencias - VES");
        this.setSize(new Dimension(1024, 616));
        setIconImage(getIconImage());

        txtdni.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtpassword.setBackground(new java.awt.Color(0, 0, 0, 1));

        Ctrl_usuario = new Ctrl_usuario();

        txtdni.addActionListener(e -> IniciarSesion());
        txtpassword.addActionListener(e -> IniciarSesion());
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagen/logoH.png"));
        return retValue;
    }

    private void IniciarSesion() {
        String dniTexto = txtdni.getText().trim();
        String passwordTexto = new String(txtpassword.getPassword()).trim();

        if (dniTexto.isEmpty() || passwordTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }
        
        Usuario usuario = new Ctrl_usuario().autenticarUsuarioPorDni(dniTexto, passwordTexto);
        
        if (usuario != null) {
            FrmMenu menu = new FrmMenu(usuario);
            menu.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "DNI o contraseña incorrectos");
            txtdni.setText("");
            txtpassword.setText("");
            txtdni.requestFocus();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSecundario = new Componente.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        pnlDni = new Componente.PanelRound();
        txtdni = new javax.swing.JTextField();
        pnlContra = new Componente.PanelRound();
        txtpassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        btnIniciarSesion = new Componente.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnlPrincipal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 576));
        setSize(new java.awt.Dimension(1024, 576));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSecundario.setBackground(new java.awt.Color(203, 216, 227));
        pnlSecundario.setOpacityValue(0.8F);
        pnlSecundario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/logoHE.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(200, 200));
        pnlSecundario.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 110, 100));

        pnlDni.setBackground(new java.awt.Color(242, 242, 242));
        pnlDni.setBorderThickness(1);
        pnlDni.setEnabled(false);
        pnlDni.setFocusable(false);
        pnlDni.setRound(15);
        pnlDni.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtdni.setBackground(new java.awt.Color(242, 242, 242));
        txtdni.setToolTipText("");
        txtdni.setBorder(null);
        txtdni.setSelectedTextColor(new java.awt.Color(242, 242, 242));
        pnlDni.add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, 400, 40));

        pnlSecundario.add(pnlDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 440, 50));

        pnlContra.setBackground(new java.awt.Color(242, 242, 242));
        pnlContra.setBorderThickness(1);
        pnlContra.setEnabled(false);
        pnlContra.setFocusable(false);
        pnlContra.setRound(15);
        pnlContra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtpassword.setBackground(new java.awt.Color(242, 242, 242));
        txtpassword.setBorder(null);
        pnlContra.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, 400, 40));

        pnlSecundario.add(pnlContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 440, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("INICIA SESIÓN CON TU DNI");
        pnlSecundario.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        btnIniciarSesion.setBackground(new java.awt.Color(47, 114, 181));
        btnIniciarSesion.setToolTipText("");
        btnIniciarSesion.setName(""); // NOI18N
        btnIniciarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciarSesionMouseClicked(evt);
            }
        });
        btnIniciarSesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("INICIAR SESIÓN");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIniciarSesion.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 260, 30));

        pnlSecundario.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 260, 60));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("CONTRASEÑA");
        pnlSecundario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 21)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Hospital de Emergencias");
        pnlSecundario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic Medium", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("VILLA EL SALVADOR");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlSecundario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 230, -1));

        getContentPane().add(pnlSecundario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 560, 430));

        pnlPrincipal.setBackground(new java.awt.Color(187, 187, 187));
        pnlPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/imglogin.jpeg"))); // NOI18N
        pnlPrincipal.setRequestFocusEnabled(false);
        getContentPane().add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarSesionMouseClicked
        this.IniciarSesion();
    }//GEN-LAST:event_btnIniciarSesionMouseClicked

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Componente.PanelRound btnIniciarSesion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private Componente.PanelRound pnlContra;
    private Componente.PanelRound pnlDni;
    private javax.swing.JLabel pnlPrincipal;
    private Componente.PanelRound pnlSecundario;
    private javax.swing.JTextField txtdni;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
