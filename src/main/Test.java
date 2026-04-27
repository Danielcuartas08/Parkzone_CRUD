package main;

import dao.VehiculoDAO;
import model.Vehiculo;

public class Test {
    public static void main(String[] args) {
        // 1. Instanciamos el DAO que contiene la lógica SQL
        VehiculoDAO vDAO = new VehiculoDAO();

        // 2. Creamos el objeto Vehiculo
        // IMPORTANTE: Como es Auto Increment, el primer parámetro (idvehiculo) 
        // se envía en 0 o cualquier número, ya que el DAO lo ignorará en el INSERT.
        Vehiculo vPrueba = new Vehiculo(0, "GTR-2026", "Deportivo", 1); 

        System.out.println(">>> Iniciando registro en Parkzone...");

        // 3. Ejecutamos la inserción
        if (vDAO.insertar(vPrueba)) {
            System.out.println("✅ ¡ÉXITO! Vehículo registrado correctamente.");
            
            // 4. Listamos para verificar que aparezca con su nuevo ID automático
            System.out.println("\n>>> Lista actualizada de vehículos:");
            for (Vehiculo v : vDAO.listar()) {
                System.out.println("ID Generado: " + v.getidvehiculo() + 
                                   " | Placa: " + v.getplaca() + 
                                   " | Tipo: " + v.gettipo());
            }
        } else {
            System.out.println("❌ Error en la prueba. Revisa la consola de salida.");
        }
    }
}