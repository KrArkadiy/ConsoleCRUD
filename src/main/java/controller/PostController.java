package controller;

import model.Post;
import repository.Implementation.JsonPostRepositoryImpl;
import repository.PostRepository;
import view.BasicView;

import java.util.List;
import java.util.Scanner;

public class PostController {

    PostRepository jsonPostRepository = new JsonPostRepositoryImpl();

    public PostController() {

    }

    public List<Post> getAll(){
        return jsonPostRepository.getAll();
    }

    public Post getById(Integer aInteger){
        return jsonPostRepository.getById(aInteger);
    }

    public void save(Post post){
        jsonPostRepository.save(post);
    }

    public void update(Post post){
        jsonPostRepository.update(post);
    }

    public void deleteById(Integer aInteger){
        jsonPostRepository.deleteById(aInteger);
    }
}
