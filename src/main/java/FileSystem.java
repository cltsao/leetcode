import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FileSystem {
    class Node {
        boolean isFile;
        SortedMap<String, Node> children;
        StringBuilder content;
        Node(boolean isFile) {
            this.isFile = isFile;
            if (isFile)
                content = new StringBuilder();
            else
                children = new TreeMap<>();
        }
    }

    Node root;

    public FileSystem() {
        root = new Node(false);
    }

    public List<String> ls(String path) {
        Node node = root;
        String[] segments = path.substring(1).split("/");
        for(String segment : segments) {
            if(segment.length() > 0)
                node = node.children.get(segment);
        }
        if (node.isFile) return List.of(segments[segments.length - 1]);
        else return node.children.keySet().stream().collect(Collectors.toList());
    }

    public void mkdir(String path) {
        Node node = root;
        String[] segments = path.substring(1).split("/");
        for(String segment : segments) {
            if (!node.children.containsKey(segment)) {
                node.children.put(segment, new Node(false));
            }
            node = node.children.get(segment);
        }
    }

    public void addContentToFile(String filePath, String content) {
        Node node = root;
        String[] segments = filePath.substring(1).split("/");
        for(int i = 0; i < segments.length - 1; ++i) {
            String segment = segments[i];
            node = node.children.get(segment);
        }
        String fileName = segments[segments.length - 1];
        if (!node.children.containsKey(fileName))
            node.children.put(fileName, new Node(true));
        node.children.get(fileName).content.append(content);
    }

    public String readContentFromFile(String filePath) {
        Node node = root;
        String[] segments = filePath.substring(1).split("/");
        for(String segment : segments) {
            node = node.children.get(segment);
        }
        return node.content.toString();
    }
}
