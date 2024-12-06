package tuti.desi.presentacion;

import tuti.desi.servicios.CaminoService;
import tuti.desi.entidades.Camino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/caminosBuscar")
public class CaminosBuscarController {

    @Autowired
    private CaminoService caminoService;

    @GetMapping
    public String mostrarPagina() {
        return "caminosBuscar";
    }
    
    @GetMapping("/resultados")
    public String listarResultados(
            @RequestParam(name = "codigoPostal") Integer codigoPostal,
            Model model) {
        List<Camino> caminos = caminoService.obtenerCaminosPorCodigoPostal(codigoPostal);
        if (caminos.isEmpty()) {
        	model.addAttribute("mensajeError", "No se encontraron caminos para el código postal proporcionado.");
        } else {
        	model.addAttribute("caminos", caminos);
        }
        return "caminosBuscar";
    }
}
