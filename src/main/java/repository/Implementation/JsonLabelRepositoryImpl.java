package repository.Implementation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Label;

import model.Writer;
import repository.LabelRepository;
import utility.Utility;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonLabelRepositoryImpl implements LabelRepository {

    private final static String FILE_NAME = "labels.json";
    private final Gson gson = new Gson();

    public Label getById(Integer integer) {
        return deserialization(Utility.read(FILE_NAME))
                .stream()
                .filter((s)->s.getId().equals(integer))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Label> getAll() {
        return deserialization(Utility.read(FILE_NAME));
    }

    @Override
    public Label save(Label label) {
        label.setId(generateNewId());
        Utility.write(FILE_NAME, serialization(label));
        return label;
    }

    @Override
    public Label update(Label label) {
        List<Label> labels = deserialization(Utility.read(FILE_NAME));
        labels.forEach((l)->{
            if(l.getId().equals(label.getId())){
                l.setName(label.getName());
            }
        });
        Utility.writeList(FILE_NAME, serialization(labels));
        return label;
    }

    @Override
    public void deleteById(Integer integer) {
        List<Label> labels = deserialization(Utility.read(FILE_NAME));
        labels.removeIf((l)->l.getId().equals(integer));
        Utility.writeList(FILE_NAME, serialization(labels));
    }

    public List<Label> deserialization(List<String> data) {
        List<Label> labels = new ArrayList<>();

        for (String str : data) {
            Label label = gson.fromJson(str, Label.class);
            labels.add(label);
        }

        return labels;
    }

    public String serialization(Label label) {
        String jsonString = gson.toJson(label);
        return jsonString;
    }

    public List<String> serialization(List<Label> labels) {
        List<String> serialized = new ArrayList<>();
        for (Label label : labels) {
            String str = gson.toJson(label);
            serialized.add(str);
        }
        return serialized;
    }

    public Integer generateNewId(){
        Label maxIdLabel = deserialization(Utility.read(FILE_NAME)).stream().max(Comparator.comparing(Label::getId))
                .orElse(null);
        return Objects.nonNull(maxIdLabel) ? maxIdLabel.getId() + 1 : 1;
    }
}

