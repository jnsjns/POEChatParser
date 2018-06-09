package se.kth.hogk.poe_chat_parser.hello;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    private String CLIENT_FILE_PATH = "C:\\Program Files (x86)\\Path of Exile\\logs\\Client.txt";
    private String IGNORE_WORDS_PATH = "file/ignore.txt";
    private List<String> whisperList = new ArrayList<>();
    private BufferedReader clientReader;
    private BufferedReader ignoreReader;

    public FileParser(){
        try {
            this.clientReader = new BufferedReader(new FileReader(CLIENT_FILE_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List getWhisperList() throws IOException {

            String currentLine;
            while ((currentLine = this.clientReader.readLine()) != null) {
                if (currentLine.contains("@From") && !containsIgnoreWords(currentLine))
                    whisperList.add(currentLine);
            }
        return whisperList;
    }

    private Boolean containsIgnoreWords(String currentLine) throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File ignoreFile = new File(classLoader.getResource(IGNORE_WORDS_PATH).getFile());
        try {
            this.ignoreReader = new BufferedReader(new FileReader(ignoreFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String ignoreWord;
        while((ignoreWord = ignoreReader.readLine()) != null) {
            if (currentLine.contains(ignoreWord))
                return true;
        }
        return false;
    }

}
