package json;

public class Main {
    public static void main(String[] args) {
        JsonObject jsonObject = new JsonObject(new JsonPair("name", new JsonString("Oles")));
        jsonObject.add(new JsonPair("age", new JsonNumber(19)));

        String expectedJSON = "{'name': 'Oles', 'age': 19}";

        System.out.println(jsonObject.toJson());
    }
}
