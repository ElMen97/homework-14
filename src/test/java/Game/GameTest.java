package Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testRoundFirstWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Аня", 900);
        Player player2 = new Player(2, "Макс", 400);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Аня", "Макс");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundSecondWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Витя", 70);
        Player player2 = new Player(2, "Коля", 90);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Витя", "Коля");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundNoOneWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Макс", 400);
        Player player2 = new Player(2, "Василиса", 400);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Макс", "Василиса");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundNoPlayer2() {
        Game game = new Game();
        Player player1 = new Player(1, "Макс", 400);
        Player player2 = new Player(2, "Алиса", 200);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Макс", "Ника");
        });
    }

    @Test
    public void testRoundNoPlayers() {
        Game game = new Game();

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Кирилл", "Света");
        });
    }
}
