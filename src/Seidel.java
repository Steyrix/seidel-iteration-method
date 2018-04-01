import java.util.ArrayList;


public class Seidel {
    public static ArrayList<Double> calculate(double matrix[][], double b[], int n, double epsilon){
        ArrayList<Double> xValues = new ArrayList<>(n);

        //RU: Инициализируем массив иксов
        //EN: Initialise array of X'es
        for(int i = 0; i < n; i++){
            xValues.add(new Double(0));
        }

        int k = 0;
        double prevX = 0;

        while(xValues.get(n-1) - prevX > epsilon || k == 0) {

            prevX = xValues.get(n-1);

            System.out.println("k = " + k);
            System.out.println("");

            double x = 0;

            for(int i = 0; i < n; i++) {

                for(int j = 0; j < n; j++) {
                    //RU: Рассчитываем Xi. Xi += (Xij * Aij)
                    //EN: Calculate Xi. Xi += (Xij * Aij)
                    x += xValues.get(j) * matrix[i][j];
                }

                //RU: Добавляем свободный член
                //EN: Summation with free term
                x += b[i];
                //RU: Обновляем Xi
                //EN: Updating Xi
                xValues.set(i,x);
                System.out.print("X" + (i+1) +": " + x);
                System.out.println("");

                x = 0;
            }

            k++;
        }

        return xValues;
    }
}
