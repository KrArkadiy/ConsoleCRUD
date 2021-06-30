package view;

import controller.LabelController;
import model.Label;

import static repository.Implementation.JsonLabelRepositoryImpl.*;

import java.util.Scanner;

public class LabelView extends BasicView {

    LabelController labelController;

    private final String menuMessage = "Выберете действие над label:\n" +
            "1. Получение label по номеру\n" +
            "2. Вывести список всех label\n" +
            "3. Добавить label\n" +
            "4. Редактировать label\n" +
            "5. Удалить label\n" +
            "6. Выход";


    void getById() {
        System.out.println(menuMessage);
        Integer id = sc.nextInt();
        try {
            labelController.getById(id);
            System.out.println("Операция успешно выполнена");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    void getAll() {
        System.out.println(menuMessage);
        try {
            System.out.println(labelController.getAll());
            System.out.println("Операция успешно выполнена");
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    void deleteById() {
        System.out.println(menuMessage);
        System.out.println("Введите id удаляемого post");
        Integer id = sc.nextInt();
        try {
            labelController.deleteById(id);
            System.out.println("Операция успешно выполнена");
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    void save() {
        System.out.println(menuMessage);
        System.out.println("Введите имя label");
        String name = sc.nextLine();
        System.out.println("Введите id для label");
        Integer id = sc.nextInt();
        try{
            Label newOne = new Label(name, id);
            labelController.save(newOne);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    void update() {
        System.out.println(menuMessage);
        System.out.println("Введите имя label");
        String name = sc.nextLine();
        System.out.println("Введите id для label");
        Integer id = sc.nextInt();
        try{
            Label updatedLabel = new Label(name, id);
            labelController.update(updatedLabel);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }
}

