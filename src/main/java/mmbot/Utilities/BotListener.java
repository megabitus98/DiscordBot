package mmbot.Utilities;

import mmbot.Commands.CommandManager;
import mmbot.Main;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by Megabitus on 6/2/2017.
 */
public class BotListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContent().startsWith("m!") && !event.getMessage().getAuthor().getId().equals(event.getJDA().getSelfUser().getId())) {
            CommandManager.handleCommand(Main.parser.parse(event.getMessage().getContent().toLowerCase(), event));
            System.out.println("Status|Got a message " + event.getMessage().getContent());
        }
    }

    @Override
    public void onReady(ReadyEvent event) {
        //Main.log("Status", "Logged in as: " + event.getJDA().getSelfUser().getName());
        System.out.println("Status|Logged in as: " + event.getJDA().getSelfUser().getName());
    }
}
