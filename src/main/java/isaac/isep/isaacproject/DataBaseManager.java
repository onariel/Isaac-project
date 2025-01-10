package isaac.isep.isaacproject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")

public class DataBaseManager {

    private static final String JSON_FILE_PATH = "src/main/resources/data.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void writeObjectToJson(Object object) {
        String className = object.getClass().getSimpleName();

        // Load existing JSON file or create a new one if it doesn't exist
        JsonObject rootObject = loadOrInitializeJson();

        // Serialize the object
        JsonElement serializedObject = gson.toJsonTree(object);

        // Add the object to its category
        if (!rootObject.has(className)) {
            rootObject.add(className, gson.toJsonTree(new HashMap<String, Object>()));
        }

        JsonObject category = rootObject.getAsJsonObject(className);
        category.add("Instance_" + System.currentTimeMillis(), serializedObject);

        // Write back to the file
        writeJsonToFile(rootObject);
    }

    public static void removeObjectFromJson(Object object) {
        String className = object.getClass().getSimpleName();

        // Load existing JSON file
        JsonObject rootObject = loadOrInitializeJson();

        if (!rootObject.has(className)) {
            System.out.println("Category " + className + " does not exist in the database.");
            return;
        }

        JsonObject category = rootObject.getAsJsonObject(className);
        JsonElement serializedObject = gson.toJsonTree(object);

        // Find and remove the matching object
        boolean removed = false;
        for (Map.Entry<String, JsonElement> entry : category.entrySet()) {
            if (entry.getValue().equals(serializedObject)) {
                category.remove(entry.getKey());
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Object removed from " + className + " category.");
        } else {
            System.out.println("Object not found in " + className + " category.");
        }

        // If the category is empty after removal, remove the category
        if (category.size() == 0) {
            rootObject.remove(className);
        }

        // Write back to the file
        writeJsonToFile(rootObject);
    }

    public static void clearDatabase() {
        // Load existing JSON file
        JsonObject rootObject = loadOrInitializeJson();

        // Clear all entries within each category but retain the categories
        for (Map.Entry<String, JsonElement> entry : rootObject.entrySet()) {
            entry.setValue(new JsonObject());
        }

        // Write the updated JSON object to the file
        writeJsonToFile(rootObject);

        System.out.println("Database has been cleared while retaining categories.");
    }

    public static void modifyObjectAttribute(Object object, String attributeName, Object newValue) {
        String className = object.getClass().getSimpleName();

        // Load existing JSON file
        JsonObject rootObject = loadOrInitializeJson();

        if (!rootObject.has(className)) {
            System.out.println("Category " + className + " does not exist in the database.");
            return;
        }

        JsonObject category = rootObject.getAsJsonObject(className);
        JsonElement serializedObject = gson.toJsonTree(object);

        // Find the matching object
        for (Map.Entry<String, JsonElement> entry : category.entrySet()) {
            if (entry.getValue().equals(serializedObject)) {
                JsonObject targetObject = entry.getValue().getAsJsonObject();

                if (!targetObject.has(attributeName)) {
                    System.out.println("Attribute " + attributeName + " does not exist in the object.");
                    return;
                }

                // Modify the attribute with the provided value
                JsonElement newElement = gson.toJsonTree(newValue);
                targetObject.add(attributeName, newElement);

                // Write the updated JSON object to the file
                writeJsonToFile(rootObject);

                System.out.println("Attribute " + attributeName + " of object in category " + className + " has been updated to " + newValue + ".");
                return;
            }
        }

        System.out.println("Object not found in category " + className + ".");
    }

    public static JsonObject getAllAttributes(Object object) {
        String className = object.getClass().getSimpleName();

        // Load existing JSON file
        JsonObject rootObject = loadOrInitializeJson();

        if (!rootObject.has(className)) {
            System.out.println("Category " + className + " does not exist in the database.");
            return null;
        }

        JsonObject category = rootObject.getAsJsonObject(className);
        JsonElement serializedObject = gson.toJsonTree(object);

        // Find the matching object
        for (Map.Entry<String, JsonElement> entry : category.entrySet()) {
            if (entry.getValue().equals(serializedObject)) {
                return entry.getValue().getAsJsonObject();
            }
        }

        System.out.println("Object not found in category " + className + ".");
        return null;
    }

    public static void getSpecificAttribute(Object object, String attributeName) {
        JsonObject attributes = getAllAttributes(object);

        if (attributes != null && attributes.has(attributeName)) {
            attributes.get(attributeName);
            return;
        }

        System.out.println("Attribute " + attributeName + " not found for the specified object.");
    }

    private static JsonObject loadOrInitializeJson() {
        Path path = Paths.get(JSON_FILE_PATH);

        if (Files.exists(path)) {
            try {
                String jsonContent = Files.readString(path);
                if (jsonContent.isEmpty()) {
                    return new JsonObject();
                }
                return JsonParser.parseString(jsonContent).getAsJsonObject();
            } catch (IOException | IllegalStateException e) {
                e.printStackTrace();
            }
        }

        return new JsonObject(); // Return a new JsonObject if file doesn't exist or fails to load
    }

    private static void writeJsonToFile(JsonObject jsonObject) {
        try (FileWriter fileWriter = new FileWriter(JSON_FILE_PATH)) {
            gson.toJson(jsonObject, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getExistingObjects(Object object) {
        String className = object.getClass().getSimpleName();

        // Load existing JSON file
        JsonObject rootObject = loadOrInitializeJson();

        if (!rootObject.has(className)) {
            System.out.println("Category " + className + " does not exist in the database.");
            return null;
        }

        JsonObject category = rootObject.getAsJsonObject(className);
        return List.copyOf(category.keySet());
    }

    public static void main(String[] args) {
        clearDatabase();
    }
}