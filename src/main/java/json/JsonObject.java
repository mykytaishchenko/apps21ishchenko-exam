package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    List<JsonPair> pairs;

    public JsonObject(JsonPair... jsonPairs) {
        pairs = new ArrayList<>();
        pairs.addAll(Arrays.asList(jsonPairs));
    }

    @Override
    public String toJson() {
        StringBuilder res = new StringBuilder("{");
        for(JsonPair pair: this.pairs) res.append(pair.key).append(": ").append(pair.value.toJson()).append(", ");
        if (this.pairs.size() > 0) res = new StringBuilder(res.substring(0, res.length() - 2));
        res.append("}");
        return res.toString();
    }

    public void add(JsonPair jsonPair) {
        this.pairs.add(jsonPair);
    }

    public Json find(String name) {
        for(JsonPair pair: this.pairs) if (Objects.equals(pair.key, name)) return pair.value;
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject newObj = new JsonObject();
        for(JsonPair pair: this.pairs) if (Arrays.asList(names).contains(pair.key)) newObj.add(pair);
        return newObj;
    }
}
