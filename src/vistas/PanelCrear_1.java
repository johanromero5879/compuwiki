
package vistas;
import components.styles.Theme;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelCrear_1 extends javax.swing.JPanel {
    String ruta="";
    public PanelCrear_1(){
        this.setBackground(Color.WHITE);
        initComponents();
        Descripcion.setPlaceholder("El texto....");
        Titulo.setPlaceholder("El Mejor Titulo...");
        Referencias.setPlaceholder("Referencias.....");
    }
    public boolean vacio(){
        if(Titulo.getText().length()==0||Referencias.getText().length()==0||Descripcion.getText().length()==0){
            return false;
        }else{
            return true;
        }
    }
    public boolean verficarImagen(){
        if(ruta.length()==0){
            return false;
        }else{
            return true;
        }
    }
    public void limpiar(int i){
        Titulo.setText("");
        Descripcion.setText("");
        Referencias.setText("");
        Imagen.setIcon(null);
    }

    public String getRuta() {
        return ruta;
    }

    public String getDescripcion() {
        return Descripcion.getText();
    }

    public String getReferencias() {
        return Referencias.getText();
    }

    public String getTitulo() {
        return Titulo.getText();
    }
    public boolean copiarImage(String fuente,String destino){
        boolean ver=false;
          try{
                Path fuente_con=Paths.get(fuente);
                Path destino_con=Paths.get(destino);
                Files.copy(fuente_con, destino_con, StandardCopyOption.COPY_ATTRIBUTES);
                ver=false;
          }catch(IOException e){
                JOptionPane.showMessageDialog(null,"error "+e.getMessage());
                ver=true;
          }
        return ver;  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new components.inputs.TextInput();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Descripcion = new components.inputs.TextAreaInput();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Adjuntar = new components.buttons.PrimaryButton();
        Imagen = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Referencias = new components.inputs.TextInput();

        Titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TituloActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setText("Digite el titulo del tema: ");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setText("Digite el texto del tema:");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("Tema Principal");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setText("Desea adjuntar algun archivo(Imagen)?");

        Adjuntar.setText("Adjuntar");
        Adjuntar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdjuntarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AdjuntarMouseExited(evt);
            }
        });
        Adjuntar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdjuntarActionPerformed(evt);
            }
        });

        Imagen.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Imagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(81, 0, 0)));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setText("Digite aqui las referencias:");

        Referencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReferenciasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Adjuntar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(Imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Referencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Adjuntar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9)
                        .addComponent(Descripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Referencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TituloActionPerformed

    private void AdjuntarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdjuntarActionPerformed
        //String destino_ruta="files/recursos/"+c+"/image_1.png";
        ruta="";
        JFileChooser jf=new JFileChooser();
        jf.setAcceptAllFileFilterUsed(false);
        jf.setFileFilter(new FileNameExtensionFilter("Imagenes", "jpg","png","gif"));
        int seleccion=jf.showOpenDialog(this);
        if(seleccion==JFileChooser.APPROVE_OPTION){
            File imagen= jf.getSelectedFile();
            ruta=imagen.getAbsolutePath();
            rsscalelabel.RSScaleLabel.setScaleLabel(Imagen, ruta);
        }else{}
    }//GEN-LAST:event_AdjuntarActionPerformed

    private void ReferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReferenciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReferenciasActionPerformed

    private void AdjuntarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdjuntarMouseEntered
        Adjuntar.setBackground(Theme.SDARK);
    }//GEN-LAST:event_AdjuntarMouseEntered

    private void AdjuntarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdjuntarMouseExited
        Adjuntar.setBackground(Theme.SECONDARY);
    }//GEN-LAST:event_AdjuntarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.buttons.PrimaryButton Adjuntar;
    private components.inputs.TextAreaInput Descripcion;
    private javax.swing.JLabel Imagen;
    private components.inputs.TextInput Referencias;
    private components.inputs.TextInput Titulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
