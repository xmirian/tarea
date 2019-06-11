/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import controladores.factory.CFactory;
import controladores.factory.IActividad;
import entidades.Actividad;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import util.Accion;
import util.DatosIni;
import util.Formateador;
import util.MyAbstractTableModel;
import util.Resultado;

/**
 *
 * @author Rosary
 */
public class FrmActividades extends javax.swing.JInternalFrame {

    private final IActividad cActividad;
    private long accion;
    private final MyAbstractTableModel atm = new MyAbstractTableModel();
    private TableRowSorter<MyAbstractTableModel> sorter;

    public FrmActividades() {
        initComponents();
        int bd = DatosIni.getBd().equals("MySql") ? CFactory.MYSQL : CFactory.ACCESS;
        cActividad = CFactory.getCFactory(bd).getCActividad();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlg = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtOrganizador = new javax.swing.JTextField();
        txtLugar = new javax.swing.JTextField();
        txtFecha = new com.toedter.calendar.JDateChooser();
        txtValor = new javax.swing.JTextField();
        txtTotalTarjetas = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnAgregarActividad = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Nombre");

        jLabel2.setText("Organizador");

        jLabel3.setText("Lugar");

        jLabel4.setText("Fecha");

        jLabel5.setText("Valor");

        jLabel6.setText("Total Tarj.");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtOrganizador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOrganizadorKeyTyped(evt);
            }
        });

        txtLugar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLugarKeyTyped(evt);
            }
        });

        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorKeyTyped(evt);
            }
        });

        txtTotalTarjetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalTarjetasActionPerformed(evt);
            }
        });
        txtTotalTarjetas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalTarjetasKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOrganizador)
                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLugar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtValor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                .addComponent(txtTotalTarjetas, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtOrganizador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(txtTotalTarjetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Save.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dlgLayout = new javax.swing.GroupLayout(dlg.getContentPane());
        dlg.getContentPane().setLayout(dlgLayout);
        dlgLayout.setHorizontalGroup(
            dlgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(dlgLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        dlgLayout.setVerticalGroup(
            dlgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dlgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Actividades");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Actividad", "Organizado por", "Lugar", "Fecha", "Valor", "Total tarjetas"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        btnAgregarActividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.png"))); // NOI18N
        btnAgregarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActividadActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/remove.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarActividad)
                    .addComponent(btnEliminar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActividadActionPerformed
        // TODO add your handling code here:
        accion = Accion.REGISTRAR;
        limpiarDialogo();
        dlg.setTitle("Agregar actividad");
        verDialogo();
    }//GEN-LAST:event_btnAgregarActividadActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
        if(txtFecha.getDate()==null){
            JOptionPane.showMessageDialog(dlg, "Indique fecha", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        double valor;
        try {
            valor = Double.parseDouble(txtValor.getText());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(dlg, "Valor incorrecto.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        
        
        if(txtTotalTarjetas.getText().isEmpty()){
            JOptionPane.showMessageDialog(dlg, "Indique tarjetas.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (accion == Accion.REGISTRAR) {
            Actividad actividad = new Actividad();
            actividad.setFecha(txtFecha.getDate());
            actividad.setLugar(txtLugar.getText());
            actividad.setNombre(txtNombre.getText());
            actividad.setOrganizador(txtOrganizador.getText());
            actividad.setTotalTarjetas(Integer.parseInt(txtTotalTarjetas.getText()));
            actividad.setValor(valor);

            Resultado resultado = cActividad.registrar(actividad);
            if (resultado.isCorrecto()) {
                cargarTabla();
                dlg.dispose();
            } else {
                Formateador.mostrarMensajeError(resultado, this);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        cargarTabla();
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        Formateador.setMaxTamanio(txtNombre, 35, evt);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtOrganizadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOrganizadorKeyTyped
        // TODO add your handling code here:
        Formateador.setMaxTamanio(txtOrganizador, 30, evt);
    }//GEN-LAST:event_txtOrganizadorKeyTyped

    private void txtLugarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLugarKeyTyped
        // TODO add your handling code here:
        Formateador.setMaxTamanio(txtLugar, 45, evt);
    }//GEN-LAST:event_txtLugarKeyTyped

    private void txtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        Formateador.setMaxTamanio(txtValor, 10, evt);
    }//GEN-LAST:event_txtValorKeyTyped

    private void txtTotalTarjetasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalTarjetasKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTotalTarjetasKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dlg.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int id = Formateador.getItemSeleccionado(tabla);
        if (id != -1) {
            Resultado resultado = cActividad.eliminar(id);
            if (resultado.isCorrecto()) {
                cargarTabla();
            } else {
                Formateador.mostrarMensajeError(resultado, this);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtTotalTarjetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalTarjetasActionPerformed
        // TODO add your handling code here:
        btnGuardar.doClick();
    }//GEN-LAST:event_txtTotalTarjetasActionPerformed

    private void cargarTabla() {
        Resultado resultado = cActividad.listar();
        if (resultado.isCorrecto()) {
            String cabecera = "Id,Nombre,Organizador,Lugar,Fecha,Valor,Tot. Tarj.";
            atm.setData(resultado.getCache(), cabecera);
            tabla.setModel(atm);
            Formateador.redimensionar(tabla, cabecera, "0,300,180,200,80,70,70");
            sorter = new TableRowSorter<>(atm);
            tabla.setRowSorter(sorter);
        } else {
            Formateador.mostrarMensajeError(resultado, this);
        }
    }

    private void verDialogo() {
        dlg.pack();
        dlg.setModal(true);

        dlg.setLocationRelativeTo(this);
        dlg.setVisible(true);
    }

    private void limpiarDialogo() {
        txtFecha.setDate(null);
        txtLugar.setText("");
        txtNombre.setText("");
        txtOrganizador.setText("");
        txtTotalTarjetas.setText("");
        txtValor.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarActividad;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JDialog dlg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtLugar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOrganizador;
    private javax.swing.JTextField txtTotalTarjetas;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
