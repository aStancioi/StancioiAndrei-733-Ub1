package Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyFileWriter {

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::avoidSpecialCharacters)
                .collect(Collectors.joining("&"));
    }

    public String convertToStatistic(String[] data) {
        return Stream.of(data)
                .map(this::avoidSpecialCharacters)
                .collect(Collectors.joining(" "));
    }

    public String avoidSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public void writeToFile(List<String[]> strings, String filepath) throws FileNotFoundException {
        File csvOutputFile = new File(filepath);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            strings.stream().map(this::convertToCSV).forEach(pw::println);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void writeToStatistic(List<String[]> strings, String filepath) throws FileNotFoundException {
        File csvOutputFile = new File(filepath);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            strings.stream().map(this::convertToStatistic).forEach(pw::println);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}