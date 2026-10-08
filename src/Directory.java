import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Directory implements Component {
    private final String name;
    private List<Component> components;

    public Directory(String name) {
        this.name = name;
        this.components = new CopyOnWriteArrayList<>();
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    public void getComponent() {
        System.out.println("Directory Name : " + name);
        for (Component component : components) component.getComponent();
    }

    public Component searchComponent(String name) {
        if (name.equals(this.name)) return this;

        for (Component component : components) {
            Component matchedComponent = component.searchComponent(name);
            if (matchedComponent != null) return matchedComponent;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Directory{" + "name='" + name + '\'' + '}';
    }
}
