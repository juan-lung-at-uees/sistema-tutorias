package edu.uees.tutorias.notification;

import edu.uees.tutorias.domain.Estudiante;

public class EmailNotificador implements INotificador {
    @Override
    public void enviarNotificacion(Estudiante destinatario, String asunto, String mensaje) {
        // Lógica simulada de envío por SMTP
        System.out.println("Enviando Email a " + destinatario.getCorreo() + " - Asunto: " + asunto);
    }
}