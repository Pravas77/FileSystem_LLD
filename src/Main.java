
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello");

        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");


        File file1 = new File("file1");
        File file2 = new File("file2");
        File file3 = new File("file3");
        File file4 = new File("file4");
        File file5 = new File("file5");

        dir1.addComponent(file1);
        dir1.addComponent(dir2);
        dir1.addComponent(file2);
        dir2.addComponent(file3);
        dir2.addComponent(file4);
        dir2.addComponent(file5);

        file3.editContent("This is file 3 content");

        dir1.getComponent();

        file1.readContent();
        file2.readContent();
        file3.readContent();
        file4.readContent();
        file5.readContent();
    }
}