package edu.uees.tutorias.domain;
import java.time.LocalDateTime;

public class HorarioTutoria {
    private String id;
    private Docente docente;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private boolean disponible;

    public HorarioTutoria(String id, Docente docente, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.id = id;
        this.docente = docente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.disponible = true;
    }

    public boolean isDisponible() { return disponible; }

    public void ocupar() {
        if (!disponible) throw new IllegalStateException("El horario ya está ocupado.");
        this.disponible = false;
    }

    public void liberar() {
        this.disponible = true;
    }
}
