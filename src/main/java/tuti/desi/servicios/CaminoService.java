package tuti.desi.servicios;

import tuti.desi.entidades.Camino;
import java.util.List;

public interface CaminoService {
    List<Camino> obtenerCaminosPorCodigoPostal(int codigoPostal);
}
