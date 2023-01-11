package Integration;

import Repository.Repository_Reader;
import Repository.Repository_Writer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.InputStream;

public class IntegrationService {
    private final Repository_Writer repositoryWriter;
    private final Repository_Reader repositoryReader;

    public IntegrationService(JSONObject jsonObject, InputStream inputStream, Repository_Reader reader){
        this.repositoryWriter = new Repository_Writer(jsonObject, inputStream);
        this.repositoryReader = reader;
    }

    public double get_result (double lower_limit, double upper_limit, int n, int type, String function){
        //Метод, що викликає методи для підрахунку інтегралів в залежності від заданої формули (лівих чи правих прямокутників)
        Integration integration = new Integration(lower_limit, upper_limit, n, function);
        if (type == 1) {
            return integration.Integralcaclulation_lp();
        } else if (type == 2) {
            return integration.Integralcaclulation_pp();
        } else return 0;
    }

    public void save_result(double lower_limit, double upper_limit, int n, int type, String function, double result){
        repositoryWriter.write_result(lower_limit, upper_limit, n, type, function, result);
    }

    public JSONArray read(){
        return repositoryReader.read();
    }
}
