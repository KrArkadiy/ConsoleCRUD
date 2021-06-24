package repository.Implementation;

import com.google.gson.Gson;
import model.Label;

import repository.LabelRepository;
import utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JsonLabelRepositoryImpl implements LabelRepository {

    private final static String FILE_NAME = "labels.json";

    public Label getById(Integer integer) {
        List<Label> labels = deserialization(Utility.read(FILE_NAME));
        Label label = labels.stream().filter((s)->s.getId().equals(integer)).findFirst().get();

        return label;

    }

    @Override
    public List<Label> getAll() {
        List<Label> labels = deserialization(Utility.read(FILE_NAME));
        return labels;
    }

    @Override
    public void save(Label label) {
        Utility.write(FILE_NAME, serialization(label));
    }

    @Override
    public void update(Label label) {
        deleteById(label.getId());
        save(label);
    }

    @Override
    public void deleteById(Integer integer) {
        List<Label> labels = deserialization(Utility.read(FILE_NAME));

        Label deleted = labels.stream().filter((s)->s.getId().equals(integer)).findFirst().get();
        labels.remove(deleted);

        Utility.writeList(FILE_NAME, serialization(labels));
    }

    public List<Label> deserialization(List<String> data){
        List<Label> labels = new ArrayList<>();

        for(String str : data){
            Label label = new Gson().fromJson(str, Label.class);
            labels.add(label);
        }

        return labels;
    }

    public String serialization(Label label){
        String jsonString = new Gson().toJson(label);
        return jsonString;
    }

    public  List<String> serialization(List<Label> labels){
        List<String> serialized = new ArrayList<>();
        for(Label label : labels){
            String str = new Gson().toJson(label);
            serialized.add(str);
        }
        return serialized;
    }
}
