package controller;

import model.Post;
import repository.Implementation.JsonPostRepositoryImpl;
import view.BasicView;

import java.util.List;
import java.util.Scanner;

public class PostController {

    PostController postController;

    public PostController() {

    }

    public List<Post> getAll(){
        return postController.getAll();
    }

    public Post getById(Integer aInteger){
        return postController.getById(aInteger);
    }

    public void save(Post post){
        postController.save(post);
    }

    public void update(Post post){
        postController.update(post);
    }

    public void deleteById(Integer aInteger){
        postController.deleteById(aInteger);
    }
}
