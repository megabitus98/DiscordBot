package mmbot.Bot;

import mmbot.Utilities.BotListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

/**
 * Created by Megabitus on 6/2/2017.
 */
public class BotInitialize {

    public static JDA jda;

    public static void ConnectTheBot() {
        try {
            jda = new JDABuilder(AccountType.BOT)
                    .setToken("MzIwMDczMTI1NTgyNjAyMjUy.DBKU9g.89b-RZw0mT9Kgt3sl7fI4WTr7_g")
                    .addEventListener(new BotListener())
                    .buildBlocking();
            jda.setAutoReconnect(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
