package apt.salvadorquispe.rest;

import apt.salvadorquispe.model.Componente;
import apt.salvadorquispe.service.ComponenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/componentes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Componentes", description = "API para gestión de componentes")
public class ComponenteController {
    
    private final ComponenteService componenteService;
    
    @GetMapping
    @Operation(summary = "Obtener todos los componentes")
    public ResponseEntity<List<Componente>> obtenerTodos() {
        return ResponseEntity.ok(componenteService.obtenerTodos());
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener componente por ID")
    public ResponseEntity<Componente> obtenerPorId(@PathVariable String id) {
        return componenteService.obtenerPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/buscar")
    @Operation(summary = "Buscar componentes por nombre")
    public ResponseEntity<List<Componente>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(componenteService.buscarPorNombre(nombre));
    }
    
    @GetMapping("/activos")
    @Operation(summary = "Obtener componentes activos")
    public ResponseEntity<List<Componente>> obtenerActivos() {
        return ResponseEntity.ok(componenteService.obtenerActivos());
    }
    
    @GetMapping("/categoria/{categoria}")
    @Operation(summary = "Obtener componentes por categoría")
    public ResponseEntity<List<Componente>> obtenerPorCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(componenteService.obtenerPorCategoria(categoria));
    }
    
    @GetMapping("/marca/{marca}")
    @Operation(summary = "Obtener componentes por marca")
    public ResponseEntity<List<Componente>> obtenerPorMarca(@PathVariable String marca) {
        return ResponseEntity.ok(componenteService.obtenerPorMarca(marca));
    }
    
    @GetMapping("/precio")
    @Operation(summary = "Obtener componentes por rango de precio")
    public ResponseEntity<List<Componente>> obtenerPorRangoPrecio(
            @RequestParam Double min,
            @RequestParam Double max) {
        return ResponseEntity.ok(componenteService.obtenerPorRangoPrecio(min, max));
    }
    
    @PostMapping
    @Operation(summary = "Crear nuevo componente")
    public ResponseEntity<Componente> crear(@Valid @RequestBody Componente componente) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(componenteService.crear(componente));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar componente")
    public ResponseEntity<Componente> actualizar(
            @PathVariable String id,
            @Valid @RequestBody Componente componente) {
        try {
            return ResponseEntity.ok(componenteService.actualizar(id, componente));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar componente")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        componenteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    
    @PatchMapping("/{id}/desactivar")
    @Operation(summary = "Desactivar componente")
    public ResponseEntity<Void> desactivar(@PathVariable String id) {
        try {
            componenteService.desactivar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
