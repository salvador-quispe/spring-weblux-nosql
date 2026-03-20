package apt.salvadorquispe.service;

import apt.salvadorquispe.model.Componente;
import apt.salvadorquispe.repository.ComponenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComponenteService {
    
    private final ComponenteRepository componenteRepository;
    
    public List<Componente> obtenerTodos() {
        return componenteRepository.findAll();
    }
    
    public Optional<Componente> obtenerPorId(String id) {
        return componenteRepository.findById(id);
    }
    
    public List<Componente> buscarPorNombre(String nombre) {
        return componenteRepository.findByNombreContainingIgnoreCase(nombre);
    }
    
    public List<Componente> obtenerActivos() {
        return componenteRepository.findByActivo(true);
    }
    
    public List<Componente> obtenerPorCategoria(String categoria) {
        return componenteRepository.findByCategoria(categoria);
    }
    
    public List<Componente> obtenerPorMarca(String marca) {
        return componenteRepository.findByMarca(marca);
    }
    
    public List<Componente> obtenerPorRangoPrecio(Double precioMin, Double precioMax) {
        return componenteRepository.findByPrecioBetween(precioMin, precioMax);
    }
    
    public Componente crear(Componente componente) {
        componente.setFechaCreacion(LocalDateTime.now());
        return componenteRepository.save(componente);
    }
    
    public Componente actualizar(String id, Componente componente) {
        return componenteRepository.findById(id)
            .map(componenteExistente -> {
                componenteExistente.setNombre(componente.getNombre());
                componenteExistente.setDescripcion(componente.getDescripcion());
                componenteExistente.setCategoria(componente.getCategoria());
                componenteExistente.setMarca(componente.getMarca());
                componenteExistente.setModelo(componente.getModelo());
                componenteExistente.setPrecio(componente.getPrecio());
                componenteExistente.setStock(componente.getStock());
                componenteExistente.setActivo(componente.getActivo());
                componenteExistente.setFechaActualizacion(LocalDateTime.now());
                return componenteRepository.save(componenteExistente);
            })
            .orElseThrow(() -> new RuntimeException("Componente no encontrado"));
    }
    
    public void eliminar(String id) {
        componenteRepository.deleteById(id);
    }
    
    public void desactivar(String id) {
        componenteRepository.findById(id)
            .map(componente -> {
                componente.setActivo(false);
                componente.setFechaActualizacion(LocalDateTime.now());
                return componenteRepository.save(componente);
            })
            .orElseThrow(() -> new RuntimeException("Componente no encontrado"));
    }
}
