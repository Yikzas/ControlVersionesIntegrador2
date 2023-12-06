package Vistas;

import ImplementsDAO.DaoEmpleadoImpl;
import InterfacesDAO.DaoEmpleado;

public class PanelPrincipal extends javax.swing.JFrame {

    public static String cargoActual;
    private final DaoEmpleado dao;
    
    public PanelPrincipal() {
        initComponents();
        dao = new DaoEmpleadoImpl();
        if (cargoActual != null) {
            if (cargoActual.equals("Recepcionista")) {
                btnPanelEmpleados.setEnabled(false);
                btnPanelVentas.setEnabled(false);
                btnCatalogo.setEnabled(false);
            } 
        }
    }

    public static String getCargoActual() {
        return cargoActual;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnPanelHabitaciones = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnPanelEmpleados = new javax.swing.JButton();
        btnPanelVentas = new javax.swing.JButton();
        btnCatalogo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        jLabel1.setText("PANEL PRINCIPAL");

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        btnPanelHabitaciones.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnPanelHabitaciones.setText("PANEL DE CONTROL DE HABITACIONES");
        btnPanelHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanelHabitacionesActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(102, 255, 255));
        btnSalir.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnPanelEmpleados.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnPanelEmpleados.setText("PANEL DE CONTROL DE EMPLEADOS");
        btnPanelEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanelEmpleadosActionPerformed(evt);
            }
        });

        btnPanelVentas.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnPanelVentas.setText("PANEL DE INFORME");
        btnPanelVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanelVentasActionPerformed(evt);
            }
        });

        btnCatalogo.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnCatalogo.setText("CATALOGO DE HABITACIONES");
        btnCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatalogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPanelEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnPanelVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPanelHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnPanelEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPanelHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPanelVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnPanelEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanelEmpleadosActionPerformed
        dispose();        
        EmpleadosView emp = new EmpleadosView();
        emp.setVisible(true);
        emp.setLocationRelativeTo(null); 
    }//GEN-LAST:event_btnPanelEmpleadosActionPerformed

    private void btnPanelHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanelHabitacionesActionPerformed
        dispose();        
        SistHabitaciones mes = new SistHabitaciones();
        mes.setVisible(true);
        mes.setLocationRelativeTo(null); 
    }//GEN-LAST:event_btnPanelHabitacionesActionPerformed

    private void btnPanelVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanelVentasActionPerformed
        dispose();        
        Informe emp = new Informe();
        emp.setVisible(true);
        emp.setLocationRelativeTo(null); 
    }//GEN-LAST:event_btnPanelVentasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dao.eliminarCodAuxiliar();
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatalogoActionPerformed
        dispose();        
        Catalogo emp = new Catalogo();
        emp.setVisible(true);
        emp.setLocationRelativeTo(null); 
    }//GEN-LAST:event_btnCatalogoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCatalogo;
    private javax.swing.JButton btnPanelEmpleados;
    private javax.swing.JButton btnPanelHabitaciones;
    private javax.swing.JButton btnPanelVentas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
