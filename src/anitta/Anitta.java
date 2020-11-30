/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anitta;

import controlador.controlador;
import modelo.Conexion;

/**
 *
 * @author GW-03
 */
public class Anitta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Conexion con = new Conexion();
        
        if(con.conectar()>0){
            controlador control = new controlador(con);
            control.ejecutar();
        }
        }
    }
    