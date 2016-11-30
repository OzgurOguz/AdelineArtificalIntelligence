/**
 * Created by ozgur on 30.11.2016.
 */
public class Variables {

    double weight1, weight2;
    double ln;          //learning rate
    double alpha;       //activation value
    int Error;          //global Error

    public double getWeight1() {
        return weight1;
    }

    public void setWeight1(double weight1) {
        this.weight1 = weight1;
    }

    public double getWeight2() {
        return weight2;
    }

    public void setWeight2(double weight2) {
        this.weight2 = weight2;
    }

    public double getLn() {
        return ln;
    }

    public void setLn(double ln) {
        this.ln = ln;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public int getError() {
        return Error;
    }

    public void setError(int error) {
        Error = error;
    }
}
