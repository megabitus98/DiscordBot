package mmbot.Bot;

import mmbot.Utilities.BotListener;
import mmbot.Utilities.PropertiesManager;
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
                    .setToken(PropertiesManager.bot_Token)
                    .addEventListener(new BotListener())
                    .buildBlocking();
            jda.setAutoReconnect(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
