package component;

public interface FileSystemComponent {
    public String getName();
    public int getSize();
    public void printAll(String indent);
    public FileSystemComponent cd(String path);
    public void ls();
    public boolean isDirectory();

    public void add(FileSystemComponent component);
    public void remove(FileSystemComponent component);
}
