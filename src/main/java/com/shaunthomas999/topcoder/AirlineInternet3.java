package com.shaunthomas999.topcoder;

/**
 * Created by shaunthomas on 16/01/17.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AirlineInternet3 {

    public static void main(String args[]) {
        AirlineInternet3 airlineInternet = new AirlineInternet3();

        // 0 - 50.0
        String[] airportLocations2 = {"0 0","100 0"};
        String[] flights2 = {"0 1 0 100"};
        //System.out.println(airlineInternet.minimumRange(airportLocations2, flights2));

        // 1 - 25.0
        String[] airportLocations3 = {"0 0","100 0"};
        String[] flights3 = {"0 1 0 100","0 1 25 125","0 1 50 150","0 1 75 175"};
        //System.out.println(airlineInternet.minimumRange(airportLocations3, flights3));

        // 2 - 64.28201130009927
        String[] airportLocations6 = {"25 100","0 50","90 150","22 22","60 1","95 8","12 40"};
        String[] flights6 = {"0 1 0 500","2 5 10 300","2 0 100 200" ,"3 6 150 400","4 5 50 450","5 1 0 300" ,"2 6 10 100"};
        double result6 = airlineInternet.minimumRange(airportLocations6, flights6);
        double expResult6 = 64.28201130009927;
        System.out.println("a : " + result6 +" - o : "+expResult6+" - d : "+ (result6-expResult6));

        // 4 - 246.618769031594
        String[] airportLocations1 = {"417 262","519 592","941 778"};
        String[] flights1 = {"0 1 376 534","0 2 603 763","1 0 137 431" ,"0 1 525 583","2 1 367 551","0 1 953 996" ,"0 1 668 886"};
        //System.out.println(airlineInternet.minimumRange(airportLocations1, flights1));
        double result1 = airlineInternet.minimumRange(airportLocations1, flights1);
        double expResult1 = 246.618769031594;
        System.out.println("a : " + result1 +" - o : "+expResult1+" - d : "+ (result1-expResult1));

        // 5 - 298.18759041416865
        String[] airportLocations4 = {"101 591","283 183","346 696","436 638","738 46"};
        String[] flights4 = {"3 0 855 890","2 0 260 698","3 4 229 743" ,"1 2 519 898","3 1 863 955","4 0 407 993" ,"2 4 872 969","0 3 320 663"};
        //System.out.println(airlineInternet.minimumRange(airportLocations4, flights4));
        double result4 = airlineInternet.minimumRange(airportLocations4, flights4);
        double expResult4 = 298.18759041416865;
        System.out.println("a : " + result4 +" - o : "+expResult4+" - d : "+ (result4-expResult4));

        // 6 - 358.8652253980556
        String[] airportLocations5 = {"152 998","656 487","75 999","913 535"};
        String[] flights5 = {"1 0 347 530","0 3 75 819","3 1 893 935" ,"1 0 971 992","2 0 471 887","2 0 924 955"};
        //System.out.println(airlineInternet.minimumRange(airportLocations5, flights5));
        double result5 = airlineInternet.minimumRange(airportLocations5, flights5);
        double expResult5 = 358.8652253980556;
        System.out.println("a : " + result5 +" - o : "+expResult5+" - d : "+ (result5-expResult5));
    }

    public double minimumRange(String[] airportLocations, String[] flights) {
        int m = airportLocations.length;
        double[] x = new double[m];
        double[] y = new double[m];
        for (int i = 0; i < m; ++i) {
            try (Scanner scanner = new Scanner(airportLocations[i])) {
                x[i] = scanner.nextInt();
                y[i] = scanner.nextInt();
            }
        }
        int n = flights.length;
        int[] src = new int[n];
        int[] dst = new int[n];
        int[] start = new int[n];
        int[] finish = new int[n];
        double[] vx = new double[n];
        double[] vy = new double[n];

        for (int i = 0; i < n; ++i) {
            double dx;
            double dy;
            try (Scanner scanner = new Scanner(flights[i])) {
                src[i] = scanner.nextInt();
                dst[i] = scanner.nextInt();
                start[i] = scanner.nextInt();
                finish[i] = scanner.nextInt();
            }
            dx = x[dst[i]] - x[src[i]];
            dy = y[dst[i]] - y[src[i]];
            dx /= (finish[i] - start[i]);
            dy /= (finish[i] - start[i]);
            vx[i] = dx;
            vy[i] = dy;
        }
        double left = 0;
        double right = 5000;
        while ((right - left) / right > 1e-11) {
            double middle = (left + right) / 2;
            List<Double> important = new ArrayList<Double>();
            important.add(0.0); // Starting possible position
            important.add(1000.0); // Ending possible position
            for (int i = 0; i < n; ++i) {
                important.add(start[i] + 0.0);
                important.add(finish[i] + 0.0);
                for (int j = 0; j < m; ++j) {
                    addImportants(important, x[src[i]] - x[j], y[src[i]] - y[j], vx[i], vy[i], finish[i] - start[i], middle, start[i]);
                }
                for (int j = i + 1; j < n; ++j) {
                    if (start[i] < finish[j] && start[j] < finish[i]) {
                        double tl = Math.max(start[i], start[j]);
                        double tr = Math.min(finish[i], finish[j]);
                        double xi = x[src[i]] + vx[i] * (tl - start[i]);
                        double yi = y[src[i]] + vy[i] * (tl - start[i]);
                        double xj = x[src[j]] + vx[j] * (tl - start[j]);
                        double yj = y[src[j]] + vy[j] * (tl - start[j]);
                        addImportants(important, xi - xj, yi - yj, vx[i] - vx[j], vy[i] - vy[j], tr - tl, middle, tl);
                    }
                }
            }
            Collections.sort(important);
            boolean[] conn = new boolean[n];
            double[] cx = new double[n];
            double[] cy = new double[n];
            boolean ok = true;
            for (int i = 0; i < important.size() - 1; ++i) {
                double t = (important.get(i) + important.get(i + 1)) / 2.0;
                for (int j = 0; j < n; ++j) {
                    conn[j] = false;
                    if (t < start[j]) {
                        cx[j] = x[src[j]];
                        cy[j] = y[src[j]];
                    } else if (t > finish[j]) {
                        cx[j] = x[dst[j]];
                        cy[j] = y[dst[j]];
                    } else {
                        cx[j] = x[src[j]] + vx[j] * (t - start[j]);
                        cy[j] = y[src[j]] + vy[j] * (t - start[j]);
                    }
                }
                for (int j = 0; j < m; ++j)
                    mark(x[j], y[j], -1, conn, cx, cy, n, middle);
                for (int j = 0; j < n; ++j)
                    if (!conn[j]) {
                        ok = false;
                        break;
                    }
                if (!ok)
                    break;
            }
            if (ok)
                right = middle;
            else
                left = middle;
        }
        return right;
    }

    private void mark(double x, double y, int id, boolean[] conn, double[] cx, double[] cy, int n, double r) {
        if (id >= 0) {
            conn[id] = true;
        }
        for (int i = 0; i < n; ++i) {
            double dx = x - cx[i];
            double dy = y - cy[i];
            if (!conn[i] && (dx * dx + dy * dy <= r * r))
                mark(cx[i], cy[i], i, conn, cx, cy, n, r);
        }
    }

    private void addImportants(List<Double> important, double x, double y, double vx, double vy, double t, double r, double delta) {
        if (t == 0)
            return;
        double x2 = x + vx * t;
        double y2 = y + vy * t;
        int s1 = (int) Math.signum(x * x + y * y - r * r);
        int s2 = (int) Math.signum(x2 * x2 + y2 * y2 - r * r);
        if (s1 <= 0 && s2 <= 0)
            return;
        if (s1 > 0 && s2 > 0) {
            if (x * vx + y * vy >= 0 || x2 * vx + y2 * vy <= 0)
                return;
            double z = -(x * vx + y * vy) / (vx * vx + vy * vy);
            double x3 = x + vx * z;
            double y3 = y + vy * z;
            int s3 = (int) Math.signum(x3 * x3 + y3 * y3 - r * r);
            if (s3 > 0)
                return;
            important.add(getImportant(x, y, vx, vy, z, r) + delta);
            important.add(delta + t - getImportant(x2, y2, -vx, -vy, t - z, r));
        } else if (s2 <= 0) {
            important.add(getImportant(x, y, vx, vy, t, r) + delta);
        } else if (s1 <= 0) {
            important.add(delta + t - getImportant(x2, y2, -vx, -vy, t, r));
        }
    }

    private double getImportant(double x, double y, double vx, double vy, double t, double rad) {
        double l = 0;
        double r = t;
        while ((r - l) / r > 1e-12) {
            double m = (r + l) / 2;
            double cx = x + vx * m;
            double cy = y + vy * m;
            if (cx * cx + cy * cy - rad * rad > 0)
                l = m;
            else
                r = m;
        }
        return r;
    }

}
