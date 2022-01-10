package domain;

import json.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private final Tuple<String, Integer>[] exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exams = exams;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add(new JsonPair("name", new JsonString(name)));
        jsonObject.add(new JsonPair("surname", new JsonString(surname)));
        jsonObject.add(new JsonPair("year", new JsonNumber(year)));
        List<JsonObject> arr = new ArrayList<>();
        for(Tuple<String, Integer> exam: exams) {
            arr.add(new JsonObject(
                    new JsonPair("course", new JsonString(exam.key)),
                    new JsonPair("mark", new JsonNumber(exam.value)),
                    new JsonPair("passed", new JsonBoolean(exam.value > 2))
            ));
        }
        jsonObject.add(new JsonPair("exams", new JsonArray(arr.toArray(new Json[0]))));
        return jsonObject;
    }
}