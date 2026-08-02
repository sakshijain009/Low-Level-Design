package strategy;

import models.Board;
import models.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Player player);
}
