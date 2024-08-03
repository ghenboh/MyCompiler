package errortest;

import java.util.ArrayList;
import java.util.List;

public class Entity {
    private String type;
    private String id;
    private List<Entity> members = new ArrayList<>();
    private String value;
    private boolean status = true;

    public Entity() {

    }

    public Entity(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setValue(String id) {
        this.value = id;
    }

    public String getValue() {
        return value;
    }

    public void addEntity(Entity member) {
        members.add(member);
    }

    public List<Entity> getEntitys() {
        return members;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type).append(" ").append(id);
        if(value != null) {
            sb.append(" ").append(value);
        }
        sb.append(" ").append(status);
        if(members.size() > 0) {
            sb.append(": [\n");
            for (Entity member : members) {
                sb.append("    ").append(member.toString()).append("\n");
            }
            sb.append("  ]");
        }
        return sb.toString();
    }
}
