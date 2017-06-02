package mmbot.Commands;

import mmbot.Utilities.PropertiesManager;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

import static mmbot.Commands.CommandManager.commands;

/**
 * Created by Megabitus on 6/2/2017.
 */
public class HelpCommand implements Command {
    private String HELP = PropertiesManager.prefix + "help";

    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        List<String> commandsName = new ArrayList<String>(commands.keySet());
        int commandsNumber = commands.size();
        event.getChannel().sendMessage("I have: " + commandsNumber + " commands!").queue();
        for (int i = 1; i <= commandsNumber; i++) {
            String cmd = commandsName.get(i - 1);
            String build = "" + cmd + String.format("|Usage: %s ", commands.get(cmd).help());
            event.getChannel().sendMessage(build).queue();
        }
    }

    public String help() {
        return HELP;
    }

    public void executed(boolean success, MessageReceivedEvent event) {
    }
}
