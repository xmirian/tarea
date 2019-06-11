package util;

import controladores.Conexion;
import interfaces.WinControlTarjetas;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Rosary
 */
public class ReporteManager {

    private final Map parametros;
    private final String nombreReporte;
    private String pathReporte;
    private final Connection conexion;

    public ReporteManager(Map parametros, String nombreReporte) {
        this.parametros = parametros;
        this.nombreReporte = nombreReporte;
        conexion = Conexion.getConnection();
        obtenerPathReporte();
    }

    public void mostrarReportePdf() {
        JasperPrint print = generarReporte();

        try {

            if (print.getPages().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay nada que imprimir", "Atención", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JRViewer view = new JRViewer(print);
        JInternalFrame frmReporte = new JInternalFrame("Vista previa");
        frmReporte.setClosable(true);
        frmReporte.setResizable(true);
        frmReporte.setMaximizable(true);
        frmReporte.setIconifiable(true);
        frmReporte.setSize(700, 500);
        
        frmReporte.add(view);
        Formateador.setLocationCenter(frmReporte, WinControlTarjetas.escritorio);
        WinControlTarjetas.escritorio.add(frmReporte);
        frmReporte.setVisible(true);
    }

    private JasperPrint generarReporte() {
        try {
            JasperPrint pri = JasperFillManager.fillReport(pathReporte + nombreReporte, parametros, conexion);

            return pri;
        } catch (JRException ex) {
            return null;
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("en Reporte manager " + ex.getMessage());
            }
        }
    }

    private void obtenerPathReporte() {
        String uri = System.getProperty("user.dir") + "\\reports\\";
        if (uri.contains("home")) {
            uri = uri.replace("\\", "/");
        }
        pathReporte = uri;
    }
}
