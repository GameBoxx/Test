package info.gameboxx.test;

import info.gameboxx.gameboxx.game.Game;
import info.gameboxx.gameboxx.game.GameSession;

import java.util.UUID;

public class TestSession extends GameSession {

    public TestSession(Game game, UUID uid) {
        super(game, uid);
    }

    @Override
    public TestSession deepCopy() {
        return this;
    }
}
