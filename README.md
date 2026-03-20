# Salvador Quispe - Spring Boot MongoDB API

API REST con Spring Boot 4.0.3 y MongoDB Atlas para gestión de componentes.

## Configuración

- **Base de datos**: MongoDB Atlas
- **Cluster**: Cluster0
- **Database**: componentes_db
- **Colección**: componentes
- **Puerto**: 8082

## Ejecutar

```bash
mvn clean install
mvn spring-boot:run
```

## Swagger UI

Documentación interactiva: **http://localhost:8082/swagger-ui.html**

## Endpoints

- `GET /componentes` - Todos los componentes
- `GET /componentes/{id}` - Por ID
- `GET /componentes/buscar?nombre={nombre}` - Buscar por nombre
- `GET /componentes/activos` - Solo activos
- `GET /componentes/categoria/{categoria}` - Por categoría
- `GET /componentes/marca/{marca}` - Por marca
- `GET /componentes/precio?min={min}&max={max}` - Por rango de precio
- `POST /componentes` - Crear
- `PUT /componentes/{id}` - Actualizar
- `DELETE /componentes/{id}` - Eliminar
- `PATCH /componentes/{id}/desactivar` - Desactivar

## Ejemplo JSON

```json
{
  "nombre": "Procesador Intel Core i7",
  "descripcion": "Procesador de 8 núcleos",
  "categoria": "Procesadores",
  "marca": "Intel",
  "modelo": "i7-12700K",
  "precio": 450.00,
  "stock": 25
}
```

