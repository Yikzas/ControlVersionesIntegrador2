package Vistas;
import Entidades.Acciones;
import Entidades.Empleado;
import ImplementsDAO.DaoEmpleadoImpl;
import InterfacesDAO.DaoEmpleado;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class EmpleadosView extends javax.swing.JFrame {

    private DaoEmpleado dao;   
    private List<Empleado> lista;
    private Empleado empleado;
    private boolean aux;
    private DefaultTableModel model;
    
    public EmpleadosView() {
        initComponents();
        dao = new DaoEmpleadoImpl();
        empleado = new Empleado();
        model = (DefaultTableModel) tblEmpleados.getModel();
        empleadoSel(); 
        operacionesEstado(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnNegar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodEmpleado = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtSalario = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAfirmar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnHabilitar = new javax.swing.JButton();
        btnExportarEmple = new javax.swing.JButton();
        btnMovimientos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setText("PANEL DE CONTROL DE EMPLEADOS");

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CodEmpleado", "Nombres", "Apellidos", "Salario(.S/)", "Cargo", "User", "Pass", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tblEmpleados);
        if (tblEmpleados.getColumnModel().getColumnCount() > 0) {
            tblEmpleados.getColumnModel().getColumn(0).setMinWidth(100);
            tblEmpleados.getColumnModel().getColumn(0).setMaxWidth(100);
            tblEmpleados.getColumnModel().getColumn(3).setMinWidth(30);
            tblEmpleados.getColumnModel().getColumn(3).setMaxWidth(80);
            tblEmpleados.getColumnModel().getColumn(4).setMinWidth(120);
            tblEmpleados.getColumnModel().getColumn(4).setMaxWidth(120);
            tblEmpleados.getColumnModel().getColumn(5).setMinWidth(30);
            tblEmpleados.getColumnModel().getColumn(5).setMaxWidth(80);
            tblEmpleados.getColumnModel().getColumn(6).setMinWidth(30);
            tblEmpleados.getColumnModel().getColumn(6).setMaxWidth(80);
            tblEmpleados.getColumnModel().getColumn(7).setMaxWidth(100);
        }

        btnNegar.setText("NEGAR");
        btnNegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNegarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel2.setText("Registro de empleados");

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jLabel3.setText("CodEmpleado:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jLabel4.setText("Nombres:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jLabel5.setText("Apellidos:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jLabel6.setText("Salario:");

        jLabel7.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jLabel7.setText("Cargo:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jLabel8.setText("User:");

        jLabel9.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        jLabel9.setText("Pass:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtCodEmpleado)
                    .addComponent(txtNombres)
                    .addComponent(txtApellidos)
                    .addComponent(txtSalario)
                    .addComponent(txtCargo)
                    .addComponent(txtUser)
                    .addComponent(txtPass))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("DESHABILITAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAfirmar.setText("ACEPTAR");
        btnAfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfirmarActionPerformed(evt);
            }
        });

        btnRegresar.setText("REGRESAR AL PANEL PRINCIPAL");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnHabilitar.setText("HABILITAR");
        btnHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabilitarActionPerformed(evt);
            }
        });

        btnExportarEmple.setText("EXPORTAR LISTA DE EMPLEADOS");
        btnExportarEmple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarEmpleActionPerformed(evt);
            }
        });

        btnMovimientos.setText("EXPORTAR LISTA DE MOVIMIENTOS");
        btnMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExportarEmple, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnNegar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNegar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHabilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportarEmple, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        operacionesEstado(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        txtCodEmpleado.setText((String) model.getValueAt(tblEmpleados.getSelectedRow(), 0));
        txtNombres.setText(model.getValueAt(tblEmpleados.getSelectedRow(), 1).toString());
        txtApellidos.setText(model.getValueAt(tblEmpleados.getSelectedRow(), 2).toString());
        txtSalario.setText(model.getValueAt(tblEmpleados.getSelectedRow(), 3).toString()); 
        txtCargo.setText(model.getValueAt(tblEmpleados.getSelectedRow(), 4).toString()); 
        txtUser.setText(model.getValueAt(tblEmpleados.getSelectedRow(), 5).toString()); 
        txtPass.setText(model.getValueAt(tblEmpleados.getSelectedRow(), 6).toString()); 
        operacionesEstado(true);
        aux = true;
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas inhabilitar a este empleado?", "Confirmación de Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            String id = model.getValueAt(tblEmpleados.getSelectedRow(), 0).toString();
            dao.actualizarEstadoEmpleado(id, "Inactivo");
            empleadoSel();
            JOptionPane.showMessageDialog(null, "El empleado ha sido inhabilitado exitosamente.", "Eliminación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } 
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfirmarActionPerformed
        String codEmpleado = txtCodEmpleado.getText();
        String nombre = txtNombres.getText();
        String apellido = txtApellidos.getText();
        double salario = Double.parseDouble(txtSalario.getText());
        String cargo = txtCargo.getText();
        String user = txtUser.getText();
        String pass = txtPass.getText();

        empleado.setCodEmpleado(codEmpleado);
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setSalario(salario);
        empleado.setCargo(cargo);
        empleado.setUser(user);
        empleado.setPass(pass);

        if (aux) {
            dao.empleadoUpd(empleado);
            JOptionPane.showMessageDialog(null, "El registro ha sido actualizado con éxito");
        } else {
            empleado.setEstado("Activo");
            dao.empleadoIns(empleado);
            JOptionPane.showMessageDialog(null, "El registro ha sido agregado con éxito");
        }

        empleadoSel();
        operacionesEstado(false);
    }//GEN-LAST:event_btnAfirmarActionPerformed

    private void btnNegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNegarActionPerformed
        operacionesEstado(false);
    }//GEN-LAST:event_btnNegarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        dispose();
        PanelPrincipal men = new PanelPrincipal();
        men.setVisible(true);
        men.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabilitarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas habilitar a este empleado?", "Confirmación de Habilitación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            String id = model.getValueAt(tblEmpleados.getSelectedRow(), 0).toString();
            dao.actualizarEstadoEmpleado(id, "Activo");
            empleadoSel();
            JOptionPane.showMessageDialog(null, "El empleado ha sido habilitado exitosamente.", "Habilitación Exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnHabilitarActionPerformed

    private void btnExportarEmpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarEmpleActionPerformed
        generarYDescargarExcelEmpleados();
    }//GEN-LAST:event_btnExportarEmpleActionPerformed

    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
        generarYDescargarExcelMovimientos();
    }//GEN-LAST:event_btnMovimientosActionPerformed

    private void generarYDescargarExcelEmpleados() {
        try {
            List<Empleado> empleadosList = dao.empleadoSel();

            String desktopPath = System.getProperty("user.home") + "/Desktop/";

            String filePath = desktopPath + "ListaEmpleados.xlsx";

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Empleados");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("CodEmpleado");
            headerRow.createCell(1).setCellValue("Nombre");
            headerRow.createCell(2).setCellValue("Apellido");
            headerRow.createCell(3).setCellValue("Salario");
            headerRow.createCell(4).setCellValue("Cargo");
            headerRow.createCell(5).setCellValue("User");
            headerRow.createCell(6).setCellValue("Pass");
            headerRow.createCell(7).setCellValue("Estado");

            int rowNum = 1;
            for (Empleado empleado : empleadosList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(empleado.getCodEmpleado());
                row.createCell(1).setCellValue(empleado.getNombre());
                row.createCell(2).setCellValue(empleado.getApellido());
                row.createCell(3).setCellValue(empleado.getSalario());
                row.createCell(4).setCellValue(empleado.getCargo());
                row.createCell(5).setCellValue(empleado.getUser());
                row.createCell(6).setCellValue(empleado.getPass());
                row.createCell(7).setCellValue(empleado.getEstado());
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

            workbook.close();

            JOptionPane.showMessageDialog(this, "Archivo Excel de empleados creado y descargado en el escritorio.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar el archivo Excel de empleados: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generarYDescargarExcelMovimientos() {
        try {
            List<Acciones> accionesList = dao.listaAccion();

            String desktopPath = System.getProperty("user.home") + "/Desktop/";

            String filePath = desktopPath + "ListaMovimientos.xlsx";

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Acciones");

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Accion");
            headerRow.createCell(2).setCellValue("Fecha");

            sheet.setColumnWidth(1, 256 * 100);
            
            int rowNum = 1;
            for (Acciones acciones : accionesList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(acciones.getId());
                row.createCell(1).setCellValue(acciones.getAccion());
                row.createCell(2).setCellValue(acciones.getFecha());
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

            workbook.close();

            JOptionPane.showMessageDialog(this, "Archivo Excel creado y descargado en el escritorio.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar el archivo Excel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void empleadoSel() {
        lista = dao.empleadoSel();
        model.setRowCount(0);
        for (Empleado empleado : lista) {
            Object[] objeto = new Object[8];
            objeto[0] = empleado.getCodEmpleado();
            objeto[1] = empleado.getNombre();
            objeto[2] = empleado.getApellido();
            objeto[3] = empleado.getSalario();
            objeto[4] = empleado.getCargo();
            objeto[5] = empleado.getUser();
            objeto[6] = empleado.getPass();
            objeto[7] = empleado.getEstado();
            model.addRow(objeto);            
        }
    }
    
    private void operacionesEstado(boolean estado) {
        txtCodEmpleado.setEnabled(estado);
        txtNombres.setEnabled(estado);
        txtApellidos.setEnabled(estado);
        txtSalario.setEnabled(estado);
        txtCargo.setEnabled(estado);
        txtUser.setEnabled(estado);
        txtPass.setEnabled(estado);
        btnAgregar.setEnabled(!estado);
        btnAfirmar.setEnabled(estado);
        btnEliminar.setEnabled(!estado);
        btnNegar.setEnabled(estado);    
        btnEditar.setEnabled(!estado);
        btnHabilitar.setEnabled(!estado);
        if (!estado) {
            txtCodEmpleado.setText(null);
            txtNombres.setText(null);
            txtApellidos.setText(null);
            txtSalario.setText(null);
            txtCargo.setText(null);
            txtUser.setText(null);
            txtPass.setText(null);            
        }
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfirmar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportarEmple;
    private javax.swing.JButton btnHabilitar;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JButton btnNegar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCodEmpleado;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
