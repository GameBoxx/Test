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
import info.gameboxx.gameboxx.exceptions.OptionAlreadyExistsException;
import info.gameboxx.gameboxx.game.Arena;
import info.gameboxx.gameboxx.game.Game;
import info.gameboxx.gameboxx.game.GameSession;
import info.gameboxx.gameboxx.options.single.*;
import info.gameboxx.gameboxx.util.Pair;

import java.util.Arrays;

public class TestGame extends Game {

    public TestGame(Test test) {
        super(test, "Test");

        addSetting("some.test.setting", true);
        addSetting("some.other.setting", false);
        addSetting("awesome", true);
        addSetting("awesome-values", new String[] {"a", "b", "c"});
    }

    @Override
    public void registerOptions() throws OptionAlreadyExistsException {
        registerSetupOption(new LocationOption("TestLocation").setDescription("A test option for a location!"));
        registerSetupOption(new BlockOption("TestBlock").setDescription("A test option for a block!"));
        registerSetupOption(new WorldOption("TestWorld").setDescription("A test option for a world!"));
        registerSetupOption(new PlayerOption("TestPlayer").setDescription("A test option for a player!"));
        registerSetupOption(new StringOption("TestString1").setDescription("A test option for a string!"));
        registerSetupOption(new StringOption("TestString2").match("a", "b", "c").setDescription("A test option for a string with list matches!"));
        registerSetupOption(new StringOption("TestString3").match(new Pair("A", Arrays.asList("b", "c")), new Pair("D", Arrays.asList("e", "f"))).setDescription("A test option for a string with map matches!"));
        registerSetupOption(new StringOption("TestString4").minChars(3).maxChars(10).setDescription("A test option for a string with min/max chars!"));
        registerSetupOption(new IntOption("TestInt").setDescription("A test option for a int!"));
        registerSetupOption(new IntOption("TestDouble").setDescription("A test option for a double!"));
        registerSetupOption(new IntOption("TestBool").setDescription("A test option for a boolean!"));
    }

    @Override
    public GameSession getNewGameSession(Arena arena, int sessionID) {
        return new TestSession(this, arena, sessionID);
    }

    @Override
    public void addComponents() {
        addComponent(new PlayersCP(this));
        addComponent(new MaxPlayersCP(this, 16));
        addComponent(new MinPlayersCP(this, 4));
        addComponent(new CountdownCP(this));
    }
}
