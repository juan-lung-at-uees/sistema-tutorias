package edu.uees.tutorias.notification;
import edu.uees.tutorias.domain.Estudiante;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class EmailNotificadorTest {
    @Test
    void testEnviarNotificacion() {
        EmailNotificador notificador = new EmailNotificador();
        Estudiante est = new Estudiante("1", "Juan", "juan@uees.edu.ec");
        // Solo verificamos que la implementación por defecto no lance excepciones
        assertDoesNotThrow(() -> notificador.enviarNotificacion(est, "Test", "Mensaje de prueba"));
    }
}