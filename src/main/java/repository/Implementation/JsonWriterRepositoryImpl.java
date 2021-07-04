package repository.Implementation;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.Writer;
import repository.WriterRepository;
import utility.Utility;

import java.lang.reflect.Type;
import java.util.*;

public class JsonWriterRepositoryImpl implements WriterRepository {

    private final String FILE_NAME = "writers.json";
    private final Gson gson = new Gson();

    @Override
    public Writer getById(Integer integer) {
        return arrayDeserialization(Utility.read(FILE_NAME))
                .stream()
                .filter((s)->s.getId().equals(integer))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Writer> getAll() {
        return arrayDeserialization(Utility.read(FILE_NAME));
    }

    @Override
    public Writer save(Writer writer) {
        writer.setId(generateNewId());
        Utility.write(FILE_NAME, serialization(writer));
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        List<Writer> writers = arrayDeserialization(Utility.read(FILE_NAME));
        writers.forEach(w->{
            if(w.getId().equals(writer.getId())){
                w.setName(writer.getName());
            }
        });
        Utility.writeList(FILE_NAME, serialization(writers));
        return writer;
    }

    @Override
    public void deleteById(Integer integer) {
        List<Writer> writers = arrayDeserialization(Utility.read(FILE_NAME));
        writers.removeIf(w -> w.getId().equals(integer));
        Utility.writeList(FILE_NAME, serialization(writers));
    }

    public String serialization(Writer writer) {
        String jsonString = gson.toJson(writer);
        return jsonString;
    }

    public List<String> serialization(List<Writer> data) {
        List<String> serializedList = new ArrayList<>();
        for (Writer writer : data) {
            String json = gson.toJson(writer);
            serializedList.add(json);
        }
        return serializedList;
    }

    public List<Writer> arrayDeserialization(List<String> data) {
        List<Writer> writers = new ArrayList<>();
        Type targetClassType = new TypeToken<ArrayList<Writer>>() {}.getType();
        for (String writer : data) {
            writers = gson.fromJson(writer, targetClassType);
        }
        return writers;
    }

    public Integer generateNewId(){
        Writer maxIdWriter = arrayDeserialization(Utility.read(FILE_NAME)).stream().max(Comparator.comparing(Writer::getId))
                .orElse(null);
        return Objects.nonNull(maxIdWriter) ? maxIdWriter.getId() + 1 : 1;
    }
}



