# Consumo de APIs RESTful

Este proyecto consiste en una página web estática desarrollada para consumir y desplegar información de diversas APIs públicas mediante la arquitectura **REST**. Los datos se reciben en formato **JSON** y se presentan de forma dinámica en la interfaz principal (`index.html`).

🚀 **Demo en línea:** [Practica2_APIs en GitHub Pages](https://leodefaz367.github.io/Practica2_APIs/)

---

## 👥 Integrantes

- **Alexis Chasi**
- **Leonardo Defaz**
- **Anderson Estrada**

---

## 🛠️ Tecnologías Utilizadas

- **HTML5**: Estructura de la página web.
- **CSS3 / JavaScript**: Estilizado y manipulación del DOM.
- **Fetch API (Promises / Async-Await)**: Peticiones HTTP asíncronas para el consumo de servicios REST.

---

## ⚙️ Método de Petición HTTP

Para realizar las peticiones a las APIs se empleó la sintaxis `async/await` junto con la **Fetch API**, lo que permite manejar promesas de forma limpia y controlar posibles errores en la conexión:

```javascript
async function llamado() {
    try {
        const url = "[https://api.ejemplo.com/datos](https://api.ejemplo.com/datos)";
        const request = await fetch(url);
        
        if (!request.ok) {
            throw new Error(`Error HTTP! Estado: ${request.status}`);
        }
        
        const data = await request.json();
        // Procesamiento e inserción de datos en el DOM
    } catch (error) {
        console.error("Error durante la conexión:", error);
    }
}

llamado();
