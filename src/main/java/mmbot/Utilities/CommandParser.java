package mmbot.Utilities;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Megabitus on 6/2/2017.
 */
public class CommandParser {
    CommandContainer parse(String rw, MessageReceivedEvent event) {
        ArrayList<String> split = new ArrayList<String>();
        String beheaded = rw.replaceFirst(PropertiesManager.prefix, "");
        String[] splitBeheaded = beheaded.split(" ");
        Collections.addAll(split, splitBeheaded);
        String invoke = split.get(0);
        String[] args = new String[split.size() - 1];
        split.subList(1, split.size()).toArray(args);

        return new CommandContainer(rw, beheaded, splitBeheaded, invoke, args, event);
    }

    public class CommandContainer {
        public final String invoke;
        public final String[] args;
        public final MessageReceivedEvent event;
        final String raw;
        final String beheaded;
        final String[] splitBeheaded;

        CommandContainer(String rw, String beheaded, String[] splitBeheaded, String invoke, String[] args, MessageReceivedEvent event) {
            this.raw = rw;
            this.beheaded = beheaded;
            this.splitBeheaded = splitBeheaded;
            this.invoke = invoke;
            this.args = args;
            this.event = event;
        }
    }
}
