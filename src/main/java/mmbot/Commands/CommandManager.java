package mmbot.Commands;

import mmbot.Utilities.CommandParser;

import java.util.HashMap;

/**
 * Created by Megabitus on 6/2/2017.
 */
public class CommandManager {

    static HashMap<String, Command> commands = new HashMap<String, Command>();

    public static void RegisterCommands() {
        commands.put("ping", new PingCommand());
        commands.put("help", new HelpCommand());
    }

    public static void handleCommand(CommandParser.CommandContainer cmd) {
        if (commands.containsKey(cmd.invoke)) {
            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);
            System.out.println(safe + "|" + cmd.invoke);
            if (safe) {
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);
            } else {
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }
        }
    }
}
