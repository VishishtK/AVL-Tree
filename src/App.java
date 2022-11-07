import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {

    public static AVLTree avlTree = null;

    public static void ProcessInput(String input) {
        String functionName = input.substring(0, input.indexOf("("));
        String[] params = input.substring(input.indexOf("(") + 1, input.indexOf(")")).split(",");
        switch (functionName) {
            case "Initialize":
                avlTree = new AVLTree();
                break;
            case "Insert":
                avlTree.Insert(Integer.parseInt(params[0]));
                break;
            case "Delete":
                avlTree.Delete(Integer.parseInt(params[0]));
                break;
            case "Search":
                if (params.length == 2)
                    avlTree.Search(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
                else
                    avlTree.Search(Integer.parseInt(params[0]));
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            while (line != null) {
                ProcessInput(line);
                line = reader.readLine();
            }
            avlTree.PrintTree(avlTree.root, "", true);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
