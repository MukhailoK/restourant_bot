package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Table {
    private boolean state;
    private int id;
    private Client client;
    private LocalDateTime timeReservation;

    public Table() {
    }

    public Table(boolean state, int id, Client client, LocalDateTime timeReservation) {
        this.state = state;
        this.id = id;
        this.client = client;
        this.timeReservation = timeReservation;
    }

    @Override
    public String toString() {
        return "Table{" +
                "state=" + state +
                ", id=" + id +
                ", client=" + client +
                ", timeReservation=" + timeReservation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return id == table.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
        this.timeReservation = client.getTime();
    }

    public LocalDateTime getTimeReservation() {
        return timeReservation;
    }

    public void setTimeReservation(LocalDateTime timeReservation) {
        this.timeReservation = timeReservation;
    }
}
