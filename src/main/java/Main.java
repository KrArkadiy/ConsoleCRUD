import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import model.Label;
import repository.Implementation.JsonLabelRepositoryImpl;
import repository.Implementation.*;
import utility.Utility;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        JsonLabelRepositoryImpl label = new JsonLabelRepositoryImpl();
        label.deleteById(1);
    }
}



