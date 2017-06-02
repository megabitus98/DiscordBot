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
    final String HELP = "m!Emoji <emoji>";

    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        Message message = new MessageBuilder().append("FeelsRageMan").build();
        try {
            event.getChannel().sendFile(new File(PropertiesManager.emoji_Location + "FeelsRageMan.png"), message).queue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String help() {
        return HELP;
    }

    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
