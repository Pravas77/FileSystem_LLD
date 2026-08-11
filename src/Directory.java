import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Directory implements Component {
    private final String name;
    private List<Component> components;
    private final ReadWriteLock lock;

    public Directory(String name) {
        this.name = name;
        this.components = new ArrayList<>();
        this.lock = new ReentrantReadWriteLock();
    }

    public void addComponent(Component component) {
        lock.writeLock().lock();
        try {
            components.add(component);
        } finally {
            lock.writeLock().unlock();
        }

    }

    public void removeComponent(Component component) {
        lock.writeLock().lock();
        try {
            components.remove(component);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void getComponent() {
        List<Component> copyComponents;
        lock.readLock().lock();
        try {
            copyComponents = new ArrayList<>(components);
        } finally {
            lock.readLock().unlock();
        }

        System.out.println("Directory Name : " + name);
        for (Component component : copyComponents) component.getComponent();


    }
}
