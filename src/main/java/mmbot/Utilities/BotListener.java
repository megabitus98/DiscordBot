package mmbot.Utilities;

import mmbot.Commands.CommandManager;
import mmbot.Main;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.File;
import java.io.IOException;

/**
 * Created by Megabitus on 6/2/2017.
 */
public class BotListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContent().startsWith(PropertiesManager.prefix) && !event.getMessage().getAuthor().getId().equals(event.getJDA().getSelfUser().getId())) {
            CommandManager.handleCommand(Main.parser.parse(event.getMessage().getContent().toLowerCase(), event));
            System.out.println("Status|Got a message " + event.getMessage().getContent() + " from " + event.getMessage().getAuthor());
        }
        if (event.getMessage().getContent().equals("test")) {
            String file = PropertiesManager.emojy.get(5);
            Message message = new MessageBuilder().append("MEGA TEST").build();
            try {
                event.getChannel().sendFile(new File(file), message).queue();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("Status|Logged in as: " + event.getJDA().getSelfUser().getName());
    }

    @Override
    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {
        String user = event.getMember().getUser().getName();
        event.getGuild().getPublicChannel().sendMessage("Welcome " + user + "!").queue();
    }
}
