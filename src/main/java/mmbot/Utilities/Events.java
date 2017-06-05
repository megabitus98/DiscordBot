package mmbot.Utilities;

import mmbot.Bot.BotInitialize;
import net.dv8tion.jda.core.entities.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Megabitus on 6/5/2017.
 */
public class Events {

    public static List<Member> waiting = new ArrayList<Member>();

    public static void cleanListHour() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (waiting.size() != 0) {
                    System.out.println("One hour passed, clearing the list!");
                    BotInitialize.jda.getGuildsByName("Mega Server", false).get(0).getPublicChannel().sendMessage("One hour passed, clearing the list!").queue();
                }
                waiting.clear();
            }
        }, 0, 3300000);
    }

}
