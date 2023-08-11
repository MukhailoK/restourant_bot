package dao;

import model.Client;
import model.Table;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BotImpl implements Bot {
    private List<Table> tables;
    private PrintWriter printWriter;

    public BotImpl(){
        this.tables = new ArrayList<>();
        initializeTable();
        try {
            printWriter = new PrintWriter(new FileWriter("data", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String welcome() {
        if (freeTables().size() != 0) {
           return "Welcome!";
        } else
           return "So sorry, we have no free tables";
    }

    @Override
    public List<Table> freeTables() {
        List<Table> tables = new ArrayList<>();
        for (Table table : this.tables) {
            if (table.isState()) {
                tables.add(table);
            }
        }
        return tables;
    }

    @Override
    public boolean reserveTable(Client client) {
        if (freeTables().size() > 0) {
            for (Table table : tables) {
                if (table.getId() == freeTables().get(0).getId()) {
                    table.setClient(client);
                    table.setState(false);
                    printWriter.write(table.toString() + "\n");
                    printWriter.flush();
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public boolean removeReservation(String name) {
        if (name != null) {
            for (Table table : tables) {
                if (table.getClient().getName().equals(name)) {
                    table.setState(true);
                    table.setClient(new Client(null, 0, null, 0));
                    return true;
                }
            }
        }
        return false;
    }

    private void initializeTable() {
        for (int i = 1; i < 6; i++) {
            tables.add(new Table(true, i, null, null));
        }
    }
}
