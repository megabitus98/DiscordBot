package mmbot.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Megabitus on 6/2/2017.
 */
public class PropertiesManager {
    public static List<String> emojy = new ArrayList<String>();
    public static String emoji_Location = "D:\\Cloud Storage\\Dropbox\\Programare\\DiscordBot\\out\\artifacts\\DiscordBot_jar\\Emoji\\";
    public static String log_Location = "D:\\Cloud Storage\\Dropbox\\Programare\\DiscordBot\\out\\artifacts\\DiscordBot_jar\\log.txt";
    public static String config_Location = "D:\\Cloud Storage\\Dropbox\\Programare\\DiscordBot\\out\\artifacts\\DiscordBot_jar\\config.txt";
    public static String prefix = "m!";

    public static void exportConsole() {
        File file = new File(log_Location);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);
    }

    public static void load_Emojy() {
        File folder = new File(emoji_Location);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                emojy.add(emoji_Location + file.getName());
            }
        }
    }


}
