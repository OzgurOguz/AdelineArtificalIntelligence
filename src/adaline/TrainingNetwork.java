
public class TrainingNetwork {
    Data data = new Data();
    Normalization normalization = new Normalization();
    Variables variables = new Variables();

    double[][] normData = normalization.Normalization(data.Data());
    double[] net = new double[data.Data().length];

    public TrainingNetwork() {

        int iteration = 0;
        int i = 0;
        variables.setWeight1(0.1);
        variables.setWeight2(0.1);
        variables.setLn(0.1);
        variables.setAlpha(0.5);
        boolean isEnd = true;

        int[] expectedValue = new int[data.Data().length];

        while (i < data.Data().length) {
            if (i < data.Data().length / 2)
                expectedValue[i] = -1;
            else if (i >= data.Data().length / 2)
                expectedValue[i] = 1;
            i++;
        }

        while (isEnd) {
            System.out.println("\n\n\n\n--------------" + iteration + ". iteration-----------------\n");
            for (i = 0; i < data.Data().length; i++) {
                net[i] = normData[i][0] * variables.getWeight1() + normData[i][1] * variables.getWeight2() + variables.getAlpha();
                System.out.println("\n\n" + i + ". data    net=" + net[i] + "\n");
                System.out.println("expected value " + i + ": " + expectedValue[i]);


                if (net[i] < 0) {
                    if (expectedValue[i] < 0) {
                        System.out.println(i + " value -> Orange");
                    } else if (expectedValue[i] == 1) {
                        variables.setError(expectedValue[i] - Integer.signum((int) Math.floor(net[i])));
                        variables.setWeight1(variables.getWeight1() + variables.getLn() * variables.getError() * normData[i][0]);
                        variables.setWeight2(variables.getWeight2() + variables.getLn() * variables.getError() * normData[i][1]);
                        variables.setAlpha(variables.getAlpha() + variables.getLn() * variables.getError());

                        System.out.println("xxx");
                    } else {
                        System.out.println("There is error. Erase & Rewind\n");
                    }
                } else if (net[i] >= 0) {
                    if (expectedValue[i] > 0) {
                        System.out.println(iteration + 1 + " value -> Apple\n");
                    } else {
                        variables.setError(expectedValue[i] - Integer.signum((int) Math.floor(net[i])));
                        variables.setWeight1(variables.getWeight1() + variables.getLn() * variables.getError() * normData[i][0]);
                        variables.setWeight2(variables.getWeight2() + variables.getLn() * variables.getError() * normData[i][1]);
                        variables.setAlpha(variables.getAlpha() + variables.getLn() * variables.getError());

                        System.out.println("yyy");
                    }
                }
                System.out.println("\nweight1: " + variables.getWeight1() +
                        "\nweight2: " + variables.getWeight2() +
                        "\nlearning rate: " + variables.getLn());
            }
            iteration++;
            for (int j = 0; j < data.Data().length; j++) {
                if (net[j] > 0 && expectedValue[j] == -1 || net[j] < 0 && expectedValue[j] == 1) {
                    isEnd = true;
                    break;
                } else isEnd = false;

            }
        }

    }
}


