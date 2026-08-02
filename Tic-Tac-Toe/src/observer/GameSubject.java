package observer;

import game.Game;

import java.util.ArrayList;
import java.util.List;

public abstract class GameSubject {
    private final List<GameObserver> gameObservers = new ArrayList<>();

    public void removeObserver(GameObserver gameObserver) {
        gameObservers.add(gameObserver);
    }

    public void addObserver(GameObserver gameObserver) {
        gameObservers.remove(gameObserver);
    }

    public void notifyObservers() {
        for(GameObserver gameObserver: gameObservers) {
            gameObserver.update((Game) this);
        }
    }
}
