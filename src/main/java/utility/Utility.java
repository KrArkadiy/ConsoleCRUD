package utility;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utility {
    private final static String pathToFile = "\\src\\main\\resources\\files\\";

    public static List<String> read(String filename){
        List<String> data = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(getPath(filename))))){
            String line;
            while((line = reader.readLine()) != null){
                data.add(line);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return data;
    }

    public static void write(String fileName, String data){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(getPath(fileName)))){
            writer.write(data);
            writer.newLine();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void writeList(String fileName, List<String> data){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(getPath(fileName)))){
            for(String str : data){
                writer.write(str);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static String getPath(String fileName){
        String path = Paths.get("").toAbsolutePath() + pathToFile+fileName;
        return path;
    }
}
