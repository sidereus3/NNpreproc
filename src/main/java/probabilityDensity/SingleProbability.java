package probabilityDensity;

import java.util.HashMap;

/**
 * Created by sidereus on 7/4/17.
 */
public abstract class SingleProbability {

    protected HashMap<Integer, Double> pdf;
    protected double[] values;

    abstract protected void compute();

    public HashMap<Integer, Double> getPDF() {
        compute();
        return pdf;
    }

}
