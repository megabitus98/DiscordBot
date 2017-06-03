package mmbot.Utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Megabitus on 6/2/2017.
 */
public class PropertiesManager {
    public static List<String> emojy = new ArrayList<String>();
    public static String config_Location = "config.txt";
    public static String log_Location = "log.txt";
    public static String emoji_Location = "";
    public static String prefix = "!!";

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

    public static void configFile() {
        try {
            File file = new File(config_Location);
            if (file.createNewFile()) {
                System.out.println("Config file created!");
                System.out.println("Edit the config file, for the emoji!!");
                PrintWriter pw = new PrintWriter(new FileWriter(config_Location));
                pw.println(prefix);
                pw.println("LOCATION EMOJI");
                pw.close();
                System.exit(0);
            } else {
                System.out.println("Config file already exists. Going to load the settings!");
                try (BufferedReader br = new BufferedReader(new FileReader(config_Location))) {
                    String sCurrentLine;
                    int line = 0;
                    while ((sCurrentLine = br.readLine()) != null) {
                        switch (line) {
                            case 0: {
                                prefix = sCurrentLine;
                                line++;
                            }
                            break;
                            case 1: {
                                emoji_Location = sCurrentLine;
                                if (emoji_Location.equals("LOCATION EMOJI")) {
                                    System.out.println("Edit the config file, for the emoji!!");
                                    System.exit(0);
                                }
                                line++;
                            }
                            default: {
                            }
                            break;
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Prefix:" + prefix);
        System.out.println("Emoji_Location:" + emoji_Location);
    }

    public static void load_Emoji() {
        File folder = new File(emoji_Location);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                emojy.add(file.getAbsolutePath());
            }
            System.out.println(file.getAbsolutePath());
        }

    }
}
