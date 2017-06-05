package mmbot.Commands;

import mmbot.Utilities.CommandParser;
import mmbot.Utilities.PropertiesManager;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.apache.commons.io.FilenameUtils;

import java.util.ArrayList;
import java.util.List;

import static mmbot.Commands.CommandManager.commands;

/**
 * Created by Megabitus on 6/2/2017.
 */
public class HelpCommand implements Command {
    private String HELP = PropertiesManager.prefix + "help" + "\n" + "This screen";

    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        String help = "";
        List<String> commandsName = new ArrayList<String>(commands.keySet());
        int commandsNumber = commands.size() + PropertiesManager.emoji.size();
        event.getChannel().sendMessage(String.format("I have: %d commands!", commandsNumber)).queue();
        for (int i = 1; i <= commands.size(); i++) {
            String cmd = commandsName.get(i - 1);
            String build = "" + cmd + String.format(" | Usage: %s ", commands.get(cmd).help());
            help = CommandParser.multilineComment(help, new String[]{build});
        }
        String list = "< ";
        for (String item : PropertiesManager.emoji)
            list = CommandParser.singlelineComment(list, new String[]{FilenameUtils.getBaseName(item) + " | "});
        list = CommandParser.singlelineComment(list, new String[]{" >"});
        help = CommandParser.multilineComment(help, new String[]{list});
        event.getChannel().sendMessage(help).queue();
    }

    public String help() {
        return HELP;
    }

    public void executed(boolean success, MessageReceivedEvent event) {
    }
}
