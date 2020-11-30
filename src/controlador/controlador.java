/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

public class controlador implements ActionListener {
    
    private Conexion con;
    private Principal principal;
    private busqueda busqueda;
    
    public controlador(Conexion con) {//
        this.con = con;
        principal = new Principal();
    }
    
     public void ejecutar() {
        principal.setControlador(this);
        principal.ejecutar();

    }
     
     @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(principal.WASHINGTON)) {
            busqueda = new busqueda("WASHI");
            busqueda.setControlador(this);
            busqueda.setNivel(3);
            busqueda.ejecutar();
        }
        if (e.getActionCommand().equals(principal.SANFER)) {
            busqueda = new busqueda("SANFERNANDO");
            busqueda.setControlador(this);
            busqueda.ejecutar();
            
        }
        if (e.getActionCommand().equals(principal.SANTO)) {
            busqueda = new busqueda("SANTO_DOM");
            busqueda.setControlador(this);
            busqueda.ejecutar();
            
        }
        if (e.getActionCommand().equals(principal.NORTE)) {
            busqueda = new busqueda("NORT_ARG");
            busqueda.setControlador(this);
            busqueda.setNivel(4);
            busqueda.ejecutar();
            
        }
        if (e.getActionCommand().equals(principal.ANEXO)) {
            busqueda = new busqueda("ANEXO");
            busqueda.setControlador(this);
            busqueda.setNivel(4);
            busqueda.ejecutar();
            
        }
        if (e.getActionCommand().equals(principal.FAMAILLA)) {
            busqueda = new busqueda("FAMAILLA");
            busqueda.setControlador(this);
            busqueda.setNivel(4);
            busqueda.ejecutar();
          
            
        }
        
        if (e.getActionCommand().equals(principal.SECUNDARIO)) {
            busqueda = new busqueda("IPEFSECU");
            busqueda.setTitle("IPEF SECUNDARIO");
            busqueda.setControlador(this);
            busqueda.setNivel(3);
            busqueda.ejecutar();
            
            
            
        }
        
        if (e.getActionCommand().equals(busqueda.FILTRAR)) {
                
            double totalPagos=0;
            int lineas = 0;
            
            consulta c = new consulta(busqueda.getInstitucion(),busqueda.getNivel(),
                    busqueda.getDesde(),busqueda.getHasta(),busqueda.getConcepto());
            
            consultaDAO cd = new consultaDAO(con, c);
            
          
        ArrayList<String[]> lista = new ArrayList<String[]>();
        for (Pago p : cd.leer()) {
            String linea[] = new String[10];
            linea[0] = p.getRecibo();
            linea[1] = "" + p.getConcepto();
            linea[2] = "" + p.getCajero();
            linea[3] = "" + p.getFechaCobro();
            linea[4] = "" + p.getLegajo();
            linea[5] = "" + p.getFormapago();
            linea[6] = "" + p.getAnio();
            linea[7] = "" + p.getNivel();
            linea[8] = "" + p.getCurso();
            linea[9] = "" + p.getSupago();
            lista.add(linea);
            
            totalPagos=totalPagos + p.getSupago();
            lineas++;
        }
        busqueda.cargarListaPagos(lista);
        
        busqueda.setTotal(totalPagos);
        busqueda.setTotalLineas(lineas);
         
        }
    }
    
}
