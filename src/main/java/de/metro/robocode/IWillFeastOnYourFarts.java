package de.metro.robocode;

import robocode.*;
import static robocode.util.Utils.normalRelativeAngleDegrees;

public class IWillFeastOnYourFarts extends Robot {
    double radius = 100.0;
    double angle = 90.0;
    boolean directionLeft = true;
    double radarBearing;
    boolean isGunBehind = false;
    boolean gunMovingEnabled = false;
    @Override
    public void run() {

        while (true) {

            ahead(radius );
            setDebugProperty( "bearign", String.valueOf( radarBearing ) );
            setDebugProperty( "RadarDirection", String.valueOf( directionLeft ) );

        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
//        setAdjustRadarForGunTurn( true );
        setDebugProperty( "ScannedRobotEvent", String.valueOf( e ) );

        radarBearing = e.getBearing();

        setDebugProperty( "Distance", String.valueOf( e.getDistance() ) );
        if (Math.abs(  radarBearing ) >= 80  && Math.abs( radarBearing ) <= 100) {
            if (e.getDistance() < 330)
                fireBullet( 50 );
        }
    }

    public void onHitByBullet(HitByBulletEvent e) {
       // turnLeft(90 - e.getBearing());
    }
    public void onHitWall(HitWallEvent e) {
        final double bearing = e.getBearing();
        turnLeft(90-bearing );
        if (gunMovingEnabled == false) {
            turnGunLeft( 90 );
            //turnRadarLeft( 90 );
            gunMovingEnabled = true;
        }

    }
    public void onHitRobot(HitRobotEvent e) {
        back( radius/2 );
        turnLeft(45 );
    }
}
