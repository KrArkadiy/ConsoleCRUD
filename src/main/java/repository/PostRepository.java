package repository;

import model.Post;

public interface PostRepository extends GenericRepository<Post, Long>{

    public static void addPost(Post post){

    }

    public static void updatePost(Post post){

    }

    public static void removePost(int id){

    }
}
