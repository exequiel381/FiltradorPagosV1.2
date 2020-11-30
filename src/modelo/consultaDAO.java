/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author GW-03
 */
public class consultaDAO {
    
    private Conexion con;
    private consulta c;
    
    public consultaDAO(Conexion con,consulta consulta)
    {
        this.con=con;
        this.c=consulta;
    }
    
    public ArrayList<Pago> leer(){
        ArrayList<Pago> lista = new ArrayList<Pago>();
        try{
            
            String concepto="";
            String cursos="";
            String sql="";
            
            concepto = this.obtenerConcepto();

            if(c.getInstitucion().equals("NORT_ARG"))
            {
                String nivel;
                
                if(c.getNivel().equalsIgnoreCase("TODOS"))
                {
                    nivel="";
                }else nivel = " and c.nivel='"+c.getNivel()+"' ";
                
                cursos= " and p.curso not like '%M' and p.curso not like '%D'";
                 
                sql =  "SELECT p.n_recibo,p.concepto,p.cobro,p.fechacobro,p.legajo,p.curso,p.formapago,p.anio,p.supago,c.nivel,c.codigo,p.codrelacional "
                    + "FROM caja_pagos as p , caja_cuentas as c "
                    + "WHERE c.codigo=p.codrelacional "
                    + "and p.fechacobro<='"+c.getHasta()+"' "
                    + "and p.fechacobro >='"+c.getDesde()+"' " 
                    //+ "and c.nivel='"+c.getNivel()+"' "
                    + "and p.anulada='NO' "
                    + "and p.institucion='"+c.getInstitucion()+"' "+concepto+cursos+nivel;
              
            }
            if(c.getInstitucion().equals("ANEXO"))
            {
                String nivel;
                
                if(c.getNivel().equalsIgnoreCase("TODOS"))
                {
                    nivel="";
                }else nivel = " and c.nivel='"+c.getNivel()+"' ";
                
                c.setInstitucion("NORT_ARG");
                cursos=" and (p.curso='TER-4.D' or p.curso='TER-3.D' or p.curso='TER-2.D' or p.curso='TER-1.D' )";
                
                sql =  "SELECT p.n_recibo,p.concepto,p.cobro,p.fechacobro,p.legajo,p.curso,p.formapago,p.anio,p.supago,c.nivel,c.codigo,p.codrelacional "
                    + "FROM caja_pagos as p , caja_cuentas as c "
                    + "WHERE c.codigo=p.codrelacional "
                    + "and p.fechacobro<='"+c.getHasta()+"' "
                    + "and p.fechacobro >='"+c.getDesde()+"' " 
                    //+ "and c.nivel='"+c.getNivel()+"' "
                    + "and p.anulada='NO' "
                    + "and p.institucion='"+c.getInstitucion()+"' "+concepto+cursos+nivel;
                
                
            }
            if(c.getInstitucion().equals("FAMAILLA"))
            {
                String nivel;
                
                if(c.getNivel().equalsIgnoreCase("TODOS"))
                {
                    nivel="";
                }else nivel = " and c.nivel='"+c.getNivel()+"' ";
                
                c.setInstitucion("NORT_ARG");
                cursos=" and (p.curso='TER-4.M' OR p.curso='TER-3.M' or p.curso='TER-2.M' or p.curso='TER-1.M')";
                
                sql =  "SELECT p.n_recibo,p.concepto,p.cobro,p.fechacobro,p.legajo,p.curso,p.formapago,p.anio,p.supago,c.nivel,c.codigo,p.codrelacional "
                    + "FROM caja_pagos as p , caja_cuentas as c "
                    + "WHERE c.codigo=p.codrelacional "
                    + "and p.fechacobro<='"+c.getHasta()+"' "
                    + "and p.fechacobro >='"+c.getDesde()+"' " 
                    //+ "and c.nivel='"+c.getNivel()+"' "
                    + "and p.anulada='NO' "
                    + "and p.institucion='"+c.getInstitucion()+"' "+concepto+cursos+nivel;
               
            }
            
            if(c.getInstitucion().equals("WASHI"))
            {
                String nivel;
                
                if(c.getNivel().equalsIgnoreCase("TODOS"))
                {
                    nivel="";
                }else nivel = " and c.nivel='"+c.getNivel()+"' ";
                
              sql =  "SELECT p.n_recibo,p.concepto,p.cobro,p.fechacobro,p.legajo,p.curso,p.formapago,p.anio,p.supago,c.nivel,c.codigo,p.codrelacional "
                    + "FROM caja_pagos as p , caja_cuentas as c "
                    + "WHERE c.codigo=p.codrelacional "
                    + "and p.fechacobro<='"+c.getHasta()+"' "
                    + "and p.fechacobro >='"+c.getDesde()+"' " 
                    //+ "and c.nivel='"+c.getNivel()+"' "
                    + "and p.anulada='NO' "
                    + "and p.institucion='"+c.getInstitucion()+"' "+concepto+nivel;
               
            }
            
            if(c.getInstitucion().equals("SANFERNANDO"))
            {
                String nivel;
                
                if(c.getNivel().equalsIgnoreCase("TODOS"))
                {
                    nivel="";
                }else nivel = " and c.nivel='"+c.getNivel()+"' ";
                
                sql =  "SELECT p.n_recibo,p.concepto,p.cobro,p.fechacobro,p.legajo,p.curso,p.formapago,p.anio,p.supago,c.nivel,c.codigo,p.codrelacional "
                    + "FROM caja_pagos as p , caja_cuentas as c "
                    + "WHERE c.codigo=p.codrelacional "
                    + "and p.fechacobro<='"+c.getHasta()+"' "
                    + "and p.fechacobro >='"+c.getDesde()+"' " 
                    //+ "and c.nivel='"+c.getNivel()+"' "
                    + "and p.anulada='NO' "
                    + "and p.institucion='"+c.getInstitucion()+"' "+concepto+nivel;
               
            }
            
            if(c.getInstitucion().equals("SANTO_DOM"))
            {
                String nivel;
                
                if(c.getNivel().equalsIgnoreCase("TODOS"))
                {
                    nivel="";
                }else nivel = " and c.nivel='"+c.getNivel()+"' ";
                
                sql =  "SELECT p.n_recibo,p.concepto,p.cobro,p.fechacobro,p.legajo,p.curso,p.formapago,p.anio,p.supago,c.nivel,c.codigo,p.codrelacional "
                    + "FROM caja_pagos as p , caja_cuentas as c "
                    + "WHERE c.codigo=p.codrelacional "
                    + "and p.fechacobro<='"+c.getHasta()+"' "
                    + "and p.fechacobro >='"+c.getDesde()+"' " 
                    //+ "and c.nivel='"+c.getNivel()+"' "
                    + "and p.anulada='NO' "
                    + "and p.institucion='"+c.getInstitucion()+"' "+concepto+nivel;
            }
            
            if(c.getInstitucion().equals("IPEFSECU"))
            {
                String nivel;
                
                if(c.getNivel().equalsIgnoreCase("TODOS"))
                {
                    nivel="";
                }else nivel = " and c.nivel='"+c.getNivel()+"' ";
                
               sql =  "SELECT p.n_recibo,p.concepto,p.cobro,p.fechacobro,p.legajo,p.curso,p.formapago,p.anio,p.supago,c.nivel,c.codigo,p.codrelacional "
                    + "FROM caja_pagos as p , caja_cuentas as c "
                    + "WHERE c.codigo=p.codrelacional "
                    + "and p.fechacobro<='"+c.getHasta()+"' "
                    + "and p.fechacobro >='"+c.getDesde()+"' " 
                    //+ "and c.nivel='"+c.getNivel()+"' "
                    + "and p.anulada='NO' "
                    + "and p.institucion='"+c.getInstitucion()+"' "+concepto+nivel;
                
            }
            
            
            ResultSet fila = con.getConsulta().executeQuery(sql);
            while(fila.next()){
                
                Pago tmp = new Pago();
                tmp.setRecibo(fila.getString("p.n_recibo"));
                tmp.setConcepto(fila.getString("p.concepto"));
                tmp.setCajero(fila.getString("p.cobro"));
                tmp.setFechaCobro(fila.getString("p.fechacobro"));
                tmp.setLegajo(fila.getString("p.legajo"));
                tmp.setCurso(fila.getString("p.curso"));
                tmp.setFormapago(fila.getString("p.formapago"));
                tmp.setAnio(fila.getInt("p.anio"));
                tmp.setNivel(fila.getString("c.nivel"));
                tmp.setCurso(fila.getString("p.curso"));
                try{
                   tmp.setSupago(fila.getDouble("supago")); 
                }catch(Exception q)
                {
                   String pago = fila.getString("supago");
                   String pago2= pago.replaceAll(",",".");
                   
                   tmp.setSupago(Double.parseDouble(pago2));//SI LLEGA ES POR HABIA UN PAGO CON " , " TENGO QUE BUSCAR COMO PASAR A DOUBLE ESOS NUMEROS
                                    // PUEDO PASARLO A STRING, REEMPLAZAR LA COMA Y VOLVER A PARSEAR A DOUBLE
                }
                
                
                
                lista.add(tmp);
                
            }
            return lista;
        }
        catch(SQLException e){
            System.out.println(e);
        }    
        
        return null;
    }
    
