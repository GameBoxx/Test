package info.gameboxx.test;

import info.gameboxx.gameboxx.components.CountdownGC;
import info.gameboxx.gameboxx.components.PlayersCP;
import info.gameboxx.gameboxx.game.Game;
import info.gameboxx.gameboxx.game.GameSession;

import java.util.UUID;

public class TestGame extends Game {

    public TestGame(Test test) {
        super(test, "Test");
    }

    @Override
    public GameSession getNewGameSession(UUID sessionUID) {
        return new TestSession(this, sessionUID);
    }

    @Override
    public void addComponents() {
        addComponent(new PlayersCP(this));
        addComponent(new CountdownGC(this));
    }


    @Override
    public TestGame deepCopy() {
        return this;
    }
}
