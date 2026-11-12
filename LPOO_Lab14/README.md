# GameStore — Sistema de inventario para una tienda de videojuegos

Spring Boot + JPA + MySQL + Thymeleaf + Bootstrap 5.

## Requisitos
- Java 17 o superior
- MySQL 8 instalado y con el servicio corriendo

## Configuración
1. Abre `src/main/resources/application.properties`.
2. Cambia `TU_PASSWORD_AQUI` por la contraseña de root de tu MySQL.
3. (Opcional) Crea la base de datos a mano. Si no lo haces, se crea sola:
```
CREATE DATABASE tienda CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

## Ejecutar
```
./mvnw spring-boot:run          (Git Bash, Mac y Linux)
mvnw.cmd spring-boot:run        (CMD de Windows)
```
Abre http://localhost:8080
La primera vez se cargan 8 videojuegos de ejemplo.

## Ver los datos en MySQL
```
USE tienda;
SELECT * FROM videojuego;
```

## Funciones
- Inventario con panel de resumen (títulos, unidades, valor del inventario y alertas de stock)
- Alta, edición y baja de videojuegos (con confirmación al eliminar)
- Registro de ventas: el botón **Vender** descuenta 1 unidad del stock
- Búsqueda por título o género y filtro por plataforma
- Validaciones en el formulario

## Rutas
| Ruta | Método | Qué hace |
|------|--------|----------|
| `/videojuegos` (`?q=`, `?plataforma=`) | GET | Inventario, búsqueda y filtro |
| `/nuevo` | GET | Formulario vacío |
| `/guardar` | POST | Crear |
| `/editar/{id}` | GET | Formulario con datos |
| `/actualizar` | POST | Actualizar |
| `/eliminar/{id}` | POST | Eliminar |
| `/vender/{id}` | POST | Registrar una venta |

## Estructura
```
model/        Videojuego, ResumenInventario, Catalogos
repository/   VideojuegoRepository
service/      VideojuegoService (CRUD, venta y resumen)
controller/   VideojuegoController
exception/    VideojuegoNoEncontradoException, StockInsuficienteException
config/       DatosIniciales (juegos de ejemplo)
templates/    videojuegos.html, formulario.html, fragments/layout.html
```
