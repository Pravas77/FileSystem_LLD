public class Main {
    public static void main(String[] args) {

        System.out.println("Hello");

        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");

        File file1 = new File("file1");
        File file2 = new File("file2");
        File file3 = new File("file3");
        File file4 = new File("file4");

        dir2.addComponent(file3);
        dir2.addComponent(file4);

        dir1.addComponent(file1);
        dir1.addComponent(dir2);
        dir1.addComponent(file2);


        dir1.getComponent();

        String result1 = dir1.searchComponent("dir2") != null ? dir1.searchComponent("dir2").toString() : "No match";
        System.out.println(result1);

        String result2 = dir1.searchComponent("file4") != null ? dir1.searchComponent("file4").toString() : "No match";
        System.out.println(result2);

        String result3 = dir1.searchComponent("file5") != null ? dir1.searchComponent("file5").toString() : "No match";
        System.out.println(result3);

    }
}