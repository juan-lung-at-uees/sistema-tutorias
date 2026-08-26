package edu.uees.tutorias.service;

import edu.uees.tutorias.domain.Reserva;
import edu.uees.tutorias.notification.INotificador;

public class ServicioReservas {
    private final INotificador notificador;

    // Inyección de dependencias mediante constructor (DIP)
    public ServicioReservas(INotificador notificador) {
        this.notificador = notificador;
    }

    public void confirmarReserva(Reserva reserva) {
        reserva.confirmar(); // Delega regla de dominio a la entidad
        notificador.enviarNotificacion(
            reserva.getEstudiante(),
            "Reserva Confirmada",
            "Su tutoría ha sido confirmada con éxito."
        );
    }
}