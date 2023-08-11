package dao;

import model.Client;
import model.Table;

import java.util.List;

public interface Bot {
    String welcome();

    List<Table> freeTables();

    boolean reserveTable(Client client);

    boolean removeReservation(String name);
}
