package com.shaunthomas999.topcoder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Shaun Thomas
 */
public class AirlineInternet {

    /**
     * Template for holding location as x & y co-ordinates
     */
    class Location {
        private double x;
        private double y;

        public Location(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        @Override
        public String toString() {
            return "{ "+ x +" "+ y +"}";
        }
    }

    /**
     * Template for holding flight information
     */
    class Flight {
        private int startAirportIndex;
        private int destinationAirportIndex;
        private int takeOffTime;
        private int landingTime;
        private double speed;

        public Flight(int startAirportIndex, int destinationAirportIndex, int takeOffTime, int landingTime, double speed) {
            this.startAirportIndex = startAirportIndex;
            this.destinationAirportIndex = destinationAirportIndex;
            this.takeOffTime = takeOffTime;
            this.landingTime = landingTime;
            this.speed = speed;
        }

        public int getStartAirportIndex() {
            return startAirportIndex;
        }

        public int getDestinationAirportIndex() {
            return destinationAirportIndex;
        }

        public int getTakeOffTime() {
            return takeOffTime;
        }

        public int getLandingTime() {
            return landingTime;
        }

        public double getSpeed() {
            return speed;
        }

        @Override
        public String toString() {
            return "{ "+ startAirportIndex +" "+ destinationAirportIndex +" "+ takeOffTime +" "+ landingTime +" "+ speed +" }";
        }
    }

    /**
     * Main method - Contains test methods
     * @param args
     */
    public static void main(String args[]) {
        AirlineInternet airlineInternet = new AirlineInternet();

        // Testdata - 0
        String[] airportLocations0 = {"0 0","100 0"};
        String[] flights0 = {"0 1 0 100"};
        double expResult0 = 50.0;
        double actualResult0 = airlineInternet.minimumRange(airportLocations0, flights0);
        System.out.println("Actual Result : " + actualResult0 +" - Expected Result : "+expResult0);

        // Testdata - 1
        String[] airportLocations1 = {"0 0","100 0"};
        String[] flights1 = {"0 1 0 100","0 1 25 125","0 1 50 150","0 1 75 175"};
        double expResult1 = 25.0;
        double actualResult1 = airlineInternet.minimumRange(airportLocations1, flights1);
        System.out.println("Actual Result : " + actualResult1 +" - Expected Result : "+expResult1);

        // Testdata - 2
        String[] airportLocations2 = {"25 100","0 50","90 150","22 22","60 1","95 8","12 40"};
        String[] flights2 = {"0 1 0 500","2 5 10 300","2 0 100 200" ,"3 6 150 400","4 5 50 450","5 1 0 300" ,"2 6 10 100"};
        double expResult2 = 64.28201130009927;
        double actualResult2 = airlineInternet.minimumRange(airportLocations2, flights2);
        System.out.println("Actual Result : " + actualResult2 +" - Expected Result : "+expResult2);

        // Testdata - 3
        String[] airportLocations3 = {"0 0","50 0","100 0"};
        String[] flights3 = {"0 1 0 100"};
        double expResult3 = 25.0;
        double actualResult3 = airlineInternet.minimumRange(airportLocations3, flights3);
        System.out.println("Actual Result : " + actualResult3 +" - Expected Result : "+expResult3);

        // Testdata - 4
        String[] airportLocations4 = {"417 262","519 592","941 778"};
        String[] flights4 = {"0 1 376 534","0 2 603 763","1 0 137 431" ,"0 1 525 583","2 1 367 551","0 1 953 996" ,"0 1 668 886"};
        double expResult4 = 246.618769031594;
        double actualResult4 = airlineInternet.minimumRange(airportLocations4, flights4);
        System.out.println("Actual Result : " + actualResult4 +" - Expected Result : "+expResult4);


        // Testdata - 5
        String[] airportLocations5 = {"101 591","283 183","346 696","436 638","738 46"};
        String[] flights5 = {"3 0 855 890","2 0 260 698","3 4 229 743" ,"1 2 519 898","3 1 863 955","4 0 407 993" ,"2 4 872 969","0 3 320 663"};
        double expResult5 = 298.18759041416865;
        double actualResult5 = airlineInternet.minimumRange(airportLocations5, flights5);
        System.out.println("Actual Result : " + actualResult5 +" - Expected Result : "+expResult5);
    }

