import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

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
                if (params.length == 2) {
                    List<Node> nodes = avlTree.Search(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
                    if (nodes == null) {
                        System.out.println("NULL");
                    } else {
                        String output = "";
                        for (Node node : nodes) {
                            output += node.value + ",";
                        }
                        output = output.substring(0, output.length()-1);
                        System.out.println(output);
                    }
                } else {
                    Node node = avlTree.Search(Integer.parseInt(params[0]));
                    if (node == null) {
                        System.out.println("NULL");
                    } else {
                        System.out.println(node.value);
                    }
                }
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
            // avlTree.PrintTree();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
