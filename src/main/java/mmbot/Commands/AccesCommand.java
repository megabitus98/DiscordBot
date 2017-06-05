package mmbot.Commands;

import mmbot.Utilities.PropertiesManager;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by Megabitus on 6/5/2017.
 */
public class AccesCommand implements Command {
    private String HELP = PropertiesManager.prefix + "acces";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
