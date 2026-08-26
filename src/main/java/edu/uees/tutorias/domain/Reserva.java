package edu.uees.tutorias.domain;
import java.time.LocalDateTime;

public class Reserva {
    private String id;
    private Estudiante estudiante;
    private HorarioTutoria horario;
    private EstadoReserva estado;
    private LocalDateTime fechaCreacion;

    public Reserva(String id, Estudiante estudiante, HorarioTutoria horario) {
        this.id = id;
        this.estudiante = estudiante;
        this.horario = horario;
        this.estado = EstadoReserva.PENDIENTE;
        this.fechaCreacion = LocalDateTime.now();
    }
    public void confirmar() {
        if (this.estado != EstadoReserva.PENDIENTE) {
            throw new IllegalStateException("Solo se pueden confirmar reservas pendientes.");
        }
        this.horario.ocupar();
        this.estado = EstadoReserva.CONFIRMADA;
    }
    public void cancelar() {
        this.horario.liberar();
        this.estado = EstadoReserva.CANCELADA;
    }
    public Estudiante getEstudiante() { return estudiante; }
    public EstadoReserva getEstado() { return estado; }
}