# Análisis del Dominio - Sistema de Gestión de Tutorías

## Parte 1. Análisis del Dominio
Identificación de objetos del dominio, responsabilidades, relaciones y reglas relevantes.

| Elemento / Clase candidata | Responsabilidad | Información relevante | Reglas / Colaboraciones |
| :--- | :--- | :--- | :--- |
| **Estudiante** | Solicitar tutorías, consultar historial y gestionar sus propias solicitudes. | id, 
ombre, correo, historialReservas | **Regla:** No puede tener dos reservas activas en el mismo horario.<br>**Colabora con:** Reserva, ServicioReservas. |
| **Docente** | Administrar (publicar/modificar) sus horarios disponibles y atender tutorías. | id, 
ombre, correo, especialidad | **Regla:** Los horarios publicados deben pertenecer a su especialidad.<br>**Colabora con:** HorarioTutoria. |
| **HorarioTutoria** | Representar una franja de tiempo ofertada por el docente, controlando si está ocupada. | id, echa, horaInicio, horaFin, disponible | **Regla:** Una vez asociado a una reserva confirmada, su estado disponible pasa a falso.<br>**Colabora con:** Docente, Reserva. |
| **Reserva** | Centralizar el ciclo de vida de la solicitud (Pendiente, Confirmada, Cancelada, Realizada). | id, estudiante, horario, estado, echaCreacion | **Regla:** Solo puede confirmarse si el HorarioTutoria está disponible.<br>**Colabora con:** Estudiante, HorarioTutoria, Notificador. |
| **Notificador (Abstracción)** | Aislar la lógica de comunicación para enviar avisos de los eventos del sistema. | destinatario, mensaje, sunto | **Regla:** Se dispara automáticamente ante cambios de estado en una Reserva (ej. Confirmación o Cancelación).<br>**Colabora con:** Reserva / ServicioReservas. |

