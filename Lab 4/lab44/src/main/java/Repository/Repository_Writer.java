package Repository;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Repository_Writer {

    private final JSONObject json;
    private final Scanner scanner;

    public Repository_Writer(JSONObject json, InputStream inputStream){
        this.json = json;
        this.scanner = new Scanner(inputStream);
    }

    public void write_result(double lower_limit, double upper_limit, int n, int type,String function, double result){

        System.out.println("Українська - 1\nEnglish - 2\nEnter 1 or 2, please: ");
        int choice = scanner.nextInt();

        //Перевіряємо що вибрав користувач і на основі цього за допомогою методу json.put() записуємо дані у файл
        switch (choice) {
            case 1 -> {
                json.put("Функція", function);
                json.put("Межі інтегрування", "["+lower_limit+";"+upper_limit+"]");
                json.put("Кількість проміжків", n);
                //визначення кроку
                json.put("Крок", (upper_limit-lower_limit)/n);
                switch (type){
                    case 1 -> json.put("Метод розв'язання", "Ліві прямокутники");
                    case 2 -> json.put("Метод розв'язання", "Праві прямокутники");
                }
                json.put("Результат обчислення", result);
            }
            case 2 -> {
                json.put("Function", function);
                json.put("Limits of integration", "["+lower_limit+";"+upper_limit+"]");
                json.put("Number of intervals", n);
                //визначення кроку
                json.put("Step", (upper_limit-lower_limit)/n);
                switch (type){
                    case 1 -> json.put("Method of counting", "Left rectangles");
                    case 2 -> json.put("Method of counting", "Right rectangles");
                }
                json.put("Result", result);
            }
        }

        JSONArray result_text = new JSONArray();
        result_text.add(json);

        //блок для запису даних у файл
        try(FileWriter fileWriter = new FileWriter("Result.json")) {
            fileWriter.write(result_text.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
