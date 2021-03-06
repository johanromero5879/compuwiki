
package vistas;

import components.styles.Theme;
import controladores.ControlRecursos;
import controladores.ControlSecciones;
import controladores.ControlTema;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Crear extends javax.swing.JFrame{
    PanelCrear_1 p1=new PanelCrear_1();
    PanelCrear_2 p2=new PanelCrear_2();
    PanelCrear_2 aux;
    ArrayList<PanelCrear_2> lista=new ArrayList();
    int auxTema=0;
    ControlTema tema;
    ControlRecursos rec;
    ControlSecciones sec;
    
    Inicio parent;
    
    public Crear(){
        this(null);
    }
    
    public Crear(Inicio parent){
        this.parent = parent;
        this.getContentPane().setBackground(Color.WHITE);
        initComponents();
        Contenedor.add(p1);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Terminar.setEnabled(false);
        tema=new ControlTema("MySQL");
        rec=new ControlRecursos("MySQL");
        sec=new ControlSecciones("MySQL");
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Volver = new components.buttons.PrimaryButton();
        Terminar = new components.buttons.PrimaryButton();
        Continuar = new components.buttons.PrimaryButton();
        Contenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(Theme.PRIMARY);

        Volver.setBackground(Theme.PRIMARY);
        Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/back_white.png"))); // NOI18N
        Volver.setText("Volver");
        Volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VolverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VolverMouseExited(evt);
            }
        });
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Terminar.setBackground(Theme.PRIMARY);
        Terminar.setText("Terminar");
        Terminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TerminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TerminarMouseExited(evt);
            }
        });
        Terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerminarActionPerformed(evt);
            }
        });

        Continuar.setBackground(Theme.PRIMARY);
        Continuar.setText("Continuar");
        Continuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ContinuarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ContinuarMouseExited(evt);
            }
        });
        Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarActionPerformed(evt);
            }
        });

        Contenedor.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(Terminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(Continuar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
            .addComponent(Contenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Terminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Continuar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(339, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolverMouseEntered
        Volver.setBackground(Theme.PDARK);
    }//GEN-LAST:event_VolverMouseEntered

    private void VolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolverMouseExited
        Volver.setBackground(Theme.PRIMARY);
    }//GEN-LAST:event_VolverMouseExited

    private void TerminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TerminarMouseEntered
       Terminar.setBackground(new Color(255,0,51));
    }//GEN-LAST:event_TerminarMouseEntered

    private void TerminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TerminarMouseExited
        Terminar.setBackground(Theme.PRIMARY);
    }//GEN-LAST:event_TerminarMouseExited

    private void ContinuarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContinuarMouseEntered
        Continuar.setBackground(Theme.PDARK);
    }//GEN-LAST:event_ContinuarMouseEntered

    private void ContinuarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ContinuarMouseExited
        Continuar.setBackground(Theme.PRIMARY);
    }//GEN-LAST:event_ContinuarMouseExited

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.setVisible(false);
        JOptionPane.showMessageDialog(null,"La informacion sin previo guardado se perdera",null,JOptionPane.WARNING_MESSAGE);
        p1.limpiar(0);
        dispose();
    }//GEN-LAST:event_VolverActionPerformed
    
    /**
     * Actualizar  los temas mas consultados de la interfaz principal
     * @author Johan Romero
     */
    private void actualizarTemasMasConsultados(){
        try{
            if(parent != null) parent.mostrarConsultados();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed
        boolean ap=p1.vacio();
        boolean op=p1.verficarImagen();
        if(ap==true && op==true){
            Volver.setEnabled(false);
            Continuar.setEnabled(false);
            Terminar.setEnabled(true);
            p1.setVisible(false);
            p2.setVisible(true);
            Contenedor.add(p2);
            Contenedor.validate();
            try {
                tema.IngresarTemas(p1.getTitulo(),p1.getDescripcion(),p1.getReferencias(),0);
                auxTema=tema.getAux();
                //System.out.println(auxTema);
                File directorio=new File("files/recursos/"+auxTema);
                if(!directorio.exists()){
                    if(directorio.mkdirs()){
                        //System.out.println("se ha creado un nuevo directorio");
                    }else{
                        //System.out.println("No se ha podido crear un nuevo directorio");
                    }
                }
                String destino="files/recursos/"+auxTema+"/image_1.png";
                boolean ver=p1.copiarImage(p1.getRuta(),destino);
                if(ver==false){
                   rec.AgregarRecurso(auxTema, destino,"image"); 
                }else{
                   JOptionPane.showMessageDialog(null,"error no ha sido posible la adicion de la imagen");
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"error"+ex.getMessage());
            }
        }else if(ap==true && op==false){
            JOptionPane.showMessageDialog(null,"Por favor elija una imagen, antes de continuar");
        }else{
            JOptionPane.showMessageDialog(null,"Por favor rellene todos los campos, antes de continuar");
        }
    }//GEN-LAST:event_ContinuarActionPerformed

    private void TerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerminarActionPerformed
        boolean ted=false;
        p1.limpiar(0);
        if(p2.vacio()!=false){
            int confirmacion=JOptionPane.showConfirmDialog(null,"Deseas terminar de agregar secciones? \n"
                                                           + "No, sigue digitanto y se almacena la informacion(No BD) \n"
                                                           + "Si, terminas de digitar y se almacena la informacion en la BD\n"
                                                           + "Cancelar, simplemente vuelves a donde estabas.");
            switch (confirmacion) {
                case JOptionPane.OK_OPTION:
                    Volver.setEnabled(true);
                    this.setVisible(false);
                    p2.setVisible(false);
                    p1.setVisible(true);
                    Contenedor.add(p1);
                    Contenedor.validate();
                    aux=new PanelCrear_2(p2.getTitulo(),p2.getDescripcion());
                    lista.add(aux);
                    p2.limpiar();
                    for(int i=0;i<lista.size();i++){
                        try {  
                            sec.AgregarSeccion(auxTema, lista.get(i).getTituloAux(),lista.get(i).getDescripcionAux());
                            ted=true;
                            
                        } catch (Exception ex) {
                            Logger.getLogger(Crear.class.getName()).log(Level.SEVERE, null, ex);
                            ted=false;
                        }finally{
                            //System.out.println(lista.get(i).getTituloAux());
                            //System.out.println(lista.get(i).getDescripcionAux());
                        }
                    }
                    if(ted==true){
                        JOptionPane.showMessageDialog(null, "Se ha agregado con exito "+lista.size()+" secciones");
                        actualizarTemasMasConsultados();
                    }else{
                    }
                    break;
                case JOptionPane.NO_OPTION:
                    aux=new PanelCrear_2(p2.getTitulo(),p2.getDescripcion());
                    lista.add(aux);
                    p2.limpiar();
                    JOptionPane.showMessageDialog(null,"Ok, siga digitando secciones");
                    break;
                default:
                    break;
            }
        }else{
            JOptionPane.showMessageDialog(null,"Por favor llene todos los campos, antes de terminar");
        }
    }//GEN-LAST:event_TerminarActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenedor;
    private components.buttons.PrimaryButton Continuar;
    private components.buttons.PrimaryButton Terminar;
    private components.buttons.PrimaryButton Volver;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
