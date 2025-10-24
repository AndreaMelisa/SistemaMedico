package vista;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Toolkit;
import modelo.Usuario;
import controlador.Ctrl_usuario;

/**
 *
 * @author zylit
 */
public final class FrmLogin extends javax.swing.JFrame {

    private final Ctrl_usuario Ctrl_usuario;

    public FrmLogin() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Iniciar sesión - Hospital de Emergencias - VES");
        this.setSize(new Dimension(1024, 616));
        setIconImage(getIconImage());

        txtusuario.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtpassword.setBackground(new java.awt.Color(0, 0, 0, 1));

        Ctrl_usuario = new Ctrl_usuario();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagen/logoH.png"));
        return retValue;
    }

    private void IniciarSesion() {
        String usuarioTexto = txtusuario.getText().trim();
        String passwordTexto = new String(txtpassword.getPassword()).trim();

        if (usuarioTexto.isEmpty() || passwordTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        Usuario usuario = Ctrl_usuario.autenticarUsuario(usuarioTexto, passwordTexto);

        if (usuario != null) {
            JOptionPane.showMessageDialog(this, "Bienvenido " + usuario.getNombreUsuario());
            new FrmMenu().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
            txtusuario.setText("");
            txtpassword.setText("");
            txtusuario.requestFocus();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound4 = new Componente.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        panelRound2 = new Componente.PanelRound();
        txtusuario = new javax.swing.JTextField();
        panelRound3 = new Componente.PanelRound();
        txtpassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        panelRound1 = new Componente.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 576));
        setSize(new java.awt.Dimension(1024, 576));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound4.setBackground(new java.awt.Color(203, 216, 227));
        panelRound4.setOpacityValue(0.8F);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/logoHE.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(200, 200));
        panelRound4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 110, 100));

        panelRound2.setBackground(new java.awt.Color(242, 242, 242));
        panelRound2.setBorderThickness(1);
        panelRound2.setEnabled(false);
        panelRound2.setFocusable(false);
        panelRound2.setRound(15);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtusuario.setBackground(new java.awt.Color(242, 242, 242));
        txtusuario.setToolTipText("");
        txtusuario.setBorder(null);
        txtusuario.setSelectedTextColor(new java.awt.Color(242, 242, 242));
        panelRound2.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, 400, 40));

        panelRound4.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 440, 50));

        panelRound3.setBackground(new java.awt.Color(242, 242, 242));
        panelRound3.setBorderThickness(1);
        panelRound3.setEnabled(false);
        panelRound3.setFocusable(false);
        panelRound3.setRound(15);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtpassword.setBackground(new java.awt.Color(242, 242, 242));
        txtpassword.setBorder(null);
        panelRound3.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, 400, 40));

        panelRound4.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 440, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("INICIA SESIÓN CON TU NOMBRE DE USUARIO");
        panelRound4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        panelRound1.setBackground(new java.awt.Color(47, 114, 181));
        panelRound1.setToolTipText("");
        panelRound1.setName(""); // NOI18N
        panelRound1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRound1MouseClicked(evt);
            }
        });
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("INICIAR SESIÓN");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 260, 30));

        panelRound4.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 260, 60));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("CONTRASEÑA");
        panelRound4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 21)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Hospital de Emergencias");
        panelRound4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic Medium", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("VILLA EL SALVADOR");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 230, -1));

        getContentPane().add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 560, 430));

        jLabel1.setBackground(new java.awt.Color(187, 187, 187));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/imglogin.jpeg"))); // NOI18N
        jLabel1.setRequestFocusEnabled(false);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelRound1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound1MouseClicked
        this.IniciarSesion();
    }//GEN-LAST:event_panelRound1MouseClicked

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private Componente.PanelRound panelRound1;
    private Componente.PanelRound panelRound2;
    private Componente.PanelRound panelRound3;
    private Componente.PanelRound panelRound4;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
