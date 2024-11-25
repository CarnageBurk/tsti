// Validaciones personalizadas
public class ValidacionesPersonalizadas {
    public static boolean validarDNI(String dni) {
        return dni != null && dni.matches("\\d{8}");
    }
    
    public static boolean validarPatente(String patente) {
        // Ejemplo de formato de patente argentina
        return patente != null && patente.matches("[A-Z]{2}\\d{3}[A-Z]{2}");
    }
}

// Ejemplo de validación en modelo
public class Paquete {
    @AssertTrue(message = "DNI de remitente inválido")
    public boolean isDniRemitenteValido() {
        return ValidacionesPersonalizadas.validarDNI(dniRemitente);
    }
}

// Script de inicialización de base de datos
# src/main/resources/data.sql
INSERT INTO ciudad (nombre, codigo_postal, clima) VALUES 
('Buenos Aires', '1000', 'Soleado'),
('Córdoba', '5000', 'Despejado'),
('Rosario', '2000', 'Nublado');

INSERT INTO camion (patente, marca, modelo, ciudad_actual_id) VALUES 
('AA123BB', 'Mercedes', 2020, 1),
('CC456DD', 'Volvo', 2019, 2);
