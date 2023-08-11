package test;

import dao.Bot;
import dao.BotImpl;
import model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BotImplTest {
    Bot bot;
    LocalDateTime now = LocalDateTime.now();

    @BeforeEach
    void setUp() {
        bot = new BotImpl();
        Client client = new Client("Name2", 2, now, 1112);
        bot.reserveTable(client);
    }

    @Test
    void welcome() {
        assertEquals(bot.welcome(), "Welcome!");
    }

    @Test
    void welcomeIfNoFreeTables() {
        Client client = new Client("Name1", 1, now, 1111);
        for (int i = 0; i < 5; i++) {
            client.setName("Name" + i);
            bot.reserveTable(client);
        }
        assertEquals("So sorry, we have no free tables", bot.welcome());
    }

    @Test
    void freeTables() {
        assertEquals(4, bot.freeTables().size());
    }

    @Test
    void reserveTable() {
        Client client = new Client("Name1", 1, now, 1111);
        assertTrue(bot.reserveTable(client));
        assertEquals(3, bot.freeTables().size());
    }

    @Test
    void removeReservation() {
        String name = "Name2";
        assertEquals(4, bot.freeTables().size());
        assertTrue(bot.removeReservation(name));
        assertEquals(5, bot.freeTables().size());

    }
}