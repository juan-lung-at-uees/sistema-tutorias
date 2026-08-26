# Sistema de Gestión de Tutorías

## Propósito del Proyecto
Este proyecto implementa el modelo inicial de un Sistema de gestión de tutorías aplicando principios de diseño orientado a objetos (OO), patrones arquitectónicos básicos (SOLID), cohesión/acoplamiento y herramientas modernas (Java 21, Maven, Git, JUnit).

## Descripción del Problema
El sistema requiere gestionar encuentros académicos (tutorías) asegurando que los **Estudiantes** puedan solicitar espacios ofertados por **Docentes** mediante franjas de **Horarios** validadas. El ciclo de vida está gobernado por una **Reserva** que no permite cruces y requiere confirmaciones precisas, notificando a las partes interesadas.

## Clases Principales y Responsabilidades
- **Estudiante / Docente:** Actores principales con datos de identidad encapsulados.
- **HorarioTutoria:** Representa una franja de tiempo y controla autónomamente su propia disponibilidad (ocupar/liberar).
- **Reserva:** Centraliza la lógica de negocio (confirmar/cancelar) impidiendo transiciones de estado ilegales.
- **ServicioReservas:** Orquesta el flujo de alto nivel aislando el dominio.
- **INotificador:** Abstracción para aislar el envío de avisos.

## Decisiones de Diseño Relevantes
- Se evitó el antipatrón del modelo de clases anémicas: las reglas de negocio viven estrictamente dentro de las entidades (por ejemplo, 
eserva.confirmar()).
- Se utilizó una estructura de paquetes limpia separando domain, service y 
otification.

## Principios SOLID Aplicados
- **Principio de Inversión de Dependencia (Dependency Inversion Principle, DIP):** ServicioReservas depende de la abstracción INotificador, y no de implementaciones de correo concretas.
- **Principio de Responsabilidad Simple (Single Responsibility Principle, SRP):** Cada clase tiene un único motivo para cambiar. La entidad de reserva maneja estados, el servicio coordina flujos, y el notificador comunica eventos de infraestructura.

## Diagrama UML
El diagrama UML descriptivo en formato PlantUML se encuentra en la carpeta doc/modelo-clases.puml.

## Requisitos para Ejecutar
- Java 21 o superior
- Maven 3.6+
- Git

## Comandos de Compilación y Pruebas
Para limpiar y compilar el proyecto garantizando el estado del código base:
```bash
mvn clean compile
```
Para ejecutar la suite de pruebas unitarias (JUnit 5):
```bash
mvn clean test
```

## Declaración de Uso de IA
Se declara el uso de asistentes de IA (Gemini) como herramienta de apoyo para el análisis arquitectónico, estructuración del proyecto Maven, generación de scripts para automatización y validación de sintaxis técnica, manteniendo la autoría, revisión y comprensión total sobre las decisiones de diseño implementadas en el código por parte del estudiante.