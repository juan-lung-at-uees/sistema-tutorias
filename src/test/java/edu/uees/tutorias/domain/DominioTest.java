package edu.uees.tutorias.domain;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class DominioTest {

    @Test
    void testEstudiante() {
        Estudiante est = new Estudiante("1", "Juan", "juan@uees.edu.ec");
        assertEquals("Juan", est.getNombre());
        assertEquals("juan@uees.edu.ec", est.getCorreo());
    }

    @Test
    void testDocente() {
        Docente doc = new Docente("1", "Dr. Perez", "Matematicas");
        assertNotNull(doc);
    }

    @Test
    void testHorarioTutoria() {
        Docente doc = new Docente("1", "Dr. Perez", "Matematicas");
        HorarioTutoria horario = new HorarioTutoria("H1", doc, LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        
        assertTrue(horario.isDisponible());
        horario.ocupar();
        assertFalse(horario.isDisponible());
        
        Exception exception = assertThrows(IllegalStateException.class, horario::ocupar);
        assertEquals("El horario ya está ocupado.", exception.getMessage());
        
        horario.liberar();
        assertTrue(horario.isDisponible());
    }

    @Test
    void testReserva() {
        Estudiante est = new Estudiante("1", "Juan", "juan@uees.edu.ec");
        Docente doc = new Docente("1", "Dr. Perez", "Matematicas");
        HorarioTutoria horario = new HorarioTutoria("H1", doc, LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        Reserva reserva = new Reserva("R1", est, horario);

        assertEquals(EstadoReserva.PENDIENTE, reserva.getEstado());
        assertEquals(est, reserva.getEstudiante());
        
        reserva.confirmar();
        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
        assertFalse(horario.isDisponible());
        
        Exception exception = assertThrows(IllegalStateException.class, reserva::confirmar);
        assertEquals("Solo se pueden confirmar reservas pendientes.", exception.getMessage());
        
        reserva.cancelar();
        assertEquals(EstadoReserva.CANCELADA, reserva.getEstado());
        assertTrue(horario.isDisponible());
    }
}