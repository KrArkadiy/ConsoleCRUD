package controller;

import model.Label;
import repository.Implementation.JsonLabelRepositoryImpl;
import repository.Implementation.JsonLabelRepositoryImpl.*;

import java.util.List;
import java.util.Scanner;

public class LabelController {

    LabelController labelController;

    public LabelController() {

    }

    public List<Label> getAll(){
        return labelController.getAll();
    }

    public Label getById(Integer aInteger){
        return labelController.getById(aInteger);
    }

    public void save(Label label){
        labelController.save(label);
    }

    public void update(Label label){
        labelController.update(label);
    }

    public void deleteById(Integer iInteger){
        labelController.deleteById(iInteger);
    }
}
