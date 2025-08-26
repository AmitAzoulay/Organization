import java.io.Serializable;

public class Gender implements Serializable{
    String value;

    public Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    @Override
    public String toString() {
        return value;
    }
}