    /**
     * Calculates the minimum range of transceiver
     * @param airportLocations Location of airport as array of coordinates(string) separated by space
     * @param flights Flight information as array of string with start airport index, desination airport index,
     *                take-off time and landing time information separated by space
     * @return Minimum range of transceiver
     */
    public double minimumRange(String[] airportLocations, String[] flights) {

        // Transform airportLocation String as Location object and add to list
        List<Location> airportLocationList = new ArrayList<>();
        for (String airportLocation : airportLocations) {
            airportLocationList.add(
                new Location(
                    Double.parseDouble(airportLocation.substring(0,airportLocation.indexOf(" "))),
                    Double.parseDouble(airportLocation.substring(airportLocation.indexOf(" ")+1))
                )
            );
        }

        // Transform flight String as Flight object and add to list
        List<Flight> flightList = new ArrayList<>();
        for (String flight : flights) {
            String[] flightDetail = flight.split(" ");

            int startAirportIndex = Integer.parseInt(flightDetail[0]);
            int destAirportIndex = Integer.parseInt(flightDetail[1]);
            int takeOffTime = Integer.parseInt(flightDetail[2]);
            int landingTime = Integer.parseInt(flightDetail[3]);

            double distance = distanceBetweenLocations(
                airportLocationList.get(startAirportIndex), airportLocationList.get(destAirportIndex));
            int travellingTime = landingTime - takeOffTime;

            flightList.add(
                new Flight(
                    startAirportIndex,
                    destAirportIndex,
                    takeOffTime,
                    landingTime,
                    distance/travellingTime
                )
            );
        }

        // Find the lowest take-off time and highest landing time
        Integer lowestTakeOffTime = null;
        Integer highestLandingTime = null;
        Iterator<Flight> flightListIter = flightList.iterator();
        while(flightListIter.hasNext()) {
            Flight flight = flightListIter.next();
            if((lowestTakeOffTime == null) || (lowestTakeOffTime > flight.getTakeOffTime())){
                lowestTakeOffTime = flight.getTakeOffTime();
            }
            if((highestLandingTime == null) || (highestLandingTime < flight.getLandingTime())) {
                highestLandingTime = flight.getLandingTime();
            }
        }

        // Calculate the minimum range
        double range = 0.0;
        Double shortestDistance;
        for(int time = lowestTakeOffTime ; time <= highestLandingTime ; time++) {
            // Add all current flying flight locations to list
            List<Location> flightLocationList = new ArrayList<>();
            flightListIter = flightList.iterator();
            while(flightListIter.hasNext()) {
                Flight flight = flightListIter.next();

                // Check whether the flight is flying based on take-off and landing time
                if((flight.getTakeOffTime() < time) && (flight.getLandingTime() > time)) {
                    flightLocationList.add(findFlightLocationAt(airportLocationList, flight, time));
                }
            }

            // Current flight locations and airport locations to location list
            List<Location> locationList = new ArrayList<>();
            locationList.addAll(flightLocationList);
            locationList.addAll(airportLocationList);

            // Every flying flight at current time is compared against all airports and other flying flights
            for(int i = 0 ; i < flightLocationList.size() ; i++) {
                Location location1 = flightLocationList.get(i);
                shortestDistance = null;

                // Find the distance to the closest flight or airport
                for(int j = 0 ; j < locationList.size() ; j++) {
                    if(i == j) { // Don't execute logic for the same flight
                        continue;
                    }
                    Location location2 = locationList.get(j);
                    double comparedDistance = distanceBetweenLocations(location1, location2);
                    if((shortestDistance == null) || (comparedDistance < shortestDistance)) {
                        shortestDistance = comparedDistance;
                    }
                }

                // Set the distance of flight which is farthest from the nearest transceiver as range
                range = (shortestDistance > range) ? shortestDistance : range;
            }
        }

        return range;
    }

    /**
     * Find the distance between two locations using Pythagoras's theorem
     * @param l1 Location 1
     * @param l2 Location 2
     * @return distance between location 1 and location 2
     */
    private double distanceBetweenLocations(Location l1, Location l2) {
        return Math.hypot(l1.getX()-l2.getX(), l1.getY()-l2.getY());
    }

    /**
     * Find the location of a flight at a given point of time
     * @param airportLocationList List of airport locations
     * @param flight Flight whose location is to be calculated
     * @param time Current time under consideration
     * @return Location of flight
     */
    private Location findFlightLocationAt(List<Location> airportLocationList, Flight flight, int time) {
        Location startLocation = airportLocationList.get(flight.getStartAirportIndex());
        Location destinationLocation = airportLocationList.get(flight.getDestinationAirportIndex());
        double distance = distanceBetweenLocations(startLocation, destinationLocation);

        double distanceRatio = ((time - flight.getTakeOffTime()) * flight.getSpeed()) / distance;

        double xCoordinate = (1.0 - distanceRatio) * startLocation.getX() + distanceRatio * destinationLocation.getX();
        double yCoordinate = (1.0 - distanceRatio) * startLocation.getY() + distanceRatio * destinationLocation.getY();

        return new Location(xCoordinate, yCoordinate);
    }
}
