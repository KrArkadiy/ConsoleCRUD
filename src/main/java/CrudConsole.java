import controller.LabelController;
import controller.PostController;
import controller.WriterController;
import model.Label;
import model.Post;
import model.Writer;
import repository.Implementation.JsonLabelRepositoryImpl;
import repository.Implementation.JsonPostRepositoryImpl;
import repository.Implementation.JsonWriterRepositoryImpl;
import utility.Utility;
import view.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudConsole {
    public static void main(String[] args) {
        ConsoleFunctionality consoleFunctionality = new ConsoleFunctionality();
        consoleFunctionality.run();
    }
}

