import java.util.Scanner;

public class Query {
    public Query() {
        TrainingNetwork trainingNetwork = new TrainingNetwork();
        Variables variables = new Variables();
        Normalization normalization = new Normalization();


        Scanner input = new Scanner(System.in);
        double weight, volume;

        System.out.print("\n\nWeight:");
        weight = input.nextInt();
        System.out.println("\nVolume");
        volume = input.nextInt();


        //min-max normalization
        //fruit data -> min value = 40, max value = 110
        weight = (0.8 * ((weight - 40) / (110 - 40))) + 0.1;
        volume = (0.8 * ((volume - 40) / (110 - 40))) + 0.1;
        double net = weight * trainingNetwork.variables.getWeight1() + volume * trainingNetwork.variables.getWeight2() + variables.getLn();


        System.out.println("\n\n w1: " + trainingNetwork.variables.getWeight1() +
                "\nw2: " + trainingNetwork.variables.getWeight2() +
                "\n learn rate: " + trainingNetwork.variables.getLn() +
                "\nw1*y1: " + weight * trainingNetwork.variables.getWeight1() +
                "\nw2y2: " + volume * trainingNetwork.variables.getWeight2() +
                "\n net: " + net);

        if (net < 0) {
            System.out.println("\nThat is Orange\n");
        } else if (net >= 0) {
            System.out.println("\nThat is Apple\n\n");
        }
    }
}