    public void LeerIpefSecu(){
        
    }
    
    public void LeerAnexo(){
        
    }
    public void LeerFamailla(){
        
    }
    
    public void LeerSantoDomingo(){
        
    }
    
    public void LeerSanFernando(){
        
    }
    
    public void LeerWashington(){
        
    }
    
    public String obtenerConcepto()
    {
        String concepto="";
        
        if(c.getConcepto().equals("MATRICULA"))
            {
                concepto=" and p.concepto like '%MATRICULA%'";
            }
            
            if(c.getConcepto().equals("SEGURO"))
            {
                concepto=" and p.concepto like '%SEGURO%'";
            }
            
            if(c.getConcepto().equals("CUOTAS"))
            {
                concepto=" and (p.concepto = 'MARZO' OR p.concepto = 'ABRIL' OR p.concepto = 'MAYO' OR p.concepto = 'JUNIO' OR p.concepto = 'JULIO'"
                        +" OR p.concepto = 'AGOSTO' OR p.concepto = 'SEPTIEMBRE' OR p.concepto = 'OCTUBRE' OR p.concepto = 'NOVIEMBRE' OR p.concepto = 'DICIEMBRE')";
            }
            
            if(c.getConcepto().equals("OTROS"))
            {
                concepto=" and p.concepto not like '%SEGURO%' and p.concepto not like '%MATRICULA%' and p.concepto not like '%MARZO%'"
                        + "and p.concepto not like '%ABRIL%' and p.concepto not like '%MAYO%'"
                        + "and p.concepto not like '%JUNIO%' and p.concepto not like '%JULIO%'"
                        + "and p.concepto not like '%AGOSTO%' and p.concepto not like '%SEPTIEMBRE%'"
                        + "and p.concepto not like '%OCTUBRE%' and p.concepto not like '%NOVIEMBRE%' and p.concepto not like '%DICIEMBRE%'";
            }
            
        
        
        return concepto;
    }
}
