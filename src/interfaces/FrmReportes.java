/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import controladores.factory.CFactory;
import controladores.factory.IActividad;
import java.util.HashMap;
import java.util.Map;
import util.DatosIni;
import util.Formateador;
import util.MyComboBoxModel;
import util.ReporteManager;
import util.Resultado;

/**
 *
 * @author Rosary
 */
public class FrmReportes extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmReportes
     */
    private final IActividad cActividad;
    private final MyComboBoxModel cbmActividad = new MyComboBoxModel();

    public FrmReportes() {
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

        jLabel1 = new javax.swing.JLabel();
        cboInformeDe = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cboActividad = new javax.swing.JComboBox();
        btnImprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("REPORTES");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Informe de");

        cboInformeDe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas las Tarjetas", "Tarjetas asistidas", "Tarjetas libres", "Tarjetas con deudas", "Tarjetas no asistidas" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Actividad");

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboInformeDe, 0, 259, Short.MAX_VALUE)
                            .addComponent(cboActividad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(btnImprimir)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboInformeDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        cargarActividades();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        Map parametros = new HashMap();
        parametros.put("idActividad", cbmActividad.getSelectedCodigo());
        ReporteManager reportero;
        switch (cboInformeDe.getSelectedIndex()) {
            case 0:
                reportero = new ReporteManager(parametros, "todasLasTarjetas.jasper");
                break;
            case 1:
                reportero = new ReporteManager(parametros, "tarjetasAsistidas.jasper");
                break;
            case 2:
                reportero = new ReporteManager(parametros, "tarjetasLibres.jasper");
                break;
            case 3:
                reportero = new ReporteManager(parametros, "tarjetasConDeudas.jasper");
                break;
            case 4:
                reportero = new ReporteManager(parametros, "tarjetasNoAsistidas.jasper");
                break;
            default:
                reportero = new ReporteManager(parametros, "todasLasTarjetas.jasper");
        }
        reportero.mostrarReportePdf();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void cargarActividades() {
        Resultado resultado = cActividad.listar();
        if (resultado.isCorrecto()) {
            cbmActividad.setData(resultado.getItemsCombo());
            cboActividad.setModel(cbmActividad);
            if (cboActividad.getItemCount() != 0) {
                cboActividad.setSelectedIndex(0);
            }
        } else {
            Formateador.mostrarMensajeError(resultado, this);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox cboActividad;
    private javax.swing.JComboBox cboInformeDe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}