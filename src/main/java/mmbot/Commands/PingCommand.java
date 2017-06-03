package mmbot.Commands;

import mmbot.Bot.BotInitialize;
import mmbot.Utilities.PropertiesManager;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by Megabitus on 6/2/2017.
 */
public class PingCommand implements Command {
    private final String HELP = PropertiesManager.prefix + "ping";

    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        event.getChannel().sendMessage(String.format("PONG! :scream: \n" +
                "%dms", BotInitialize.jda.getPing())).queue();
    }

    public String help() {
        return HELP;
    }

    public void executed(boolean success, MessageReceivedEvent event) {
    }
}
