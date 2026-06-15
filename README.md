# Sistema de Gestión de Inventario - CRUD JavaFX

## Descripción
Sistema de escritorio robusto y modular diseñado para la gestión de productos de inventario. El sistema permite administrar productos mediante una interfaz gráfica intuitiva, garantizando la integridad de los datos y una navegación fluida entre secciones.

## Captura del Dashboard
![Dashboard del Sistema](inserte_link_o_ruta_de_su_imagen.png)

## Tecnologías Utilizadas
* **Lenguaje:** Java 17+
* **Interfaz Gráfica:** JavaFX 21
* **Gestión de dependencias:** Apache Maven
* **Patrón de diseño:** MVC (Modelo-Vista-Controlador)
* **Herramienta de UI:** Scene Builder

## Funcionalidades
* **CRUD Completo:** Creación, lectura, actualización y eliminación de productos.
* **Validaciones:** Control de duplicidad mediante código, validación de tipos numéricos y campos obligatorios.
* **Búsqueda Inteligente:** Filtro en tiempo real para localizar productos rápidamente.
* **Arquitectura Escalable:** Carga dinámica de vistas FXML dentro de un contenedor central (`BorderPane`).
* **Tabla Dinámica:** `TableView` enlazada a `ObservableList` para actualización automática de la interfaz.

## Estructura del Proyecto
```text
CrudInterfaz/
├── .idea/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/example/crudinterfaz/
│   │   │       ├── Main.java
│   │   │       ├── AdministradorController.java
│   │   │       ├── ProductosController.java
│   │   │       └── Producto.java
│   │   └── resources/
│   │       └── org/example/crudinterfaz/
│   │           ├── administrador.fxml
│   │           └── productos.fxml
├── target/                # (Ignorar: archivos compilados)
└── pom.xml                # (Archivo de configuración de Maven)
