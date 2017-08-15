package probabilityDensity;

import java.util.HashMap;

/**
 * Created by sidereus on 7/4/17.
 */
public abstract class JointProbability {

    protected HashMap<Pair<Integer, Integer>, Double> pdf;
    protected Object xVal;
    protected Object yVal;

    abstract protected void compute();

    public HashMap<Pair<Integer, Integer>, Double> getPDF() {
        compute();
        return pdf;
    }
}
