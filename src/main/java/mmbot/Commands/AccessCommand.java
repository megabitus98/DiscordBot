package mmbot.Commands;

import mmbot.Utilities.Events;
import mmbot.Utilities.PropertiesManager;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Megabitus on 6/5/2017.
 */
public class AccessCommand implements Command {
    private String HELP = PropertiesManager.prefix + "access" + "\n" + "Gives access to the NSFW Room";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        Member member = event.getMember();
        if (Events.waiting.contains(member))
            event.getChannel().sendMessage("Can't give access yet, you still have to wait!").queue();
        else {
            Guild guild = event.getGuild();
            GuildController guildController = new GuildController(guild);
            Role role = guild.getRolesByName("NSFW Access", true).get(0);
            guildController.addRolesToMember(member, role).queue();
            System.out.println("Given access to " + member + " on server " + guild + " to role " + role.getName());
            event.getChannel().sendMessage("Access given to " + member.getAsMention() + "to NSFW Room for 5 minutes!").queue();
            Events.waiting.add(member);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    guildController.removeRolesFromMember(member, role).queue();
                    System.out.println("Removed access to " + member + " on server " + guild + " to role " + role.getName());
                    event.getChannel().sendMessage("Removed access for NSFW Room for user " + member.getAsMention() + "!").queue();
                    timer.cancel();
                }
            }, 300000, 1);
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
