package Vistas;

import Entidades.Cliente;
import Entidades.Registro;
import Entidades.Habitacion;
import ImplementsDAO.DaoClienteImpl;
import ImplementsDAO.DaoEmpleadoImpl;
import ImplementsDAO.DaoHabitacionImpl;
import ImplementsDAO.DaoRegistroImpl;
import InterfacesDAO.DaoCliente;
import InterfacesDAO.DaoEmpleado;
import InterfacesDAO.DaoHabitacion;
import InterfacesDAO.DaoRegistro;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;
import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class RegistroHabitaciones7 extends javax.swing.JFrame {

    private final DaoRegistro daoR;
    private final DaoEmpleado daoEmpleado;
    private final DaoCliente daoC;
    private final Cliente cliente;
    private final Registro registro;
    private static String horaInicio;
    private static final List<String> dnisClientes = new ArrayList<>();
    private static final List<Cliente> clientesEncontrados = new ArrayList<>();
    private final List<Cliente> ClienteTextArea = new ArrayList<>();
    private final DaoHabitacion daoH;
    private double descuentoTotal = 0.0;

    public RegistroHabitaciones7() {
        initComponents();
        txtdescuento.setText("0.0");
        txtTotal.setText("0.0");
        daoR = new DaoRegistroImpl();
        daoEmpleado = new DaoEmpleadoImpl();
        daoH = new DaoHabitacionImpl();
        daoC = new DaoClienteImpl();
        registro = new Registro();
        cliente = new Cliente();
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
        String fechaBOL = formatoFecha.format(fechaActual);
        txtFechaInicio.setText(fechaBOL);
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        formatoHora.setTimeZone(TimeZone.getTimeZone("GMT-5"));
        horaInicio = formatoHora.format(new Date());
        txtHoraInicio.setText(horaInicio);
        String cod = daoEmpleado.obtenerCodAuxiliar();
        txtEmpleado.setText(cod);
        actualizarHora();
    }

    private void img() {
        int habiIMG = Integer.parseInt(txtHabitacion.getText());
        String imgCod = daoH.getImage(habiIMG);
        if (imgCod != null) {
            try {
                byte[] imageData = Base64.getDecoder().decode(imgCod);
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
                ImageIcon icon = new ImageIcon(img);
                Image image = icon.getImage();
                Image newimg = image.getScaledInstance(labelImg.getWidth(), labelImg.getHeight(), java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                labelImg.setIcon(newIcon);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void llenarHabi() {
        int habiLLenar = Integer.parseInt(txtHabitacion.getText());
        Habitacion habit = daoH.getHabi(habiLLenar);
        String tipoL = habit.getTipo();
        int capacidadL = habit.getCapacidad();
        String capacidadS = String.valueOf(capacidadL);
        double precioL = habit.getPrecio();
        String precioS = String.valueOf(precioL);
        String descriL = habit.getDescripcion();
        txtTipo.setText(tipoL);
        txtCapacidad.setText(capacidadS);
        txtPrecio.setText(precioS);
        txtDescripcion.setText(descriL + " \n");
    }

    private void actualizarHora() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalTime now = LocalTime.now();
                String horaActual = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                jLabelHoraProceso.setText(horaActual);
            }
        });
        timer.start();
    }

    public static void resetearListaDNI() {
        dnisClientes.clear();
        clientesEncontrados.clear();
    }

    public void setMesa(String mesa) {
        txtHabitacion.setText(mesa);
        llenarHabi();
        img();
        open();
    }

    private void open() {
        int idMesa = Integer.parseInt(txtHabitacion.getText());
        String estadoMesa = daoH.obtenerEstadoPorID(idMesa);
        if (estadoMesa != null && estadoMesa.equals("Ocupado")) {
            cargarDatosPedido();
        }
    }

    private void cargarDatosPedido() {
        int mesaB = Integer.parseInt(txtHabitacion.getText());
        int idP = daoH.obtenerIDRegistroPorIDHabitacion(mesaB);

        double total = daoR.obtenerTotalRegistroPorID(idP);
        String tot = String.valueOf(total);
        txtTotal.setText(tot);
        Registro pedido = daoR.registroGet(idP);
        txtdescuento.setText(pedido.getDescuento());
        txtHoraInicio.setText(pedido.getHora());
        txtHoraFinal.setText(pedido.getHorafp());

        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
        String fechaStringDeInicio = formatoFecha.format(fechaActual);
        String fechaString = pedido.getFechaSalida();
        String fechaFin = fechaString;

        try {
            SimpleDateFormat formatoFechaBaseDatos = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaBaseDatosFin = formatoFechaBaseDatos.parse(fechaString);
            fechaFin = formatoFecha.format(fechaBaseDatosFin);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            SimpleDateFormat formatoFechaApp = new SimpleDateFormat("yyyy/MM/dd");

            Date fechaInicio = formatoFechaApp.parse(fechaStringDeInicio);
            txtFechaInicio.setText(formatoFecha.format(fechaInicio));

            Date fechaFinal = formatoFechaApp.parse(fechaFin);
            DateFinal.setDate(fechaFinal);

            long diferenciaEnMillisegundos = fechaFinal.getTime() - fechaInicio.getTime();
            long dias = diferenciaEnMillisegundos / (24 * 60 * 60 * 1000);
            txtDiasEstadia.setText(dias + " días");

            String diasString = Long.toString(dias);
            int diaC = Integer.parseInt(diasString);

            if (diaC == 1) {
                EnviarCorreo(idP);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Cliente> c = daoR.obtenerClientesPorIDRegistro(idP);
        StringBuilder nombresClientes = new StringBuilder();
        for (Cliente clientes : c) {
            nombresClientes.append(clientes.getNomCli()).append(" ").append(clientes.getApeCli()).append(System.lineSeparator());
        }
        txtCliente.setText(nombresClientes.toString());

    }

    private void EnviarCorreo(int id) {
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        Session sesion = Session.getDefaultInstance(propiedad);

        List<Cliente> cor = daoR.obtenerClientesPorIDRegistro(id);

        StringBuilder correosClientes = new StringBuilder();
        for (Cliente clienteC : cor) {
            correosClientes.append(clienteC.getCorreo()).append(",");
        }

        if (correosClientes.length() > 0) {
            correosClientes.setLength(correosClientes.length() - 1);
        }

        String correos = correosClientes.toString();
        String[] destinatarios = correos.split(",");

        String correoEnvia = "hotelkankay@gmail.com";
        String contrasena = "etju lxxj qpnv fcpv";
        String asunto = "Recordatorio de Estancia en el Hotel";
        String mensaje = "<h2 style=\"color: #3498db;\">Estimado Cliente,</h2>"
                + "<p style=\"font-size: 16px;\">Le informamos que su estancia en nuestro hotel finalizará pronto. "
                + "Por favor, tenga en cuenta que tiene 1 día restante en su reserva.</p>"
                + "<p style=\"font-size: 16px;\">¡Esperamos que haya disfrutado de su estancia con nosotros!</p>";

        try {
            for (String destinatario : destinatarios) {
                MimeMessage mail = new MimeMessage(sesion);
                mail.setFrom(new InternetAddress(correoEnvia));
                mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario.trim()));
                mail.setSubject(asunto);

                MimeMultipart multipart = new MimeMultipart("alternative");
                BodyPart messageBodyPart = new MimeBodyPart();
                messageBodyPart.setContent(mensaje, "text/html");
                multipart.addBodyPart(messageBodyPart);
                mail.setContent(multipart);

                Transport transportar = sesion.getTransport("smtp");
                transportar.connect(correoEnvia, contrasena);
                transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            }
        } catch (MessagingException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al enviar el correo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private List<Integer> obtenerIDsClientes(List<String> dnisClientes) {
        List<Integer> idsClientes = new ArrayList<>();

        for (String dni : dnisClientes) {
            Cliente cliente = daoC.clienteGetByDNI(dni);
            if (cliente != null) {
                idsClientes.add(cliente.getIDCliente());
            }
        }

        return idsClientes;
    }

    private List<Integer> obtenerIDsClientesB() {
        List<Integer> idsClientesB = new ArrayList<>();

        for (Cliente cliente : clientesEncontrados) {
            idsClientesB.add(cliente.getIDCliente());
        }

        return idsClientesB;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnAgregarCliente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDNIBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCliente = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        txtHabitacion = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        txtCapacidad = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        DateFinal = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnGenerarRegistro = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtdescuento = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtDiasEstadia = new javax.swing.JTextField();
        btnCalcularTotal = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnCambio = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBoleta = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        txtHoraInicio = new javax.swing.JTextField();
        jLabelHoraProceso = new javax.swing.JLabel();
        labelImg = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtHoraFinal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setText("Registrar Cliente");

        jLabel2.setText("Nombre del  Cliente:");

        jLabel3.setText("Apellido del  Cliente:");

        jLabel4.setText("DNI del  Cliente:");

        jLabel5.setText("Nº Celular del Cliente:");

        jLabel6.setText("Correo Electrónico:");

        btnAgregarCliente.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnAgregarCliente.setText("Agregar Cliente");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtApellido))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(36, 36, 36)
                                .addComponent(txtDNI))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCelular))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(13, 13, 13)
                                .addComponent(txtNombreCliente))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(20, 20, 20)
                                .addComponent(txtCorreo))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(btnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel7.setText("Buscar Cliente");

        jLabel8.setText("Ingrese el DNI del cliente ha buscar:");

        btnBuscar.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar Cliente");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDNIBuscar)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 51, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addGap(35, 35, 35)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDNIBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("Clientes Registrados en esta habitación:");

        txtCliente.setColumns(20);
        txtCliente.setRows(5);
        jScrollPane1.setViewportView(txtCliente);

        jLabel24.setText("Número de habitación:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(txtHabitacion)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel10.setText("CARACTERISTICAS DE LA HABITACION");

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel11.setText("CAPACIDAD DE LA HABITACION:");

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel12.setText("DESCRIPCION DE LA HABITACION:");

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel13.setText("TIPO DE HABITACION:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel20.setText("PRECIO POR DIA");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel20)
                            .addComponent(txtTipo)
                            .addComponent(txtCapacidad)
                            .addComponent(txtPrecio))
                        .addGap(0, 8, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel14.setText("INSCRIPCION");

        DateFinal.setDateFormatString("yyyy/MM/dd");

        jLabel15.setText("FECHA DE INGRESO:");

        jLabel16.setText("FECHA DE SALIDA:");

        btnGenerarRegistro.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnGenerarRegistro.setText("Generar Registro");
        btnGenerarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarRegistroActionPerformed(evt);
            }
        });

        jLabel17.setText("TOTAL:");

        jLabel18.setText("%DESCUENTO:");

        jLabel19.setText("DIAS DE RESIDENCIA:");

        btnCalcularTotal.setText("Calcular Total");
        btnCalcularTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel19)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(DateFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(txtFechaInicio))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14)
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnGenerarRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(txtDiasEstadia, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCalcularTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(17, 17, 17)
                .addComponent(jLabel15)
                .addGap(10, 10, 10)
                .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DateFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCalcularTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDiasEstadia, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGenerarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegresar.setText("REGRESAR AL PANEL DE HABITACIONES");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnCambio.setText("CAMBIAR USUARIO");
        btnCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioActionPerformed(evt);
            }
        });

        btnActualizar.setText("ACTUALIZAR REGISTRO");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnBoleta.setText("GENERAR BOLETA");
        btnBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoletaActionPerformed(evt);
            }
        });

        jLabel21.setText("Código del empleado:");

        jLabel22.setText("Inicio - Hora del Registro:");

        jLabel23.setText("Hora Actual:");

        btnLimpiar.setText("LIMPIAR REGISTRO");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabelHoraProceso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelHoraProceso.setText("00:00:00");

        jLabel25.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel25.setText("FOTO DE LA HABITACION");

        jLabel26.setText("Final - Hora del Registro:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegresar)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEmpleado))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addGap(10, 10, 10)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtHoraFinal)
                                    .addComponent(txtHoraInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelHoraProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addComponent(jLabel25)
                                .addGap(47, 47, 47))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHoraProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(labelImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
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

    private void calcularTotal() {
        double precio = Double.parseDouble(txtPrecio.getText());
        String diasTexto = txtDiasEstadia.getText();
        String obtencionDias = diasTexto.replaceAll("[^\\d]", "");
        double dias = Double.parseDouble(obtencionDias);
        double total = precio * dias;
        txtTotal.setText(String.valueOf(total));
    }

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas limpiar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            int mesilla = Integer.parseInt(txtHabitacion.getText());
            int idP = daoH.obtenerIDRegistroPorIDHabitacion(mesilla);
            txtFechaInicio.setText("");
            txtHoraInicio.setText(horaInicio);
            txtHoraFinal.setText("");
            txtCliente.setText("");
            DateFinal.setDate(null);
            txtDiasEstadia.setText("");
            resetearListaDNI();
            txtdescuento.setText("0.0");
            txtTotal.setText("0.0");
            daoH.actualizarEstadoPorID(mesilla, "Disponible");
            daoH.eliminarRelacionHabitacionR(idP, mesilla);
            JOptionPane.showMessageDialog(null, "Registro limpiado");
        }
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        dispose();
        SistHabitaciones regi = new SistHabitaciones();
        regi.setVisible(true);
        regi.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioActionPerformed
        daoEmpleado.eliminarCodAuxiliar();
        dispose();
        Login1 emp = new Login1();
        emp.setVisible(true);
        emp.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCambioActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String dni = txtDNIBuscar.getText();
        boolean existe = daoC.clienteExists(dni);
        if (existe == true) {
            Cliente cli = daoC.clienteGetByDNI(dni);
            if (cli != null) {
                int npedidos = cli.getNhospedajes();
                npedidos++;
                cli.setNhospedajes(npedidos);
                if (npedidos > 0 && npedidos <= 3) {
                    cli.setSituacion("Regular");
                } else if (npedidos >= 4) {
                    cli.setSituacion("Asiduo");
                    descuentoTotal += 0.015;
                    double descuentoPorcentaje = descuentoTotal * 100;
                    String descuentoPorc = String.format("%.1f%%", descuentoPorcentaje);
                    txtdescuento.setText(descuentoPorc);
                }
                daoC.clienteUpd(cli);
                JOptionPane.showMessageDialog(this, "Cliente encontrado: " + cli.getApeCli() + ", "
                        + cli.getNomCli() + "\n" + "Realizó " + npedidos + " hospedajes hasta el momento");
                clientesEncontrados.add(cli);
                ClienteTextArea.add(cli);
                actualizarTextArea();
                txtDNIBuscar.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        String dni = txtDNI.getText();
        boolean existe = daoC.clienteExists(dni);
        if (existe == false) {
            if (!dnisClientes.contains(dni)) {
                dnisClientes.add(dni);

                String nombre = txtNombreCliente.getText();
                String apellido = txtApellido.getText();
                String celular = txtCelular.getText();
                String correo = txtCorreo.getText();

                Cliente clientet = new Cliente();
                clientet.setNomCli(nombre);
                clientet.setApeCli(apellido);
                clientet.setDni(dni);
                clientet.setNhospedajes(0);
                clientet.setNum_Celular(celular);
                clientet.setCorreo(correo);
                clientet.setSituacion("Nuevo");
                daoC.clienteIns(clientet);

                ClienteTextArea.add(clientet);
                actualizarTextArea();

                txtNombreCliente.setText("");
                txtApellido.setText("");
                txtCelular.setText("");
                txtCorreo.setText("");
                txtDNI.setText("");

                JOptionPane.showMessageDialog(null, "El cliente ha sido registrado con éxito");
            }
        } else {
            txtNombreCliente.setText("");
            txtApellido.setText("");
            txtCelular.setText("");
            txtCorreo.setText("");
            txtDNI.setText("");
            JOptionPane.showMessageDialog(null, "El cliente ya se encuentra registrado");
        }
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void actualizarTextArea() {
        txtCliente.setText("");
        for (Cliente clientesT : ClienteTextArea) {
            txtCliente.append(clientesT.getApeCli() + ", " + clientesT.getNomCli() + "\n");
        }
    }

    private void btnGenerarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarRegistroActionPerformed
        String fecha = txtFechaInicio.getText();
        String hora = txtHoraInicio.getText();
        double total = Double.parseDouble(txtTotal.getText());
        String descu = txtdescuento.getText();
        String horafp = jLabelHoraProceso.getText();
        SimpleDateFormat cambioFormato = new SimpleDateFormat("yyyy/MM/dd");
        String ffformateada = cambioFormato.format(DateFinal.getDate());
        registro.setEstado("Pendiente");
        registro.setFechaEntrada(fecha);
        registro.setFechaSalida(ffformateada);
        registro.setHora(hora);
        registro.setHorafp(horafp);
        registro.setDescuento(descu);
        registro.setTotal(total);
        daoR.registroIns(registro);
        int ultimoIDPedido = daoR.obtenerUltimoIDRegistro();
        int mesilla = Integer.parseInt(txtHabitacion.getText());
        daoH.insertarRelacionHabitacionR(mesilla, ultimoIDPedido);
        List<Integer> idsClientes = obtenerIDsClientes(dnisClientes);
        for (Integer idCliente : idsClientes) {
            boolean exito = daoR.insertarRelacion(ultimoIDPedido, idCliente);
            if (!exito) {
                System.out.println("Error al establecer la relación entre el registro y el cliente.");
            }
        }
        List<Integer> idsClientesB = obtenerIDsClientesB();
        for (Integer idCliente : idsClientesB) {
            boolean exito = daoR.insertarRelacion(ultimoIDPedido, idCliente);
            if (!exito) {
                System.out.println("Error al establecer la relación entre el registro y el cliente.");
            }
        }
        daoH.actualizarEstadoPorID(mesilla, "Ocupado");
        resetearListaDNI();
        JOptionPane.showMessageDialog(null, "El registro ha sido creado con éxito con el identificador ID Nº" + ultimoIDPedido);
    }//GEN-LAST:event_btnGenerarRegistroActionPerformed

    private void btnBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoletaActionPerformed
        int mesilla = Integer.parseInt(txtHabitacion.getText());
        int idP = daoH.obtenerIDRegistroPorIDHabitacion(mesilla);
        String diasB = "";
        String mesita = txtHabitacion.getText();
        String hora = horaInicio;
        String total = txtTotal.getText();
        String desc = txtdescuento.getText();
        String codEmp = txtEmpleado.getText();

        Registro pedido = daoR.registroGet(idP);
        String fechaString = pedido.getFechaSalida();
        String fechaStringDeInicio = pedido.getFechaEntrada();
        String fechaFin = fechaString;
        String fechaBOL = fechaStringDeInicio;
        try {
            SimpleDateFormat formatoFechaBaseDatos = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatoFechaApp = new SimpleDateFormat("yyyy/MM/dd");
            Date fechaBaseDatosI = formatoFechaBaseDatos.parse(fechaBOL);
            String fechaAppI = formatoFechaApp.format(fechaBaseDatosI);
            Date fechaI = formatoFechaApp.parse(fechaAppI);
            Date fechaBaseDatos = formatoFechaBaseDatos.parse(fechaFin);
            String fechaApp = formatoFechaApp.format(fechaBaseDatos);
            Date fechaF = formatoFechaApp.parse(fechaApp);
            Date fechaInicial = fechaI;
            Date fechaFinal = fechaF;
            long diferenciaEnMillisegundos = fechaFinal.getTime() - fechaInicial.getTime();
            long dias = diferenciaEnMillisegundos / (24 * 60 * 60 * 1000);
            diasB = Long.toString(dias);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        double descuentoV = 0.0;

        if (desc != null && !desc.isEmpty()) {
            String descSinPorcentaje = desc.replace("%", "");
            String cadenaConPunto = descSinPorcentaje.replace(",", ".");
            descuentoV = Double.parseDouble(cadenaConPunto) / 100;
        }

        double totalV = Double.parseDouble(total);
        double DescuentoTotal = totalV * descuentoV;
        double totalConDescuento = totalV - DescuentoTotal;
        double totIGV = totalConDescuento * 0.18;
        double base = totalConDescuento - totIGV;
        daoR.actualizarTotal(idP, totalConDescuento);

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas generar la boleta?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            BoletaView boleta = new BoletaView(diasB, totIGV, base, codEmp, idP, mesita, hora, total, desc, DescuentoTotal, totalConDescuento);
            boleta.setVisible(true);
        }
    }//GEN-LAST:event_btnBoletaActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int mesa = Integer.parseInt(txtHabitacion.getText());
        int idPUdp = daoH.obtenerIDRegistroPorIDHabitacion(mesa);
        if (idPUdp != 0) {
            String nuevoEstado = "Pendiente";
            String nuevaFecha = daoR.obtenerFechaEntradaPorIDRegistro(idPUdp);
            SimpleDateFormat cambioFormato = new SimpleDateFormat("yyyy/MM/dd");
            String ffformateada = cambioFormato.format(DateFinal.getDate());
            String nuevaHora = txtHoraInicio.getText();
            String horafp = txtHoraFinal.getText();
            double nuevoTotal = Double.parseDouble(txtTotal.getText());
            String nuevaDesc = txtdescuento.getText();
            try {
                Thread.sleep(1000);
                Registro pedidoActualizado = new Registro(idPUdp, nuevaFecha, ffformateada, nuevaHora, horafp, nuevaDesc, nuevoEstado, nuevoTotal);
                String mensaje = daoR.registroUpd(pedidoActualizado);
                Thread.sleep(1000);
                if (mensaje == null) {
                    registro.setEstado(nuevoEstado);
                    registro.setFechaEntrada(nuevaFecha);
                    registro.setFechaSalida(ffformateada);
                    registro.setHora(nuevaHora);
                    registro.setHorafp(horafp);
                    registro.setTotal(nuevoTotal);
                    registro.setDescuento(nuevaDesc);

                    List<Integer> idsClientes = obtenerIDsClientes(dnisClientes);

                    for (Integer idCliente : idsClientes) {
                        boolean exito = daoR.insertarRelacion(idPUdp, idCliente);
                        if (!exito) {
                            System.out.println("Error al establecer la relación entre el registro y el cliente.");
                        }
                    }

                    List<Integer> idsClientesB = obtenerIDsClientesB();

                    for (Integer idCliente : idsClientesB) {
                        boolean exito = daoR.insertarRelacion(idPUdp, idCliente);
                        if (!exito) {
                            System.out.println("Error al establecer la relación entre el registro y el cliente.");
                        }
                    }

                    String fechaAct = txtFechaInicio.getText();
                    SimpleDateFormat formAct = new SimpleDateFormat("yyyy/MM/dd");
                    String formActu = formAct.format(DateFinal.getDate());
                    try {
                        Date fechaInicialAct = cambioFormato.parse(fechaAct);
                        Date fechaFinalAct = cambioFormato.parse(formActu);
                        long diferenciaEnMillisegundosACT = fechaFinalAct.getTime() - fechaInicialAct.getTime();
                        long diasAct = diferenciaEnMillisegundosACT / (24 * 60 * 60 * 1000);
                        String diasStringAct = Long.toString(diasAct);
                        int diaC = Integer.parseInt(diasStringAct);
                        if (diaC == 1) {
                            EnviarCorreo(idPUdp);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Registro Actualizado");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "ERROR AL ACTUALIZAR", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed


    private void btnCalcularTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularTotalActionPerformed
        String fecha = txtFechaInicio.getText();
        SimpleDateFormat cambioFormato = new SimpleDateFormat("yyyy/MM/dd");
        String ffformateada = cambioFormato.format(DateFinal.getDate());
        try {
            Date fechaInicial = cambioFormato.parse(fecha);
            Date fechaFinal = cambioFormato.parse(ffformateada);
            long diferenciaEnMillisegundos = fechaFinal.getTime() - fechaInicial.getTime();
            long dias = diferenciaEnMillisegundos / (24 * 60 * 60 * 1000);
            txtDiasEstadia.setText(dias + " días");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calcularTotal();
    }//GEN-LAST:event_btnCalcularTotalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateFinal;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnBoleta;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalcularTotal;
    private javax.swing.JButton btnCambio;
    private javax.swing.JButton btnGenerarRegistro;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelHoraProceso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelImg;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextArea txtCliente;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDNIBuscar;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtDiasEstadia;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtHabitacion;
    private javax.swing.JTextField txtHoraFinal;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtdescuento;
    // End of variables declaration//GEN-END:variables
}
