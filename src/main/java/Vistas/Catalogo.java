package Vistas;
import Entidades.Habitacion;
import ImplementsDAO.DaoHabitacionImpl;
import InterfacesDAO.DaoHabitacion;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Catalogo extends javax.swing.JFrame {

    private DaoHabitacion dao;   
    private List<Habitacion> lista;
    private Habitacion habitacion;
    private boolean aux;
    private DefaultTableModel model;
    int idAbs;
    
    public Catalogo() {
        initComponents();
        dao = new DaoHabitacionImpl();
        habitacion = new Habitacion();
        model = (DefaultTableModel) Table.getModel();
        habitacionSel(); 
        operacionesEstado(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCapacidad = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescri = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        txtImg = new javax.swing.JTextField();
        ComboBoxTipo = new javax.swing.JComboBox<>();
        btnIngresar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnAfirmar = new javax.swing.JButton();
        btnNegar = new javax.swing.JButton();
        txtMostrarImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Estado", "Capacidad", "descripcion", "tipo", "precio/dia", "img"
            }
        ));
        jScrollPane1.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setMinWidth(30);
            Table.getColumnModel().getColumn(0).setMaxWidth(30);
            Table.getColumnModel().getColumn(1).setMinWidth(80);
            Table.getColumnModel().getColumn(1).setMaxWidth(80);
            Table.getColumnModel().getColumn(2).setMinWidth(70);
            Table.getColumnModel().getColumn(2).setMaxWidth(70);
            Table.getColumnModel().getColumn(4).setMinWidth(90);
            Table.getColumnModel().getColumn(4).setMaxWidth(90);
            Table.getColumnModel().getColumn(5).setMinWidth(70);
            Table.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel1.setText("Catálogo de Habitaciones");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Seleccione el tipo de habitación:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Ingrese la capacidad de la habitación (AFORO):");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Ingrese la descripción de la habitación:");

        txtDescri.setColumns(20);
        txtDescri.setRows(5);
        jScrollPane2.setViewportView(txtDescri);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Ingrese imagen de muestra de la habitación:");

        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        ComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dobles", "Cuádruples", "Individuales", "Familiares", "Suite principal" }));

        btnIngresar.setText("INGRESAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(102, 255, 255));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 0, 0));
        btnRegresar.setText("REGRESAR AL PANEL PRINCIPAL");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Precio x Día:");

        btnAfirmar.setText("AFIRMAR");
        btnAfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfirmarActionPerformed(evt);
            }
        });

        btnNegar.setText("NEGAR");
        btnNegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNegarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNegar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(jScrollPane2)
                                .addComponent(jLabel5)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtImg)))
                            .addComponent(ComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionar)
                    .addComponent(txtImg, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNegar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMostrarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(381, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(334, 334, 334))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMostrarImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        JFileChooser archivo = new JFileChooser();
        int  ventana = archivo.showOpenDialog(null);
        if (ventana == JFileChooser.APPROVE_OPTION) {
            File file = archivo.getSelectedFile();
            txtImg.setText(String.valueOf(file));
        }                   
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        operacionesEstado(true);
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        img();
        String valorID = model.getValueAt(Table.getSelectedRow(), 0).toString();
        int idUPD = Integer.parseInt(valorID);       
        idAbs = idUPD;
        ComboBoxTipo.setSelectedItem(model.getValueAt(Table.getSelectedRow(), 4));
        String valorDesdeTabla = model.getValueAt(Table.getSelectedRow(), 2).toString();
        int valorEntero = Integer.parseInt(valorDesdeTabla);
        txtCapacidad.setValue(valorEntero);
        txtDescri.setText(model.getValueAt(Table.getSelectedRow(), 3).toString());
        txtPrecio.setText(model.getValueAt(Table.getSelectedRow(), 5).toString()); 
        operacionesEstado(true);
        aux = true;
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar este registro?", "Confirmación de Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            String idH = model.getValueAt(Table.getSelectedRow(), 0).toString();
            int id = Integer.parseInt(idH);
            dao.eliminar(id);
            habitacionSel();
            JOptionPane.showMessageDialog(null, "El registro ha sido eliminado exitosamente.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } 
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        dispose();
        PanelPrincipal regi = new PanelPrincipal();
        regi.setVisible(true);
        regi.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfirmarActionPerformed
        String tipo = ComboBoxTipo.getSelectedItem().toString();
        int capacidad = (int) txtCapacidad.getValue();
        String descripcion = txtDescri.getText();
        double precio = Double.parseDouble(txtPrecio.getText());
        String img = txtImg.getText();
        if (aux) {
            habitacion.setTipo(tipo);
            habitacion.setCapacidad(capacidad);
            habitacion.setDescripcion(descripcion);
            habitacion.setEstado("Disponible");
            habitacion.setPrecio(precio);
            habitacion.setIDHabitacion(idAbs);
            dao.actualizar(habitacion);
            JOptionPane.showMessageDialog(null, "El registro ha sido actualizado con éxito");
        } else {
            habitacion.setTipo(tipo);
            habitacion.setCapacidad(capacidad);
            habitacion.setDescripcion(descripcion);
            habitacion.setEstado("Disponible");
            habitacion.setPrecio(precio);
            habitacion.setImagen(img);
            dao.insertarHabitacion(habitacion);
            JOptionPane.showMessageDialog(null, "El registro ha sido agregado con éxito");
        }

        habitacionSel();
        operacionesEstado(false);
    }//GEN-LAST:event_btnAfirmarActionPerformed

    private void btnNegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNegarActionPerformed
        operacionesEstado(false);
    }//GEN-LAST:event_btnNegarActionPerformed

    private void habitacionSel() {
        lista = dao.habitacionSel();
        model.setRowCount(0);
        for (Habitacion habi: lista) {
            Object[] objeto = new Object[7];
            objeto[0] = habi.getIDHabitacion();
            objeto[1] = habi.getEstado();
            objeto[2] = habi.getCapacidad();
            objeto[3] = habi.getDescripcion();
            objeto[4] = habi.getTipo();
            objeto[5] = habi.getPrecio();
            objeto[6] = habi.getImagen();
            model.addRow(objeto);
        }
    }
    
    private void img() {        
        String valorID = model.getValueAt(Table.getSelectedRow(), 0).toString();   
        int habiIMG = Integer.parseInt(valorID);
        String imgCod = dao.getImage(habiIMG);
        if (imgCod != null) {
            try {
                byte[] imageData = Base64.getDecoder().decode(imgCod);
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
                ImageIcon icon = new ImageIcon(img);
                Image image = icon.getImage();
                Image newimg = image.getScaledInstance(txtMostrarImg.getWidth(), txtMostrarImg.getHeight(), java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                txtMostrarImg.setIcon(newIcon);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }    
    
    private void operacionesEstado(boolean estado) {
        ComboBoxTipo.setEnabled(estado);
        txtCapacidad.setEnabled(estado);
        txtDescri.setEnabled(estado);
        txtMostrarImg.setEnabled(estado);
        txtImg.setEnabled(estado);
        txtPrecio.setEnabled(estado);
        btnIngresar.setEnabled(!estado);
        btnAfirmar.setEnabled(estado);
        btnEliminar.setEnabled(!estado);
        btnSeleccionar.setEnabled(estado);
        btnNegar.setEnabled(estado);
        btnActualizar.setEnabled(!estado);
        if (!estado) {
            txtCapacidad.setValue(0);
            ComboBoxTipo.setSelectedItem("Dobles");
            txtDescri.setText(null);
            txtImg.setText(null);
            txtPrecio.setText(null);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxTipo;
    private javax.swing.JTable Table;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAfirmar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnNegar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner txtCapacidad;
    private javax.swing.JTextArea txtDescri;
    private javax.swing.JTextField txtImg;
    private javax.swing.JLabel txtMostrarImg;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
