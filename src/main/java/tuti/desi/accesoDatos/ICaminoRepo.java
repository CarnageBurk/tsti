package tuti.desi.accesoDatos;

import org.springframework.data.repository.CrudRepository;
import tuti.desi.entidades.Camino;
import java.util.List;

public interface ICaminoRepo extends CrudRepository<Camino, String> {
    List<Camino> findByCodigoPostal(int codigoPostal);
}
