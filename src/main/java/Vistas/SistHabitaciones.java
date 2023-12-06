package Vistas;

import ImplementsDAO.DaoHabitacionImpl;
import InterfacesDAO.DaoHabitacion;

public class SistHabitaciones extends javax.swing.JFrame {

    private DaoHabitacion dao;
    
    public SistHabitaciones() {
        initComponents();
        dao = new DaoHabitacionImpl();
        int idMesa1 = 1;
        String estadoMesa = dao.obtenerEstadoPorID(idMesa1);
        txt1.setText(estadoMesa);
        String tipo =  dao.obtenerTipoPorID(idMesa1);
        jlabel1.setText(tipo);
        int idMesa2 = 2;
        String estadoMesa2 = dao.obtenerEstadoPorID(idMesa2);
        txt2.setText(estadoMesa2);
        String tipo2 =  dao.obtenerTipoPorID(idMesa2);
        jlabel2.setText(tipo2);
        int idMesa3 = 3;
        String estadoMesa3 = dao.obtenerEstadoPorID(idMesa3);
        txt3.setText(estadoMesa3);
        String tipo3 =  dao.obtenerTipoPorID(idMesa3);
        jlabel3.setText(tipo3);        
        int idMesa4 = 4;
        String estadoMesa4 = dao.obtenerEstadoPorID(idMesa4);
        txt4.setText(estadoMesa4);
        String tipo4 =  dao.obtenerTipoPorID(idMesa4);
        jlabel4.setText(tipo4);        
        int idMesa5 = 5;
        String estadoMesa5 = dao.obtenerEstadoPorID(idMesa5);
        txt5.setText(estadoMesa5);
        String tipo5 =  dao.obtenerTipoPorID(idMesa5);
        jlabel5.setText(tipo5);        
        int idMesa6 = 6;
        String estadoMesa6 = dao.obtenerEstadoPorID(idMesa6);
        txt6.setText(estadoMesa6);
        String tipo6 =  dao.obtenerTipoPorID(idMesa6);
        jlabel6.setText(tipo6);        
        int idMesa7 = 7;
        String estadoMesa7 = dao.obtenerEstadoPorID(idMesa7);
        txt7.setText(estadoMesa7);
        String tipo7 =  dao.obtenerTipoPorID(idMesa7);
        jlabel7.setText(tipo7);        
        int idMesa8 = 8;
        String estadoMesa8 = dao.obtenerEstadoPorID(idMesa8);
        txt8.setText(estadoMesa8);
        String tipo8 =  dao.obtenerTipoPorID(idMesa8);
        jlabel8.setText(tipo8);        
        int idMesa9 = 9;
        String estadoMesa9 = dao.obtenerEstadoPorID(idMesa9);
        txt9.setText(estadoMesa9);
        String tipo9 =  dao.obtenerTipoPorID(idMesa9);
        jlabel9.setText(tipo9);        
        int idMesa10 = 10;
        String estadoMesa10 = dao.obtenerEstadoPorID(idMesa10);
        txt10.setText(estadoMesa10); 
        String tipo10 =  dao.obtenerTipoPorID(idMesa10);
        jlabel10.setText(tipo10);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnHabi1 = new javax.swing.JButton();
        txt1 = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        txt2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnHabi2 = new javax.swing.JButton();
        btnHabi3 = new javax.swing.JButton();
        txt3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt4 = new javax.swing.JTextField();
        btnHabi4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnHabi5 = new javax.swing.JButton();
        btnHabi6 = new javax.swing.JButton();
        txt6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnHabi7 = new javax.swing.JButton();
        txt7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnHabi8 = new javax.swing.JButton();
        txt8 = new javax.swing.JTextField();
        btnHabi9 = new javax.swing.JButton();
        txt9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnHabi10 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txt10 = new javax.swing.JTextField();
        jlabel1 = new javax.swing.JLabel();
        jlabel2 = new javax.swing.JLabel();
        jlabel3 = new javax.swing.JLabel();
        jlabel4 = new javax.swing.JLabel();
        jlabel5 = new javax.swing.JLabel();
        jlabel6 = new javax.swing.JLabel();
        jlabel7 = new javax.swing.JLabel();
        jlabel8 = new javax.swing.JLabel();
        jlabel9 = new javax.swing.JLabel();
        jlabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel1.setText("PANEL DE HABITACIONES");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel2.setText("HABITACION 1");

        btnHabi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabi1ActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(153, 255, 255));
        btnRegresar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnRegresar.setText("REGRESAR AL PANEL PRINCIPAL");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setText("HABITACION 2");

