/*
 The MIT License (MIT)

 Copyright (c) 2016 GameBoxx <http://gameboxx.info>
 Copyright (c) 2016 contributors

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 */

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
