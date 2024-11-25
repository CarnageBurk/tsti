// Repositorios
@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
    Ciudad findByCodigoPostal(String codigoPostal);
}

@Repository
public interface CamionRepository extends JpaRepository<Camion, Long> {
    Camion findByPatente(String patente);
    List<Camion> findByCiudadActual_CodigoPostal(String codigoPostal);
}

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Long> {
    List<Paquete> findByCiudadOrigen(Ciudad ciudad);
    List<Paquete> findByEstado(String estado);
}

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Long> {
    List<Ruta> findByCiudadOrigen(Ciudad ciudadOrigen);
}

// Servicios
@Service
public class CamionService {
    @Autowired
    private CamionRepository camionRepository;
    
    public Camion registrarCamion(Camion camion) {
        if (camionRepository.findByPatente(camion.getPatente()) != null) {
            throw new RuntimeException("Ya existe un camión con esta patente");
        }
        return camionRepository.save(camion);
    }
    
    public List<Camion> obtenerCamionesPorUbicacion(String codigoPostal) {
        return camionRepository.findByCiudadActual_CodigoPostal(codigoPostal);
    }
}

@Service
public class PaqueteService {
    @Autowired
    private PaqueteRepository paqueteRepository;
    
    public Paquete registrarPaquete(Paquete paquete) {
        // Validaciones de DNI, peso, etc.
        return paqueteRepository.save(paquete);
    }
}

@Service
public class RutaService {
    @Autowired
    private RutaRepository rutaRepository;
    @Autowired
    private CiudadRepository ciudadRepository;
    
    public List<Ruta> obtenerRutasPorCiudadOrigen(String codigoPostal) {
        Ciudad ciudadOrigen = ciudadRepository.findByCodigoPostal(codigoPostal);
        return rutaRepository.findByCiudadOrigen(ciudadOrigen);
    }
}
