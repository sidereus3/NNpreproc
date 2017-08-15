package mutualInformation;

import probabilityDensity.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sidereus on 7/4/17.
 */
public class MutualInformation {

    HashMap<Integer, Double> xPDF;
    HashMap<Integer, Double> yPDF;
    HashMap<Pair<Integer, Integer>, Double> xyPDF;

    public MutualInformation(double[] independentVar, double[] dependentVar) {
        this.xPDF = new SingleHistogram(independentVar).getPDF();
        this.yPDF = new SingleHistogram(dependentVar).getPDF();
        this.xyPDF = new JointHistogram(independentVar, dependentVar).getPDF();
    }

    public double compute() {
        double mutualInformation = 0.0;

        for (Map.Entry<Pair<Integer, Integer>, Double> entry : xyPDF.entrySet()) {
            double jointProbability = entry.getValue();
            double xProbability = xPDF.get(entry.getKey().a);
            double yProbability = yPDF.get(entry.getKey().b); // @TODO: was xPDF (probably refuse copying the previous line) => to check

            if (jointProbability != 0.0
                    && xProbability != 0.0
                    && yProbability != 0.0)
                mutualInformation += Math.log(jointProbability / (xProbability * yProbability));

        }

        return mutualInformation / xyPDF.size();
    }
}
