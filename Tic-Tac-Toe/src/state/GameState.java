package state;

import game.Game;
import models.Player;

public interface GameState {
    void handleMove(Game game, Player player, int row, int col);
}
