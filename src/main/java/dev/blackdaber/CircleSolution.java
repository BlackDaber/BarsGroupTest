package dev.blackdaber;

import lombok.Data;

import java.util.Arrays;

@Data
public class CircleSolution {

    public double[][] getCirclePositions(int[] center, double diameter, double resolution) {
        double twicePi = 2 * Math.PI;
        double[][] circlePositions = new double[360][2];

        for (int i = 0; i < 360; ++i) {
            double theta = twicePi * (double) i / 360.0;
            double x = diameter * Math.cos(theta) * (25.4 / resolution);
            double y = diameter * Math.sin(theta) * (25.4 / resolution);

            circlePositions[i] = new double[] {(center[0] + x), (center[1] + y)};
        }

        return circlePositions;
    }

    public static void test() {
        var circle = new CircleSolution();

        System.out.println(Arrays.deepToString(circle.getCirclePositions(new int[]{15, 15}, 5, 30)));
        System.out.println(Arrays.deepToString(circle.getCirclePositions(new int[]{15, 15}, 5, 300)));
        System.out.println(Arrays.deepToString(circle.getCirclePositions(new int[]{15, 15}, 5, 900)));
    }
}
