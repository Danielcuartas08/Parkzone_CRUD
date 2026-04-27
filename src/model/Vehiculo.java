package model;

public class Vehiculo {
    private int idvehiculo;
    private String placa;
    private String tipo;
    private int idpersona;

    // Constructor vacío
    public Vehiculo() {
    }

    // Constructor con parámetros
    public Vehiculo(int idvehiculo, String placa, String tipo, int idpersona) {
        this.idvehiculo = idvehiculo;
        this.placa = placa;
        this.tipo = tipo;
        this.idpersona = idpersona;
    }

    // Getters y Setters corregidos
    public int getidvehiculo() { 
        return idvehiculo; 
    }
    
    public void setidvehiculo(int idvehiculo) { 
        this.idvehiculo = idvehiculo; 
    }

    public String getplaca() { 
        return placa; 
    }
    
    public void setplaca(String placa) { 
        this.placa = placa; 
    }

    public String gettipo() { 
        return tipo; 
    }
    
    public void settipo(String tipo) { 
        this.tipo = tipo; 
    }

    public int getidpersona() { 
        return idpersona; 
    }
    
    public void setidpersona(int idpersona) { 
        this.idpersona = idpersona; 
    }
}