package mmbot.Commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by Megabitus on 6/2/2017.
 */
public interface Command {

    boolean called(String[] args, MessageReceivedEvent event);

    void action(String[] args, MessageReceivedEvent event);

    String help();

    void executed(boolean success, MessageReceivedEvent event);

}
