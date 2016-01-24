package info.gameboxx.test;

import info.gameboxx.gameboxx.GameBoxx;
import info.gameboxx.gameboxx.game.ArenaType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Test extends JavaPlugin {

    private GameBoxx api;
    private TestGame game;

    private final Logger log = Logger.getLogger("Test");

    @Override
    public void onDisable() {
        api.getGM().unregister("Test");

        log.info("disabled");
    }

    @Override
    public void onEnable() {
        log.setParent(getLogger());
        api = GameBoxx.get();

        game = new TestGame(this);
        api.getGM().register(game);

        game.createArena(ArenaType.DEFAULT, "Test");

        log.info("loaded successfully");
    }

    public GameBoxx getAPI() {
        return api;
    }

    public TestGame getGame() {
        return game;
    }
}
