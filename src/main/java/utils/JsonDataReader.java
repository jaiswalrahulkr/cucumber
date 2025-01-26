package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonDataReader {
    public static JsonNode getData(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        try {

            return mapper.readTree(new File("C:\\Users\\rahul.chaudhary\\RahulAutomation\\BDDFramework\\src\\test\\resources\\testdata\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
