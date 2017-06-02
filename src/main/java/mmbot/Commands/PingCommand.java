package mmbot.Commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by Megabitus on 6/2/2017.
 */
public class PingCommand implements Command {
    private final String HELP = "m!ping";

    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        event.getChannel().sendMessage("PONG! :scream: ").queue();
    }

    public String help() {
        return HELP;
    }

    public void executed(boolean success, MessageReceivedEvent event) {
    }
}
