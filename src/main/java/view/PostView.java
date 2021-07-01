package view;

import controller.LabelController;
import controller.PostController;
import model.Label;
import model.Post;

import java.util.Scanner;


public class PostView extends BasicView{
    PostController postController;
    LabelController labelController;

    private final String menuMessage = "Выберете действие над post:\n" +
            "1. Получение post по номеру\n" +
            "2. Вывести список всех post\n" +
            "3. Добавить post\n" +
            "4. Редактировать post\n" +
            "5. Удалить post\n" +
            "6. Выход";

    public PostView(Scanner sc, PostController postController) {
        this.sc = sc;
        this.postController = postController;
    }

    public void getById() {
        System.out.println(menuMessage);
        Integer id = sc.nextInt();
        try {
            postController.getById(id);
            System.out.println("Операция успешно выполнена");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    public void getAll() {
        System.out.println(menuMessage);
        try {
            System.out.println(postController.getAll());
            System.out.println("Операция успешно выполнена");
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    public void deleteById() {
        System.out.println(menuMessage);
        System.out.println("Введите id удаляемого post");
        Integer id = sc.nextInt();
        try {
            postController.deleteById(id);
            System.out.println("Операция успешно выполнена");
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    public void save() {
        System.out.println(menuMessage);
        System.out.println("Введите содержание post");
        String content = sc.nextLine();
        System.out.println("Введите id для post");
        Integer id = sc.nextInt();
        try{
            Post newOne = new Post(id, content, labelController.getAll());
            postController.save(newOne);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    public void update() {
        System.out.println(menuMessage);
        System.out.println("Введите содержание post");
        String content = sc.nextLine();
        System.out.println("Введите id для post");
        Integer id = sc.nextInt();
        try{
            Post updatedPost = new Post(id, content, labelController.getAll());
            postController.update(updatedPost);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }
}

