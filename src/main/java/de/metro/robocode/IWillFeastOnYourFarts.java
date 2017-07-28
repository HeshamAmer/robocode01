package de.metro.robocode;

import java.util.Random;
import robocode.*;
import static robocode.util.Utils.normalRelativeAngleDegrees;

public class IWillFeastOnYourFarts extends Robot {
    double radius = 100.0;
    double angle = 90.0;
    boolean directionLeft = true;
    double radarBearing;
    @Override
    public void run() {

        while (true) {
            ahead(radius );
           // turnGunLeft(angle);
           // fireBullet(getEnergy());
            if (directionLeft) {
                turnRadarLeft( angle );
                turnGunLeft( angle );
            } else {
                turnRadarRight( angle );
                turnGunRight( angle );
            }
            setDebugProperty( "bearign", String.valueOf( radarBearing ) );
            setDebugProperty( "RadarDirection", String.valueOf( directionLeft ) );

        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        Double gunTurnAmt = normalRelativeAngleDegrees(e.getBearing() + (getHeading() - getRadarHeading()));
        turnGunRight(gunTurnAmt);

        setAdjustRadarForGunTurn( true );
//        radarBearing = e.getBearing();
//        turnGunLeft( radarBearing );
        //bearing is from 0 to 180 if infront, and
        if (radarBearing >= 90 ) {
            directionLeft= true;
        } else {
            directionLeft=false;
        }

      //  fire(1);
      //  fireBullet(getEnergy());
    }

    public void onHitByBullet(HitByBulletEvent e) {
       // turnLeft(90 - e.getBearing());
    }
    public void onHitWall(HitWallEvent e) {
        final double bearing = e.getBearing();
        turnLeft(90-bearing );
    }
    public void onHitRobot(HitRobotEvent e) {
        final double bearing = e.getBearing();
        back( radius/2 );
        turnLeft(90-bearing );
    }
}
