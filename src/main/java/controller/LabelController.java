package controller;

import model.Label;
import repository.Implementation.JsonLabelRepositoryImpl;
import repository.Implementation.JsonLabelRepositoryImpl.*;

import java.util.List;
import java.util.Scanner;

public class LabelController {

    JsonLabelRepositoryImpl jsonLabelRepository;

    public LabelController(JsonLabelRepositoryImpl jsonLabelRepository) {
        this.jsonLabelRepository = jsonLabelRepository;
    }

    public List<Label> getAll(){
        return jsonLabelRepository.getAll();
    }

    public Label getById(Integer aInteger){
        return jsonLabelRepository.getById(aInteger);
    }

    public void save(Label label){
        jsonLabelRepository.save(label);
    }

    public void update(Label label){
        jsonLabelRepository.update(label);
    }

    public void deleteById(Integer iInteger){
        jsonLabelRepository.deleteById(iInteger);
    }
}
