package apt.salvadorquispe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "componentes")
public class Componente {
    
    @Id
    private String id;
    
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
    
    private String categoria;
    
    private String marca;
    
    private String modelo;
    
    @Positive(message = "El precio debe ser mayor a 0")
    private Double precio;
    
    @Positive(message = "El stock debe ser mayor a 0")
    private Integer stock;
    
    private Boolean activo = true;
    
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    
    private LocalDateTime fechaActualizacion;
}
