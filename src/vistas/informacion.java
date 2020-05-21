package vistas;

import components.buttons.TextButton;
import components.scrollbars.ScrollBarV;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import components.styles.Theme;
import controladores.ControlTema;
import controladores.listas.ListaRecursos;
import controladores.listas.ListaSecciones;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelos.Tema;

public class informacion extends javax.swing.JFrame {

    ControlTema mostrar = new ControlTema("MySQL");
    Tema tema = null;

    public informacion() {
        
        this(3);

    }

    public informacion(int id) {
        initComponents();

        this.setTitle("Informacion");
        this.getContentPane().setBackground(getBackground());
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        jScrollPane2.getVerticalScrollBar().setUI(new ScrollBarV());

        try {
            tema = mostrar.TemasAmostrar(id);
            imprimir();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se a encontrado el tema");

        }

    }

    public void imprimir() {

        ListaSecciones secciones = tema.getSecciones();

        String html = "";
        html += "<h1>" + tema.getTitulo() + "</h1>";
        html += "<p>" + tema.getDescripcion().replaceAll("\\n", "<br>") + "</p>";

        for (int i = 0; i < secciones.getLength(); i++) {
            html += "<h2>" + secciones.obtener(i).getTitulo() + "</h2>";
            html += "<p>" + secciones.obtener(i).getDescripcion().replaceAll("\\n", "<br>") + "</p>";
            JButton boton1 = new TextButton(secciones.obtener(i).getTitulo());
            contenido.add(boton1);

        }
        html += "<h2>Referencias</h2>";

        html += "<i>" + tema.getReferencias() + "</i>";
        Caracteristicas.setText(html);

        ListaRecursos imagenes = tema.getRecursos();

        ImageIcon imagen1 = new ImageIcon(imagenes.obtener(0).getRuta());
        Icon icon = new ImageIcon(imagen1.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
        jLabel1.setIcon(icon);
        Caracteristicas.setCaretPosition(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        contenido = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Caracteristicas = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        primaryButton1 = new components.buttons.PrimaryButton();
        primaryButton2 = new components.buttons.PrimaryButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        contenido.setOpaque(false);
        contenido.setLayout(new javax.swing.BoxLayout(contenido, javax.swing.BoxLayout.Y_AXIS));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Secciones");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(8, 8, 8)
                .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Caracteristicas.setEditable(false);
        Caracteristicas.setContentType("text/html");
        jScrollPane2.setViewportView(Caracteristicas);

        jPanel1.setBackground(Theme.PRIMARY);

        primaryButton1.setBackground(Theme.PRIMARY);
        primaryButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/login_white.png"))); // NOI18N
        primaryButton1.setText("Volver");
        primaryButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primaryButton1ActionPerformed(evt);
            }
        });

        primaryButton2.setBackground(Theme.PRIMARY);
        primaryButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/book_white.png"))); // NOI18N
        primaryButton2.setText("Compuwiki");
        primaryButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primaryButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(primaryButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(primaryButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(primaryButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(primaryButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void primaryButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primaryButton1ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_primaryButton1ActionPerformed

    private void primaryButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primaryButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_primaryButton2ActionPerformed

    /**
     * @param args the command line arguments
     *
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
            java.util.logging.Logger.getLogger(informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(informacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new informacion().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(informacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    //</editor-fold>
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane Caracteristicas;
    private javax.swing.JPanel contenido;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private components.buttons.PrimaryButton primaryButton1;
    private components.buttons.PrimaryButton primaryButton2;
    // End of variables declaration//GEN-END:variables
private vistas.BarraLoggedIn cuadro1;

}
