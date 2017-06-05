package mmbot.Commands;

import mmbot.Bot.BotInitialize;
import mmbot.Utilities.PropertiesManager;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Megabitus on 6/3/2017.
 */
public class StopCommand implements Command {
    String HELP = PropertiesManager.prefix + "stop" + "\n" + "Used to stop the bot by the OWNER";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getMember().getUser().getId().equalsIgnoreCase("318804585793716224")) {
            Message message = new MessageBuilder().append("Bye, bye cruel world!").build();
            try {
                for (String item : PropertiesManager.emoji) {
                    String name = FilenameUtils.getBaseName(item);
                    if ("SadKondo".equalsIgnoreCase(name)) {
                        //TODO ADD COMPLETE
                        event.getGuild().getPublicChannel().sendFile(new File(item), message);
                        System.out.println("System shutting down!");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            BotInitialize.jda.shutdown(true);
            System.exit(0);
        }
    }

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
