// Modelo de Ciudad
@Entity
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String nombre;
    
    @Column(nullable = false, length = 4)
    private String codigoPostal;
    
    private String clima;
}

// Modelo de Camión
@Entity
public class Camion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String patente;
    
    @Column(nullable = false)
    private String marca;
    
    @Column(nullable = false)
    private Integer modelo;
    
    @ManyToOne
    @JoinColumn(name = "ciudad_id", nullable = false)
    private Ciudad ciudadActual;
    
    private String estado; // en espera/en viaje/cargando/detenido/mantenimiento
}

// Modelo de Paquete
@Entity
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Double peso;
    
    private boolean esFragil;
    
    @Column(nullable = false)
    private String dniRemitente;
    
    @Column(nullable = false)
    private String dniDestinatario;
    
    @ManyToOne
    @JoinColumn(name = "ciudad_origen_id", nullable = false)
    private Ciudad ciudadOrigen;
    
    @ManyToOne
    @JoinColumn(name = "ciudad_destino_id", nullable = false)
    private Ciudad ciudadDestino;
    
    private String estado; // pendiente/en viaje/entregado
}

// Modelo de Ruta
@Entity
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ciudad_origen_id", nullable = false)
    private Ciudad ciudadOrigen;
    
    @ManyToOne
    @JoinColumn(name = "ciudad_destino_id", nullable = false)
    private Ciudad ciudadDestino;
    
    private String identificador;
    private String estadoCalzada;
    private String estadoClima;
}
