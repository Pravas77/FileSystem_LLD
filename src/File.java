import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class File implements Component {

    private final String name;
    private String content;
    private final ReadWriteLock lock;

    public File(String name) {
        this.name = name;
        this.content = "";
        this.lock = new ReentrantReadWriteLock();
    }

    @Override
    public void getComponent() {
        System.out.println("File Name : " + name);
    }

    public void editContent(String content) {
       lock.writeLock().lock();
       try {
           this.content = content;
       }
       finally {
           lock.writeLock().unlock();
       }
    }

    public String readContent() {
        lock.readLock().lock();
        try {
            System.out.println("File " + name + " content is -> " + content);
            return content;
        }
        finally {
            lock.readLock().unlock();
        }

    }
}
