package edu.uees.tutorias.service;
import edu.uees.tutorias.domain.*;
import edu.uees.tutorias.notification.INotificador;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class ServicioReservasTest {
    
    // Stub (Clase de prueba) para aislar la dependencia de Notificación
    class SpyNotificador implements INotificador {
        boolean notificado = false;
        @Override
        public void enviarNotificacion(Estudiante destinatario, String asunto, String mensaje) {
            notificado = true;
        }
    }

    @Test
    void testConfirmarReserva() {
        SpyNotificador spyNotificador = new SpyNotificador();
        ServicioReservas servicio = new ServicioReservas(spyNotificador);
        
        Estudiante est = new Estudiante("1", "Juan", "juan@uees.edu.ec");
        Docente doc = new Docente("1", "Dr. Perez", "Matematicas");
        HorarioTutoria horario = new HorarioTutoria("H1", doc, LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        Reserva reserva = new Reserva("R1", est, horario);

        servicio.confirmarReserva(reserva);
        
        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
        assertTrue(spyNotificador.notificado, "El notificador debió haber sido llamado.");
    }
}