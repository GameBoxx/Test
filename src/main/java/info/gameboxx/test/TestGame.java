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

import info.gameboxx.gameboxx.components.*;
import info.gameboxx.gameboxx.game.Arena;
import info.gameboxx.gameboxx.game.Game;
import info.gameboxx.gameboxx.game.GameSession;
import info.gameboxx.gameboxx.options.list.*;
import info.gameboxx.gameboxx.options.single.*;
import info.gameboxx.gameboxx.util.Pair;

import java.util.Arrays;

public class TestGame extends Game {

    public TestGame(Test test) {
        super(test, "Test");
    }

    @Override
    public void registerOptions() {
        registerArenaOption("single.location", new LocationO());
        registerArenaOption("single.block", new BlockO());
        registerArenaOption("single.world", new WorldO());
        registerArenaOption("single.player", new PlayerO());
        registerArenaOption("single.string.1", new StringO());
        registerArenaOption("single.string.2", new StringO().match("a", "b", "c"));
        registerArenaOption("single.string.3", new StringO().match(new Pair("A", Arrays.asList("b", "c")), new Pair("D", Arrays.asList("e", "f"))));
        registerArenaOption("single.string.4", new StringO().minChars(3).maxChars(10));
        registerArenaOption("single.int", new IntO());
        registerArenaOption("single.double", new IntO());
        registerArenaOption("single.bool", new IntO());
        registerArenaOption("single.cuboid", new CuboidO());
        registerArenaOption("single.vector", new VectorO());
        registerArenaOption("single.material", new MaterialO());

        registerArenaOption("list.string", new StringLO());
        registerArenaOption("list.int", new IntLO());
        registerArenaOption("list.block", new BlockLO());
        registerArenaOption("list.cuboid", new CuboidLO());
    }

    @Override
    public GameSession getNewGameSession(Arena arena, int sessionID) {
        return new TestSession(this, arena, sessionID);
    }

    @Override
    public void addComponents() {
        addComponent(new PlayersCP(this));
        addComponent(new MaxPlayersCP(this));
        addComponent(new MinPlayersCP(this));
        addComponent(new CountdownCP(this));
    }
}
