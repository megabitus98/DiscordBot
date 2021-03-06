package mmbot.Utilities;

import mmbot.Commands.CommandManager;
import mmbot.Commands.EmojiCommand;
import mmbot.Main;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.apache.commons.io.FilenameUtils;

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
            System.out.println("Got a message " + event.getMessage().getContent() + " from " + event.getMessage().getAuthor());
        }
        if (!event.getMessage().getAuthor().getId().equals(event.getJDA().getSelfUser().getId())) {
            String emoji = event.getMessage().getContent().replaceAll(":", "");
            EmojiCommand.sendEmoji(emoji, event);
        }
    }

    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("Status|Logged in as: " + event.getJDA().getSelfUser().getName());
    }

    //TODO BUILD THE FUCKING THINK
    @Override
    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {
        /*
        if (!event.getMember().getUser().isBot()) {
            Role roleLeft = null, roleJoin = null;
            String ChannelNameJoin = event.getChannelJoined().getName();
            String ChannelNameLeft = event.getChannelLeft().getName();
            GuildController guildController = new GuildController(event.getGuild());
            for (Role role : event.getGuild().getRoles()
                    ) {
                if (role.getName().equalsIgnoreCase(ChannelNameLeft + " Role")) roleLeft = role;
                if (role.getName().equalsIgnoreCase(ChannelNameJoin + " Role")) roleJoin = role;
            }
            if (!ChannelNameLeft.equalsIgnoreCase("General")) {
                guildController.removeRolesFromMember(event.getMember(), roleLeft).submit();
                System.out.println("Removed access to " + event.getMember() + " on server " + event.getGuild() + " from " + roleLeft.getName());
            }
            if (!ChannelNameJoin.equalsIgnoreCase("General")) {
                guildController.addRolesToMember(event.getMember(), roleJoin).submit();
                System.out.println("Given access to " + event.getMember() + " on server " + event.getGuild() + " to role " + roleJoin.getName());
            }
            System.out.println("\n");
        }
        */
    }

    @Override
    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {
        if (!event.getMember().getUser().isBot()) {
            String ChannelName = event.getChannelJoined().getName();
            String ServerName = event.getGuild().getName();
            Message message = new MessageBuilder().append("Welcome " + event.getMember().getAsMention() + " on " + ServerName + " in " + ChannelName).build();
            try {
                for (String item : PropertiesManager.emoji) {
                    String name = FilenameUtils.getBaseName(item);
                    if ("stan".equalsIgnoreCase(name)) {
                        event.getGuild().getPublicChannel().sendFile(new File(item), message).queue();
                        System.out.println("Welcome " + item + " has been sent!");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
