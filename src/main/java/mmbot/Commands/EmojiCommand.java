package mmbot.Commands;

import mmbot.Utilities.CommandParser;
import mmbot.Utilities.PropertiesManager;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Megabitus on 6/2/2017.
 */
public class EmojiCommand implements Command {
    final String HELP = PropertiesManager.prefix + "emoji <emoji | list>";

    public static void sendEmoji(String name, MessageReceivedEvent event) {
        for (String item : PropertiesManager.emoji) {
            if (FilenameUtils.getBaseName(item).equalsIgnoreCase(name)) try {
                event.getChannel().sendFile(new File(item), null).queue();
                event.getMessage().delete().queue();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        if (args.length != 0 && !args[0].equals("list")) {
            Message message = new MessageBuilder().append(args[0]).build();
            try {
                for (String item : PropertiesManager.emoji) {
                    String name = FilenameUtils.getBaseName(item);
                    if (args[0].equalsIgnoreCase(name)) {
                        event.getChannel().sendFile(new File(item), message).queue();
                        System.out.println(item + " has been sent!");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (args.length == 0) {
            event.getChannel().sendMessage("Usage: " + HELP).queue();
        } else if (args[0].equals("list")) {
            String list = PropertiesManager.prefix + "emoji < ";
            for (String item : PropertiesManager.emoji)
                list = CommandParser.singlelineComment(list, new String[]{FilenameUtils.getBaseName(item) + " | "});
            list = CommandParser.singlelineComment(list, new String[]{" >"});
            event.getChannel().sendMessage(list).queue();
        }
    }

    public String help() {
        return HELP;
    }

    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
