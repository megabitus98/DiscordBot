package mmbot.Utilities;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Megabitus on 6/2/2017.
 */
public class CommandParser {
    public static List<String> getWords(String text) {
        List<String> words = new ArrayList<String>();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
                words.add(text.substring(firstIndex, lastIndex));
            }
        }

        return words;
    }

    public static String multilineComment(String original, String[] args) {
        String s = original + System.getProperty("line.separator");
        for (String item : args
                ) {
            s += item + System.getProperty("line.separator");
        }
        return s;
    }

    public static String singlelineComment(String original, String[] args) {
        String s = original;
        for (String item : args
                ) {
            s += item;
        }
        return s;
    }

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
