public class Normalization {
    public double[][] Normalization(double[][] data) {

        //min-max normalization
        int i, j;
        for (i = 0; i < data.length; i++) {
            for (j = 0; j < 2; j++) {
                //fruit data -> min value = 40, max value = 110
                data[i][j] = (0.8 * ((data[i][j] - 40) / (110 - 40))) + 0.1;
            }
        }
        return data;
    }
}
