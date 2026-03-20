package apt.salvadorquispe.repository;

import apt.salvadorquispe.model.Componente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponenteRepository extends MongoRepository<Componente, String> {
    
    List<Componente> findByActivo(Boolean activo);
    
    List<Componente> findByCategoria(String categoria);
    
    List<Componente> findByNombreContainingIgnoreCase(String nombre);
    
    List<Componente> findByMarca(String marca);
    
    List<Componente> findByPrecioBetween(Double precioMin, Double precioMax);
}
