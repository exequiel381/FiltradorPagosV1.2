/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author GW-03
 */
public class consulta {
    
    private String institucion;
    private String nivel;
    private String desde;
    private String hasta;
    private String concepto;
    private String curso;
    
    public consulta(String institucion,String nivel,String desde,String hasta,String concepto)
    {
        this.desde=desde;
        this.hasta=hasta;
        this.nivel=nivel;
        this.institucion=institucion;
        this.concepto=concepto;
        
        
    }
    
    public consulta(String nivel,String desde,String hasta)
    {
        this.desde=desde;
        this.hasta=hasta;
        this.nivel=nivel;
        
        
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    
    

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }
    
    
}
