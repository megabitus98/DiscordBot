package mmbot.Commands;

import mmbot.Utilities.PropertiesManager;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.io.File;
import java.io.IOException;

/**
 * Created by Megabitus on 6/2/2017.
 */
public class EmojiCommand implements Command {
    final String HELP = PropertiesManager.prefix + "Emoji <emoji>";

    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        PropertiesManager.load_Emoji();
        if (args.length != 0) {
            Message message = new MessageBuilder().append(args[0]).build();
            try {
                String file1 = PropertiesManager.emoji_Location + args[0] + ".png";
                String file2 = PropertiesManager.emoji_Location + args[0] + ".jpg";
                String file3 = PropertiesManager.emoji_Location + args[0] + ".gif";
                if (new File(file1).exists()) {
                    event.getChannel().sendFile(new File(file1), message).queue();
                    System.out.println(file1);
                } else if (new File(file2).exists()) {
                    event.getChannel().sendFile(new File(file2), message).queue();
                    System.out.println(file2);
                } else if (new File(file3).exists()) {
                    event.getChannel().sendFile(new File(file3), message).queue();
                    System.out.println(file3);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else event.getChannel().sendMessage("Usage: " + HELP).queue();
    }

    public String help() {
        return HELP;
    }

    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
