package mmbot;

import mmbot.Bot.BotInitialize;
import mmbot.Commands.CommandManager;
import mmbot.Utilities.CommandParser;
import mmbot.Utilities.PropertiesManager;

/**
 * Created by Megabitus on 6/2/2017.
 */
public class Main {

    public static final CommandParser parser = new CommandParser();

    public static void main(String[] args) {

        PropertiesManager.exportConsole();
        BotInitialize.ConnectTheBot();
        CommandManager.RegisterCommands();
    }
}
