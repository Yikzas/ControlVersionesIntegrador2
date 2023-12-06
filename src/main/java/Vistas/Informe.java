package Vistas;
import InterfacesDAO.DaoCliente;
import InterfacesDAO.DaoRegistro;
import ImplementsDAO.DaoRegistroImpl;
import Entidades.Registro;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import ImplementsDAO.DaoClienteImpl;
import Entidades.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Informe extends javax.swing.JFrame {

    private final DaoRegistro dao;
    private final DaoCliente daoC;
    private List<Registro> lista;
    private List<Cliente> lista1;
    private final DefaultTableModel model;
    private final DefaultTableModel model1;
    List<Registro> registros = new ArrayList<>();

    public Informe() {
        initComponents();
        dao = new DaoRegistroImpl();
        daoC = new DaoClienteImpl();
        model = (DefaultTableModel) Table1.getModel();
        model1 = (DefaultTableModel) Table2.getModel();
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaBOL = formatoFecha.format(fechaActual);
        txtFecha.setText(fechaBOL);
        obtenerVentas();
        obtenerClientes();
        calcularSumaTotal();
        calcularPromedio();
    }

    private void obtenerVentas() {       
        lista = dao.obtenerRegistros();
        model.setRowCount(0);
        for (Registro registro : lista) {
            if ("Finalizado".equalsIgnoreCase(registro.getEstado())) {
                registros.add(registro);
                Object[] objeto = new Object[7];
                objeto[0] = registro.getIDRegistro();
                objeto[1] = registro.getEstado();
                objeto[2] = registro.getFechaEntrada();
                objeto[3] = registro.getFechaSalida();
                objeto[4] = registro.getHora();
                objeto[5] = registro.getHorafp();
                objeto[6] = registro.getTotal();
                model.addRow(objeto);
            }
        }
        
    }

    private void obtenerClientes() {
        lista1 = daoC.clienteSel();
        model1.setRowCount(0);
        int totalFilas = 0;
        for (Cliente clientes : lista1) {
            if (clientes.getNhospedajes() == 0 && clientes.getSituacion().equals("Nuevo")) {
                Object[] objeto = new Object[4];
                objeto[0] = clientes.getIDCliente();
                objeto[1] = clientes.getNomCli();
                objeto[2] = clientes.getApeCli();
                objeto[3] = clientes.getSituacion();
                model1.addRow(objeto);
                totalFilas++;
            }
        }
        txtClientes.setText(String.valueOf(totalFilas));
    }

    private void calcularSumaTotal() {
        double suma = 0.0;
        int totalColumnIndex = Table1.getColumnCount() - 1;

        for (int row = 0; row < Table1.getRowCount(); row++) {
            Object valor = Table1.getValueAt(row, totalColumnIndex);
            if (valor instanceof Double) {
                suma += (Double) valor;
            }
        }
        txtTotal.setText(String.valueOf(suma));
    }

    private void calcularPromedio() {
        List<Long> diferencias = calcularDiferenciasDeTiempo();
        int totalFilas = diferencias.size();

        if (totalFilas > 0) {
            long totalTiempoEsperaSegundos = diferencias.stream().mapToLong(Long::longValue).sum();

            long promedioTiempoEsperaSegundos = totalTiempoEsperaSegundos / totalFilas;

            long horas = promedioTiempoEsperaSegundos / 3600;
            long minutos = (promedioTiempoEsperaSegundos % 3600) / 60;
            long segundos = promedioTiempoEsperaSegundos % 60;

            String resultadoPromedio = String.format("%02d:%02d:%02d", horas, minutos, segundos);
            txtPromedio.setText(resultadoPromedio);
        } else {
            txtPromedio.setText("No hay registros");
        }
    }

    private List<Long> calcularDiferenciasDeTiempo() {
        List<Long> diferencias = new ArrayList<>();
        int totalFilas = model.getRowCount();

        for (int i = 0; i < totalFilas; i++) {
            try {
                String getRowInitialTime = model.getValueAt(i, 4).toString();
                String getRowFinalTime = model.getValueAt(i, 5).toString();

                String[] partes = getRowInitialTime.split(":");
                int horas = Integer.parseInt(partes[0]);
                int minutos = Integer.parseInt(partes[1]);
                int segundos = Integer.parseInt(partes[2]);

                long horaInicialSegundos = horas * 3600 + minutos * 60 + segundos;

                String[] partes1 = getRowFinalTime.split(":");
                int horas1 = Integer.parseInt(partes1[0]);
                int minutos1 = Integer.parseInt(partes1[1]);
                int segundos1 = Integer.parseInt(partes1[2]);

                long horaFinalSegundos = horas1 * 3600 + minutos1 * 60 + segundos1;

                long diferenciaTiempo = horaFinalSegundos - horaInicialSegundos;

                diferencias.add(diferenciaTiempo);
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
        }
        System.out.println(diferencias);
        return diferencias;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtPromedio = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        txtClientes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnInforme = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setText("Fecha:");

        Table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDClientes", "Nombres", "Apellidos", "Situacion"
            }
        ));
        jScrollPane2.setViewportView(Table2);

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel6.setText("CLIENTES NUEVOS REGISTRADOS:");

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDRegistro", "Estado", "FechaEntrada", "FechaSalida", "Hora Registro Inicial", "Hora Registro Final", "Total Pagado"
            }
        ));
        jScrollPane1.setViewportView(Table1);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setText("GANANCIA TOTAL DEL DIA:");

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel5.setText("TIEMPO PROMEDIO DE ESPERA DE LA REALIZACION DEL REGISTRO:");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel2.setText("INFORME DE REGISTROS FINALIZADOS");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel7.setText("INFORME DE CLIENTES NUEVOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1011, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(270, 270, 270)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPromedio))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1011, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnInforme.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btnInforme.setText("Generar Informe");
        btnInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformeActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton1.setText("REGRESAR AL PANEL PRINCIPAL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(102, 204, 255));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnLimpiar.setText("LIMPIAR REGISTROS DE LA TABLA");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(btnInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformeActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String filePath = file.getAbsolutePath();

            try {
                Document document = new Document(PageSize.A4.rotate());
                PdfWriter.getInstance(document, new FileOutputStream(filePath + ".pdf"));
                document.open();

                BufferedImage img = new BufferedImage(jPanel1.getWidth(),
                        jPanel1.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = img.createGraphics();
                jPanel1.printAll(g2d);
                g2d.dispose();

                Image pdfImg = Image.getInstance(img, null);
                pdfImg.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
                pdfImg.setAlignment(Image.ALIGN_CENTER);

                document.add(pdfImg);

                document.close();

                JOptionPane.showMessageDialog(this, "Informe de ventas del día generado y "
                        + "guardado exitosamente");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnInformeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        PanelPrincipal emp = new PanelPrincipal();
        emp.setVisible(true);
        emp.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(this, "Antes de realizar esta acción, "
                + "debes generar y guardar el informe de ventas del día. ¿Deseas continuar?",
                "Recomendación", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) Table1.getModel();
            int rowCount = model.getRowCount();

            for (int i = 0; i < rowCount; i++) {
                int idPedido = (int) Table1.getValueAt(i, 0);
                Table1.setValueAt("Reportado", i, 1);

                dao.actualizarEstadoRegistro(idPedido, "Reportado");
            }

            DefaultTableModel model1 = (DefaultTableModel) Table2.getModel();
            int rowCount1 = model1.getRowCount();

            for (int i = rowCount1 - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            obtenerVentas();
        }
    }//GEN-LAST:event_btnLimpiarActionPerformed
  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JTable Table2;
    private javax.swing.JButton btnInforme;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtClientes;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtPromedio;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
