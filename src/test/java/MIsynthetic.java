import mutualInformation.MutualInformation;
import org.junit.Test;

import java.util.Random;

public class MIsynthetic {

    @Test
    public void mi() {
        Random rand = new Random();
        double[] err = new double[420];
        double standardDeviation = 1;
        double mean = 0;

        for(int i=0; i<err.length; i++)
            err[i] = rand.nextGaussian()*standardDeviation + mean;

        double[] value = new double[420];
        value[0] = 0;

        for(int i=1; i<value.length; i++)
            value[i] = 0.9*value[i-1] + 0.866*err[i];

        double[] val = new double[50];
        double[] val1 = new double[50];
        double[] val2 = new double[50];

        for(int i=19; i<val1.length+19; i++) {
            val[i-19] = value[i];
            val1[i-19] = value[i-1];
            val2[i-19] = value[i-2];
        }

        MutualInformation mi = new MutualInformation(val, val2);
        System.out.println(mi.compute());

    }

}
