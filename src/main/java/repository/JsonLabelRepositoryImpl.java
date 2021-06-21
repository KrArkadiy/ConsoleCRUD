package repository;

import model.Label;

public class JsonLabelRepositoryImpl implements LabelRepository{

    public static void addLabel(Label label) {
        System.out.println("Add label");
    }

    public static void updateLabel(Label label) {
        System.out.println("Update label");
    }

    public static void removeLabel(int id) {
        System.out.println("Label deleted");
    }
}
