package edu.uees.tutorias.notification;

import edu.uees.tutorias.domain.Estudiante;

public interface INotificador {
    void enviarNotificacion(Estudiante destinatario, String asunto, String mensaje);
}