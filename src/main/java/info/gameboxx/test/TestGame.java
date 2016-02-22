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

import info.gameboxx.gameboxx.components.CountdownCP;
import info.gameboxx.gameboxx.components.MaxPlayersCP;
import info.gameboxx.gameboxx.components.MinPlayersCP;
import info.gameboxx.gameboxx.components.PlayersCP;
import info.gameboxx.gameboxx.game.Arena;
import info.gameboxx.gameboxx.game.Game;
import info.gameboxx.gameboxx.game.GameSession;
import info.gameboxx.gameboxx.options.list.BlockListOption;
import info.gameboxx.gameboxx.options.list.CuboidListOption;
import info.gameboxx.gameboxx.options.list.IntListOption;
import info.gameboxx.gameboxx.options.list.StringListOption;
import info.gameboxx.gameboxx.options.single.*;
import info.gameboxx.gameboxx.util.Pair;
import info.gameboxx.gameboxx.util.cuboid.Cuboid;

import java.util.Arrays;

public class TestGame extends Game {

    public TestGame(Test test) {
        super(test, "Test");
    }

    @Override
    public void registerOptions() {
        registerArenaOption("single.location", new LocationOption("TestLocation"));
        registerArenaOption("single.block", new BlockOption("TestBlock"));
        registerArenaOption("single.world", new WorldOption("TestWorld"));
        registerArenaOption("single.player", new PlayerOption("TestPlayer"));
        registerArenaOption("single.string.1", new StringOption("TestString1"));
        registerArenaOption("single.string.2", new StringOption("TestString2").match("a", "b", "c"));
        registerArenaOption("single.string.3", new StringOption("TestString3").match(new Pair("A", Arrays.asList("b", "c")), new Pair("D", Arrays.asList("e", "f"))));
        registerArenaOption("single.string.4", new StringOption("TestString4").minChars(3).maxChars(10));
        registerArenaOption("single.int", new IntOption("TestInt"));
        registerArenaOption("single.double", new IntOption("TestDouble"));
        registerArenaOption("single.bool", new IntOption("TestBool"));
        registerArenaOption("single.cuboid", new CuboidOption("TestCuboid"));
        registerArenaOption("single.vector", new VectorOption("TestVector"));
        registerArenaOption("single.material", new MaterialOption("TestMaterial"));

        registerArenaOption("list.string", new StringListOption("TestStrings"));
        registerArenaOption("list.int", new IntListOption("TestInts"));
        registerArenaOption("list.block", new BlockListOption("TestBlocks"));
        registerArenaOption("list.cuboid", new CuboidListOption("TestCuboids"));

        registerGameOption("some.test.setting", new BoolOption("test1", true));
        registerGameOption("some.other.setting", new CuboidOption("test2", new Cuboid("world",0,0,0,0,0,0)));
        registerGameOption("awesome", new CuboidOption("test3"));
        registerGameOption("awesome-values", new IntListOption("test4", 4));
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
