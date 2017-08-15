package probabilityDensity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sidereus on 7/4/17.
 */
public class JointHistogram extends JointProbability {

    /**
     * @TODO: xVal and yVal length must be equal
     * @param xVal
     * @param yVal
     */
    public JointHistogram(double[] xVal, double[] yVal) {
        super.pdf = new HashMap<>();
        super.xVal = xVal;
        super.yVal = yVal;
    }

    @Override
    protected void compute() {
        compute((double[]) xVal, (double[]) yVal);
    }

    private void compute(double[] xVal, double[] yVal) {
        int[] xNormVal = ProbabilityUtils.normalize(xVal);
        int[] yNormVal = ProbabilityUtils.normalize(yVal);
        compute(xNormVal, yNormVal);
    }

    private void compute(int[] xValues, int[] yValues) {
        HashMap<Pair<Integer, Integer>, Integer> jointCounter = new HashMap<>();
        int valNumber = xValues.length;

        for (int i=0; i<valNumber; i++) {
            Integer xTmpVal = xValues[i];
            Integer yTmpVal = yValues[i];
            Pair<Integer, Integer> jointTmpVal = new Pair<>(xTmpVal, yTmpVal);

            Integer count = jointCounter.get(jointTmpVal);

            if(count != null) {
                jointCounter.replace(jointTmpVal, ++count);
            } else {
                jointCounter.put(jointTmpVal, 1);
            }

        }

        for (Map.Entry<Pair<Integer, Integer>, Integer> entry : jointCounter.entrySet()) {
            pdf.put(entry.getKey(), Double.valueOf(entry.getValue() / valNumber));
        }

    }

}
