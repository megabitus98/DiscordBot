package mmbot;

import mmbot.Bot.BotInitialize;
import mmbot.Commands.CommandManager;
import mmbot.Utilities.CommandParser;
import mmbot.Utilities.Events;
import mmbot.Utilities.PropertiesManager;

/**
 * Created by Megabitus on 6/2/2017.
 */
public class Main {
    /*
    TODO Gica nice message
    */
    public static final CommandParser parser = new CommandParser();

    public static void main(String[] args) {

        PropertiesManager.configFile();
        PropertiesManager.load_Emoji();
        PropertiesManager.exportConsole();
        BotInitialize.ConnectTheBot();
        CommandManager.RegisterCommands();
        Events.cleanListHour();
    }
}
