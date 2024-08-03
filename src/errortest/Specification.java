package errortest;

import java.util.ArrayList;
import java.util.List;

public class Specification {
    private List<Entity> entities = new ArrayList<>();

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Specification: [\n");
        for (Entity entity : entities) {
            sb.append("  ").append(entity.toString()).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}