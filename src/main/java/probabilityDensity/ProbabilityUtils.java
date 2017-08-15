package probabilityDensity;

/**
 * Created by sidereus on 7/4/17.
 */
public class ProbabilityUtils {

    public static int[] normalize(double[] inputData) {

        int[] normalizedData = new int[inputData.length];
        int currentValue;
        int minVal = (int) Math.floor(inputData[0]);

        for (int i = 0; i < inputData.length; i++) {
            currentValue = (int) Math.floor(inputData[i]);
            normalizedData[i] = currentValue;

            minVal = (currentValue < minVal) ? currentValue : minVal;
        }

        for (int i = 0; i < inputData.length; i++)
            normalizedData[i] -= minVal;

        return normalizedData;
    }
}
