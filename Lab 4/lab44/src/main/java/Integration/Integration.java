package Integration;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Argument;

public class Integration {
    private final double lower_limit, upper_limit;
    private final int n;
    private final String function;

    public Integration( double lower_limit, double upper_limit, int n, String function){
        this.lower_limit = lower_limit;
        this.upper_limit = upper_limit;
        this.n = n;
        this.function = function;
    }

    public double Integralcaclulation_pp(){
        // Метод, що рахує інтеграли за формулою правих прямокутників
        double result = 0;
        if (lower_limit< upper_limit){
            //визначення кроку
            double step = (upper_limit-lower_limit)/n;
            int i = 1;
            while (i < n){
                double curx = lower_limit+i*(step);
                Expression expression = new Expression(function, new Argument("x = " + curx));
                result+=expression.calculate()*step;
                i++;
            }
        } else throw new RuntimeException();
        return result;
    }

    public double Integralcaclulation_lp(){
        // Метод, що рахує інтеграли за формулою лівих прямокутників
        double result = 0;
        if (lower_limit< upper_limit){
            //визначення кроку
            double step = (upper_limit-lower_limit)/n;
            int i = 1;
            while (i < n){
                double curx = lower_limit+(i-1)*(step);
                Expression expression = new Expression(function, new Argument("x = " + curx));
                result+=expression.calculate()*step;
                i++;
            }
        } else throw new RuntimeException();
        return result;
    }
}
