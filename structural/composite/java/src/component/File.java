package component;

public class File implements FileSystemComponent {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize() {
      return size;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public FileSystemComponent cd(String path) {
        throw new UnsupportedOperationException("Cannot cd into a file");
    }

    @Override
    public void ls() {
        System.out.println(name + " (" + size + " KB)");
    }

    @Override
    public void printAll(String indent) {
        System.out.println(indent + name + " (" + size + " bytes)");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot add to a file");
    }

    @Override
    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot remove from a file");
    }
}
