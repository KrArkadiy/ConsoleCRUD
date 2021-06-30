package view;

import controller.PostController;
import controller.WriterController;
import model.Writer;

import java.util.Scanner;


public class WriterView extends BasicView{

    WriterController writerController;
    PostController postController;

    private final String menuMessage = "Выберете действие над writer:\n" +
            "1. Получение writer по номеру\n" +
            "2. Вывести список всех writer\n" +
            "3. Добавить writer\n" +
            "4. Редактировать writer\n" +
            "5. Удалить writer\n" +
            "6. Выход";

    public WriterView(WriterController writerController, Scanner sc) {
        this.writerController = writerController;
        this.sc = sc;
    }


    public void getById() {
        System.out.println(menuMessage);
        System.out.println("Введите id искомого writer");
        Integer id = sc.nextInt();
        try {
            writerController.getById(id);
            System.out.println("Операция успешно выполнена");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    public void getAll() {
        System.out.println(menuMessage);
        try {
            System.out.println(writerController.getAll());
            System.out.println("Операция успешно выполнена");
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    public void deleteById() {
        System.out.println(menuMessage);
        System.out.println("Введите id удаляемого writer");
        Integer id = sc.nextInt();
        try {
            writerController.deleteById(id);
            System.out.println("Операция успешно выполнена");
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    public void save() {
        System.out.println(menuMessage);
        System.out.println("Введите имя writer");
        String name = sc.nextLine();
        System.out.println("Введите id для writer");
        Integer id = sc.nextInt();
        try{
            Writer newOne = new Writer(id, name, postController.getAll());
            writerController.save(newOne);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    public void update() {
        System.out.println(menuMessage);
        System.out.println("Введите имя writer");
        String name = sc.nextLine();
        System.out.println("Введите id для writer");
        Integer id = sc.nextInt();
        try{
            Writer updatedWriter = new Writer(id, name, postController.getAll());
            writerController.update(updatedWriter);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }
}


