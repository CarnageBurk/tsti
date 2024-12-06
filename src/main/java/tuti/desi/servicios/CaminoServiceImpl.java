package tuti.desi.servicios;

import tuti.desi.accesoDatos.ICaminoRepo;
import tuti.desi.entidades.Camino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CaminoServiceImpl implements CaminoService {

    @Autowired
    private ICaminoRepo caminoRepo;
    @Override
    public List<Camino> obtenerCaminosPorCodigoPostal(int codigoPostal) {
        return caminoRepo.findByCodigoPostal(codigoPostal);
    }
}
