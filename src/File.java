import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class File implements Component {

    private final String name;

    public File(String name) {
        this.name = name;
    }

    public void getComponent() {
        System.out.println("File Name : " + name);
    }

    public Component searchComponent(String name) {
        if (name.equals(this.name)) return this;
        else return null;
    }

    @Override
    public String toString() {
        return "File{" + "name='" + name + '\'' + '}';
    }
}
