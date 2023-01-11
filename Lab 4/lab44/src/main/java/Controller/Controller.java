package Controller;

import Integration.IntegrationService;
import Repository.Repository_Reader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.InputStream;
import java.util.Scanner;

public class Controller {
    private static Scanner scanner;

    public Controller (InputStream inputStream){
        scanner = new Scanner(inputStream);
    }

    private String Scanfunc(String text){
        System.out.println(text);
        return scanner.nextLine();
    }

    public JSONArray calculation() throws Exception {

        // комунікація з користувачем, задання даних
        double lower_limit = Double.parseDouble(Scanfunc("Введіть, будь ласка, нижню границю інтегрування"));
        double upper_limit = Double.parseDouble(Scanfunc("Введіть, будь ласка, верхню границю інтегрування"));
        int n = Integer.parseInt(Scanfunc("Введіть, будь ласка, кількість проміжків розбиття"));
        String function = Scanfunc("Введіть, будь ласка, підінтегральну функцію");
        int type = Integer.parseInt(Scanfunc("Ввведіть, будь ласка, номер методу інтегрування\nЛіві Прямокутники - 1, Праві Прямокутники - 2"));
        // перевірка на виконання умов введення
        if (!(type == 1 || type == 2)) {
            throw new Exception("Очікувалося 1 або 2");
        }

        //створення об'єкту IntegrationService
        IntegrationService integrationService = new IntegrationService(new JSONObject(), System.in, new Repository_Reader());
        //обчислення значення інтегралу
        double result = integrationService.get_result(lower_limit, upper_limit, n, type, function);
        //збереження в файл
        integrationService.save_result(lower_limit, upper_limit, n, type, function, result);
        //зчитування з файлу
        return integrationService.read();
    }
}
