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
import java.awt.Color;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import modelos.Tema;

public class informacion extends javax.swing.JFrame {

    ControlTema mostrar = new ControlTema("MySQL");
    Tema tema = null;
    Inicio parent;
    public informacion() {
        this(null);
    }
    
    public informacion(Inicio parent){
        this(parent, null);
    } 
            
    public informacion(Inicio parent, Tema tema) {
        initComponents();
        this.tema = tema;
        this.parent = parent;
        this.setTitle("Informacion");
        this.getContentPane().setBackground(getBackground());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        logo.setHoverground(logo.getBackground());
        btnVolver.setHoverground(Theme.PDARK);
        
        jScrollPane2.getVerticalScrollBar().setUI(new ScrollBarV());
    }

    @Override
    public void setVisible(boolean b) {
        try{
            imprimir();
        }catch(Exception ex){
            cerrar();
            b = false;
        }
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void imprimir() throws Exception{
        try{
            mostrar.incrementarVisitas(tema.getId());
            
            ListaSecciones secciones = tema.getSecciones();

            String html = "";
            html += "<body style=\"font-family:sans-serif; padding: 8px; padding-top: 0px\">";
            html += "<h1>" + tema.getTitulo() + "</h1>";
            html += "<p>" + tema.getDescripcion().replaceAll("\\n", "<br>") + "</p>";

            for (int i = 0; i < secciones.getLength(); i++) {
                html += "<h2>" + secciones.obtener(i).getTitulo() + "</h2>";
                html += "<p>" + secciones.obtener(i).getDescripcion().replaceAll("\\n", "<br>") + "</p>";
                //Llena la tabla derecha de contenidos
                crearBotonContenido(secciones.obtener(i).getTitulo());
            }
            //Crea el boton de referencias
            crearBotonContenido("Referencias");
            
            //Agrega las referencias del tema al final
            html += "<h2>Referencias</h2>";

            html += "<i>" + tema.getReferencias() + "</i>";
            
            html += "</body>";
            Caracteristicas.setText(html);

            ListaRecursos imagenes = tema.getRecursos();

            ImageIcon imagen1 = new ImageIcon(imagenes.obtener(0).getRuta());
            Icon icon = new ImageIcon(imagen1.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
            jLabel1.setIcon(icon);
            Caracteristicas.setCaretPosition(0);
        }catch(Exception ex){
            if(!ex.getMessage().isEmpty()){
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            throw ex;
        }
    }
    
    /**
     * Llena la tabla derecha de contenidos con los titulos dados
     * @param titulo 
     */
    private void crearBotonContenido(String titulo){
        JButton boton1 = new TextButton();
        boton1.setMaximumSize(new Dimension(150, 800));
        boton1.setForeground(Color.GRAY);
        boton1.setHorizontalAlignment(SwingConstants.LEFT);
        boton1.setHorizontalTextPosition(SwingConstants.LEFT);
        String html = "";
        html += "<html>";
        html += "<div style=\"margin-bottom: 8px; text-align: left;\">"+titulo+"</div>";
        html += "</html>";
        boton1.setText(html);
        
        contenido.add(boton1);
    }
    
    public void cerrar(){
        if(parent != null) parent.setVisible(true);
        dispose();
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
        btnVolver = new components.buttons.PrimaryButton();
        logo = new components.buttons.PrimaryButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

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
        Caracteristicas.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jScrollPane2.setViewportView(Caracteristicas);

        jPanel1.setBackground(Theme.PRIMARY);

        btnVolver.setBackground(Theme.PRIMARY);
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/back_white.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        logo.setBackground(Theme.PRIMARY);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/book_white.png"))); // NOI18N
        logo.setText("Compuwiki");
        logo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        cerrar();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void logoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        cerrar();
    }//GEN-LAST:event_formWindowClosing

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
    private components.buttons.PrimaryButton btnVolver;
    private javax.swing.JPanel contenido;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private components.buttons.PrimaryButton logo;
    // End of variables declaration//GEN-END:variables
private vistas.BarraLoggedIn cuadro1;

}
