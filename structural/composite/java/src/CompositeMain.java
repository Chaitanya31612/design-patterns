import component.*;

public class CompositeMain {
    public static void main(String[] args) {
        FileSystemComponent root = new Folder("root");

        root.add(new File("file1.txt", 100));
        root.add(new File("file2.txt", 200));

        FileSystemComponent docs = new Folder("docs");
        docs.add(new File("doc1.txt", 50));
        docs.add(new File("doc2.txt", 100));
        root.add(docs);

        // root.printAll("");
        // root.ls();
        System.out.println(root.getSize());

    }
}
