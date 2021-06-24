import repository.Implementation.JsonLabelRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        JsonLabelRepositoryImpl label = new JsonLabelRepositoryImpl();
        label.deleteById(1);
    }
}



