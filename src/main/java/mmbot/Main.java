package mmbot;

import mmbot.Bot.BotInitialize;
import mmbot.Commands.CommandManager;
import mmbot.Utilities.CommandParser;

/**
 * Created by Megabitus on 6/2/2017.
 */
public class Main {

    public static final CommandParser parser = new CommandParser();

    public static void main(String[] args) {

        BotInitialize.ConnectTheBot();
        CommandManager.RegisterCommands();
    }
}
