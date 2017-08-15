package probabilityDensity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sidereus on 7/4/17.
 */
public class SingleHistogram extends SingleProbability {

    public SingleHistogram(double[] values) {
        super.pdf = new HashMap<>();
        super.values = values;
    }

    @Override
    protected void compute() {
        compute(values);
    }

    private void compute(double[] values) {
        int[] normalizedVals = ProbabilityUtils.normalize(values);
        compute(normalizedVals);
    }

    private void compute(int[] values) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        int valNumber = values.length;

        for (int i=0; i<valNumber; i++) {
            Integer tmpVal = values[i];
            Integer count = counter.get(tmpVal);

            if (count != null) {
                counter.replace(tmpVal, ++count);
            } else {
                counter.put(tmpVal, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet())
            pdf.put(entry.getKey(), Double.valueOf(entry.getValue()/valNumber));

    }
}
