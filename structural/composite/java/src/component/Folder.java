package component;

import java.util.*;

public class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children;

    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    @Override
    public int getSize() {
        int size = 0;
        for (FileSystemComponent child: children) {
            size += child.getSize();
        }
        return size;
    }

    @Override
    public void printAll(String indent) {
        System.out.println(indent + "+ " + name);
        for (FileSystemComponent child: children) {
            child.printAll(indent + "  ");
        }
    }

    @Override
    public FileSystemComponent cd(String path) {
        for (FileSystemComponent child: children) {
          if (child.isDirectory() && child.getName().equals(path)) {
              return child;
          }
        }
        return null;
    }

    @Override
    public void ls() {
      // this will not expand folders, printAll will
      for (FileSystemComponent child: children) {
        System.out.println(child.getName());
      }
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

    public void add(FileSystemComponent child) {
        children.add(child);
    }

    public void remove(FileSystemComponent child) {
        children.remove(child);
    }
}
