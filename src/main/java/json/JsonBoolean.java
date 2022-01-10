package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {
    private final boolean val;

    public JsonBoolean(Boolean bool) {
        this.val = bool;
    }

    @Override
    public String toJson() {
        return String.valueOf(this.val);
    }
}
