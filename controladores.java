@RestController
@RequestMapping("/camiones")
public class CamionController {
    @Autowired
    private CamionService camionService;
    
    @PostMapping
    public ResponseEntity<Camion> registrarCamion(@Valid @RequestBody Camion camion) {
        Camion nuevoCamion = camionService.registrarCamion(camion);
        return ResponseEntity.ok(nuevoCamion);
    }
    
    @GetMapping("/ubicacion")
    public ResponseEntity<List<Camion>> buscarCamionesPorUbicacion(
        @RequestParam(required = false) String codigoPostal,
        @RequestParam(required = false) String patente
    ) {
        List<Camion> camiones = codigoPostal != null 
            ? camionService.obtenerCamionesPorUbicacion(codigoPostal)
            : camionRepository.findAll();
        return ResponseEntity.ok(camiones);
    }
}

@RestController
@RequestMapping("/paquetes")
public class PaqueteController {
    @Autowired
    private PaqueteService paqueteService;
    
    @PostMapping
    public ResponseEntity<Paquete> registrarPaquete(@Valid @RequestBody Paquete paquete) {
        Paquete nuevoPaquete = paqueteService.registrarPaquete(paquete);
        return ResponseEntity.ok(nuevoPaquete);
    }
}

@RestController
@RequestMapping("/rutas")
public class RutaController {
    @Autowired
    private RutaService rutaService;
    
    @GetMapping("/condiciones")
    public ResponseEntity<List<Ruta>> consultarCondicionesRutas(
        @RequestParam String codigoPostal
    ) {
        List<Ruta> rutas = rutaService.obtenerRutasPorCiudadOrigen(codigoPostal);
        return ResponseEntity.ok(rutas);
    }
}
