package repository.Implementation;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.Writer;
import repository.WriterRepository;
import utility.Utility;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JsonWriterRepositoryImpl implements WriterRepository {
    private final static String FILE_NAME = "writers.json";
    JsonLabelRepositoryImpl a = new JsonLabelRepositoryImpl();


    @Override
    public Writer getById(Integer integer) {
        List<Writer> writers = deserialization(Utility.read(FILE_NAME));
        Writer writer = writers.stream().filter((s) -> s.getId().equals(integer)).findFirst().get();
        return writer;
    }

    @Override
    public List<Writer> getAll() {
        List<Writer> writers = deserialization(Utility.read(FILE_NAME));
        return writers;
    }

    @Override
    public void save(Writer writer) {
        Utility.write(FILE_NAME, serialization(writer));
    }

    @Override
    public void update(Writer writer) {
        deleteById(writer.getId());
        save(writer);
    }

    @Override
    public void deleteById(Integer integer) {
        List<Writer> writers = deserialization(Utility.read(FILE_NAME));
        Writer deleted = writers.stream().filter((s) -> s.getId().equals(integer)).findFirst().get();
        writers.remove(deleted);

        Utility.writeList(FILE_NAME, serialization(writers));
    }

    public List<Writer> deserialization(List<String> data) {
        List<Writer> writers = new ArrayList<>();

        for (String str : data) {
            Writer writer = new Gson().fromJson(str, Writer.class);
            writers.add(writer);
        }
        return writers;
    }

    public String serialization(Writer writer) {
        String jsonString = new Gson().toJson(writer);
        return jsonString;
    }

    public List<String> serialization(List<Writer> data) {
        List<String> serializedList = new ArrayList<>();
        for (Writer writer : data) {
            String json = new Gson().toJson(writer);
            serializedList.add(json);
        }
        return serializedList;
    }

    public void arrayDeserialization(){
        String string = "{\"id\" : 1, \"name\" :  \"Pushkin\", \"posts\" : [\"asd\", \"nasa\", \"carting\"]}";
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(string);
        JsonArray posts = (JsonArray) jsonObject.get("posts");
        for(JsonElement str : posts){
            System.out.println(str);
        }
    }
}



