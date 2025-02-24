package com.shaunthomas999.topcoder;

import java.util.ArrayList;
import java.util.Collection;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Created by shaunthomas on 15/01/17.
 */
public class AirlineInternet2 {
    double[][] airport;
    int[][] flights;

    public static void main(String args[]) {
        AirlineInternet2 airlineInternet = new AirlineInternet2();

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

    public double minimumRange(String[] airportLocations, String[] flight) {
        /*
         *   Reading input ~ start
         */
        airport = new double[airportLocations.length][2];
        for(int i = 0; i < airportLocations.length;i++)
        {
            String[] s = airportLocations[i].split(" ");
            airport[i][0] = Integer.valueOf(s[0]);
            airport[i][1] = Integer.valueOf(s[1]);
        }
        flights = new int[flight.length][4];
        for(int i = 0; i < flight.length;i++)
        {
            String[] s = flight[i].split(" ");
            flights[i][0] = Integer.valueOf(s[0]);
            flights[i][1] = Integer.valueOf(s[1]);
            flights[i][2] = Integer.valueOf(s[2]);
            flights[i][3] = Integer.valueOf(s[3]);
        }

        /*
         *   Reading input ~ end
         */

        double min = 0.0,max=1e12;
        int iter = 0;
        while(iter < 100)
        {
            double guess = (min+max)/2;
            if(work(guess))
            {
                max = guess;
            }else{
                min = guess;
            }
            iter++;
        }
        return (min+max)/2;
    }
    double eps = 1e-12;

    private boolean work(double guess) {
        ArrayList<Double> cp = new ArrayList<Double>();

        for(int i = 0; i < flights.length;i++)
        {

            for(int j = 0; j < airport.length;j++)
            {
                double x0 = airport[flights[i][0]][0];
                double y0 = airport[flights[i][0]][1];
                double x1 = airport[flights[i][1]][0];
                double y1 = airport[flights[i][1]][1];
                double t0 = flights[i][2];
                double t1 = flights[i][3];
                double a = (y1-y0)/(t1-t0);
                double b = (x1-x0)/(t1-t0);

                double c = airport[j][0];
                double d = airport[j][1];

                double m = a*a+b*b;
                double n = 2*a*(y0-d)+2*b*(x0-c);
                double o = pow(y0-d,2)+pow(x0-c,2)-pow(guess,2);
                cp.addAll(solve(m,n,o,t0,t1));
            }
            for(int j = i+1;j< flights.length;j++)
            {

                double x0 = airport[flights[i][0]][0];
                double y0 = airport[flights[i][0]][1];
                double x1 = airport[flights[i][1]][0];
                double y1 = airport[flights[i][1]][1];
                double t0 = flights[i][2];
                double t1 = flights[i][3];
                double a = (y1-y0)/(t1-t0);
                double b = (x1-x0)/(t1-t0);

                double ox0 = airport[flights[j][0]][0];
                double oy0 = airport[flights[j][0]][1];
                double ox1 = airport[flights[j][1]][0];
                double oy1 = airport[flights[j][1]][1];
                double ot0 = flights[j][2];
                double ot1 = flights[j][3];
                double oa = (oy1-oy0)/(ot1-ot0);
                double ob = (ox1-ox0)/(ot1-ot0);

                double ts = max(t0,ot0);
                double te = min(t1,ot1);
                if(ts >= te) continue;


                double c = ox0+ob*(ts-ot0);
                double d = oy0+oa*(ts-ot0);
                x0 += b*(ts-t0);
                y0 += a*(ts-t0);
                a -= oa;
                b -= ob;

                double m = a*a+b*b;
                double n = 2*a*(y0-d)+2*b*(x0-c);
                double o = pow(y0-d,2)+pow(x0-c,2)-pow(guess,2);
                Collection<Double> temp = solve(m,n,o,ts,te);
                cp.addAll(temp);
            }

        }

        for(double a: cp)
        {
            if(legal(guess,a) == false) return false;
        }
        return true;
    }
    private Collection<Double> solve(double m, double n, double o, double t0, double t1) {
        double d = t0;
        ArrayList<Double> cp = new ArrayList<Double>();
        double f = (-n + sqrt(n*n-4.0*m*o))/(2.0*m);
        double g = (-n - sqrt(n*n-4.0*m*o))/(2.0*m);
        if(Double.isNaN(f) == false && f+d >= t0 && f+d <= t1)
        {
            cp.add(f-eps+d);
            cp.add(f+eps+d);
        }
        if(Double.isNaN(g) == false && g+d >= t0 && g+d <= t1)
        {
            cp.add(g-eps+d);
            cp.add(g+eps+d);
        }
        return cp;
    }
    int[] have;
    double[][] loc;
    int at;
    double guess;
    private boolean legal(double g, double time)
    {
        guess = g;
        loc = new double[flights.length+airport.length][2];
        have = new int[flights.length+airport.length];
        at = 0;
        for(int i = 0; i < flights.length;i++)
        {
            if(time < flights[i][2] || time > flights[i][3]) continue;
            double p = (time-flights[i][2])/(flights[i][3]-flights[i][2]);
            loc[at][0] = (1-p)*airport[flights[i][0]][0]+p*airport[flights[i][1]][0];
            loc[at][1] = (1-p)*airport[flights[i][0]][1]+p*airport[flights[i][1]][1];
            have[at] = 0;
            at++;
        }
        for(int i = 0; i < airport.length;i++)
        {
            loc[at][0] = airport[i][0];
            loc[at][1] = airport[i][1];
            have[at] = 1;
            at++;
        }
        for(int i = 0; i < at;i++)
        {
            if(have[i] == 1)
                dfs(i);
        }
        for(int i = 0; i < at;i++)
        {
            if(have[i] == 0) return false;
        }
        return true;
    }

    private void dfs(int t) {
        if(have[t] == 2) return;
        have[t] = 2;
        for(int i = 0; i < at;i++)
        {
            if(have[i] == 0 && pow(loc[i][0]-loc[t][0],2)+pow(loc[i][1]-loc[t][1],2) <= guess*guess)
            {
                dfs(i);
            }
        }
    }

    /*
    void print(double[][] a)
    {
        for(double[] c: a)
        {
            for(double b:c)
                System.out.print(b+" ");
            System.out.println();
        }
        System.out.println();
    }
    */
}
