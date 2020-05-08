package vistas;

import components.menus.NavBarItem;
import components.styles.Theme;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import modelos.Usuario;

/**
 *
 * @author Johan
 */
class BarraLoggedIn extends javax.swing.JPanel implements ActionListener{
    Usuario usuario;
    JPopupMenu popupUsuario, popupMenu;
    JMenuItem itemCerrarSesion, itemCrearTema, itemEditarTema, itemSalir;
    /**
     * Creates new form BarraLoggedIn
     */
    public BarraLoggedIn() {
        this(null);
    }
    
    public BarraLoggedIn(Usuario usuario){
        initComponents();
        this.usuario = usuario;
        setOpaque(false);
        btnUsuario.setHoverground(Theme.PDARK);
        cargarDatos();
        crearPopupUsuario();
        crearPopupMenu();
    }
    
    private void cargarDatos(){
        try{
            nombre.setText(usuario.getNombre());
            rol.setText(usuario.getRol());
        }catch(NullPointerException ex){}
    }
    
    private void crearPopupUsuario(){
        popupUsuario = new JPopupMenu();
        itemCerrarSesion = new NavBarItem("Cerrar sesión");
        itemSalir = new NavBarItem("Salir");
        popupUsuario.add(itemCerrarSesion);
        popupUsuario.add(itemSalir);
        itemCerrarSesion.addActionListener(this);
        itemSalir.addActionListener(this);
    }
    
    private void crearPopupMenu(){
        popupMenu = new JPopupMenu();
        itemCrearTema = new NavBarItem("Crear tema");
        itemEditarTema = new NavBarItem("Editar tema");
        popupMenu.add(itemCrearTema);
        popupMenu.add(itemEditarTema);
        itemCrearTema.addActionListener(this);
        itemEditarTema.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre = new javax.swing.JLabel();
        btnUsuario = new components.buttons.PrimaryButton();
        rol = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));

        nombre.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/user_white.png"))); // NOI18N
        nombre.setText("Usuario");

        btnUsuario.setBackground(Theme.PRIMARY);
        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/arrow_down_white.png"))); // NOI18N
        btnUsuario.setText("");
        btnUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUsuarioMousePressed(evt);
            }
        });

        rol.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        rol.setForeground(new java.awt.Color(255, 255, 255));
        rol.setText("Rol");
        rol.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        menu.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/iconos/menu_white.png"))); // NOI18N
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(menu)
                .addGap(18, 18, 18)
                .addComponent(rol, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(rol, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Generar popup usuario
     * @param evt 
     */
    private void btnUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuarioMousePressed
        // TODO add your handling code here:
        int x = 0;
        popupUsuario.setVisible(false);
        popupUsuario.show(evt.getComponent(), x, btnUsuario.getHeight());
        x = btnUsuario.getWidth() - popupUsuario.getWidth();
        popupUsuario.show(evt.getComponent(), x, btnUsuario.getHeight());
        popupUsuario.setVisible(true);
    }//GEN-LAST:event_btnUsuarioMousePressed

    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
        // TODO add your handling code here:
        popupMenu.show(evt.getComponent(), 0, menu.getHeight()-1);
    }//GEN-LAST:event_menuMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.buttons.PrimaryButton btnUsuario;
    private javax.swing.JLabel menu;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel rol;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(itemCerrarSesion)){
            if(getParent() instanceof BarraApp){
                ((BarraApp) getParent()).cerrarSesion();
            }
        }else if(e.getSource().equals(itemSalir)){
            System.exit(0);
        }
    }
}