        btnHabi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabi2ActionPerformed(evt);
            }
        });

        btnHabi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabi3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setText("HABITACION 3");

        btnHabi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabi4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setText("HABITACION 4");

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setText("HABITACION 5");

        btnHabi5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabi5ActionPerformed(evt);
            }
        });

        btnHabi6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabi6ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel7.setText("HABITACION 6");

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel8.setText("HABITACION 7");

        btnHabi7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabi7ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel9.setText("HABITACION 8");

        btnHabi8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabi8ActionPerformed(evt);
            }
        });

        btnHabi9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabi9ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel10.setText("HABITACION 9");

        btnHabi10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabi10ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel11.setText("HABITACION 10");

        jlabel1.setText("D");

        jlabel2.setText("D");

        jlabel3.setText("D");

        jlabel4.setText("D");

        jlabel5.setText("D");

        jlabel6.setText("D");

        jlabel7.setText("D");

        jlabel8.setText("D");

        jlabel9.setText("D");

        jlabel10.setText("D");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jlabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(616, 616, 616))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnHabi1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnHabi2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jlabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel8)
                                                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnHabi3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jlabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel9)
                                                .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnHabi4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jlabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel10)
                                                .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnHabi5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jlabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel11))
                                        .addGap(9, 9, 9))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jlabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnHabi6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnHabi7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnHabi8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnHabi9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(txt9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnHabi10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel1)
                    .addComponent(jlabel2)
                    .addComponent(jlabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlabel4)
                        .addComponent(jlabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHabi1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHabi2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHabi3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHabi4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHabi5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabel6)
                            .addComponent(jlabel7)
                            .addComponent(jlabel8)
                            .addComponent(jlabel9)
                            .addComponent(jlabel10))
                        .addGap(8, 8, 8)
                        .addComponent(btnHabi6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnHabi7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnHabi8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnHabi9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnHabi10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(34, 34, 34)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
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

    private void btnHabi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabi1ActionPerformed
        String mesa = "1";  
        RegistroHabitaciones1 regi = new RegistroHabitaciones1();
        regi.setMesa(mesa);
        dispose();
        regi.setVisible(true);
        regi.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHabi1ActionPerformed

    private void btnHabi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabi2ActionPerformed
        String mesa = "2";  
        RegistroHabitaciones2 regi = new RegistroHabitaciones2();
        regi.setMesa(mesa);
        dispose();
        regi.setVisible(true);
        regi.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHabi2ActionPerformed

    private void btnHabi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabi3ActionPerformed
        String mesa = "3";  
        RegistroHabitaciones3 regi = new RegistroHabitaciones3();
        regi.setMesa(mesa);
        dispose();
        regi.setVisible(true);
        regi.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHabi3ActionPerformed

    private void btnHabi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabi4ActionPerformed
        String mesa = "4";  
        RegistroHabitaciones4 regi = new RegistroHabitaciones4();
        regi.setMesa(mesa);
        dispose();
        regi.setVisible(true);
        regi.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHabi4ActionPerformed

    private void btnHabi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabi5ActionPerformed
        String mesa = "5";  
        RegistroHabitaciones5 regi = new RegistroHabitaciones5();
        regi.setMesa(mesa);
        dispose();
        regi.setVisible(true);
        regi.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHabi5ActionPerformed

    private void btnHabi6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabi6ActionPerformed
        String mesa = "6";  
        RegistroHabitaciones6 regi = new RegistroHabitaciones6();
        regi.setMesa(mesa);
        dispose();
        regi.setVisible(true);
        regi.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHabi6ActionPerformed

    private void btnHabi7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabi7ActionPerformed
        String mesa = "7";  
        RegistroHabitaciones7 regi = new RegistroHabitaciones7();
        regi.setMesa(mesa);
        dispose();
        regi.setVisible(true);
        regi.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHabi7ActionPerformed

    private void btnHabi8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabi8ActionPerformed
        String mesa = "8";  
        RegistroHabitaciones8 regi = new RegistroHabitaciones8();
        regi.setMesa(mesa);
        dispose();
        regi.setVisible(true);
        regi.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHabi8ActionPerformed

    private void btnHabi9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabi9ActionPerformed
        String mesa = "9";  
        RegistroHabitaciones9 regi = new RegistroHabitaciones9();
        regi.setMesa(mesa);
        dispose();
        regi.setVisible(true);
        regi.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHabi9ActionPerformed

    private void btnHabi10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabi10ActionPerformed
        String mesa = "10";  
        RegistroHabitaciones10 regi = new RegistroHabitaciones10();
        regi.setMesa(mesa);
        dispose();
        regi.setVisible(true);
        regi.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHabi10ActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        dispose();
        PanelPrincipal regi = new PanelPrincipal();
        regi.setVisible(true);
        regi.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHabi1;
    private javax.swing.JButton btnHabi10;
    private javax.swing.JButton btnHabi2;
    private javax.swing.JButton btnHabi3;
    private javax.swing.JButton btnHabi4;
    private javax.swing.JButton btnHabi5;
    private javax.swing.JButton btnHabi6;
    private javax.swing.JButton btnHabi7;
    private javax.swing.JButton btnHabi8;
    private javax.swing.JButton btnHabi9;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel jlabel10;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel jlabel4;
    private javax.swing.JLabel jlabel5;
    private javax.swing.JLabel jlabel6;
    private javax.swing.JLabel jlabel7;
    private javax.swing.JLabel jlabel8;
    private javax.swing.JLabel jlabel9;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt10;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JTextField txt7;
    private javax.swing.JTextField txt8;
    private javax.swing.JTextField txt9;
    // End of variables declaration//GEN-END:variables
}
