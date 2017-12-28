package de.metro.robocode;

import java.awt.Color;
import robocode.*;

public class IWillFeastOnYourFarts extends Robot {
    double radius = 100.0;
    double angle = 90.0;
    boolean directionLeft = true;
    double radarBearing;
    boolean disengageSpam = false;
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
        setDebugProperty( "ScannedRobotEvent", String.valueOf( asde ) );

        radarBearing = e.getBearing();
        if ( radarBearing >=0 && radarBearing <= 5)
            fireForBearingBetween( 0, 10 );
        setDebugProperty( "Distance", String.valueOf( e.getDistance() ) );
        //if (e.getDistance() < 330)
            fireForBearingBetween(80,100);
    }

    private void fireForBearingBetween( final int i, final int i1 ) {
        if (Math.abs(  radarBearing ) >= i && Math.abs( radarBearing ) <= i1) {

            fireBullet( 500 );
        }
    }

    public void onHitByBullet(HitByBulletEvent e) {
       // turnLeft(90 - e.getBearing());
    }
    public void onHitWall(HitWallEvent e) {
        final double bearing = e.getBearing();
        turnLeft(90-bearing );
        if ( !gunMovingEnabled ) {
            turnGunLeft( 90 );
            //turnRadarLeft( 90 );
            gunMovingEnabled = true;
            setBodyColor( Color.PINK );
            setGunColor( Color.black );
            setRadarColor( Color.yellow );
            setBulletColor( Color.pink );
        }

    }

    @Override
    public void onBulletMissed( final BulletMissedEvent event ) {
        disengageSpam = true;
        super.onBulletMissed( event );
    }

    @Override
    public void onBulletHit( final BulletHitEvent event ) {
        disengageSpam = false;
        super.onBulletHit( event );
    }


    public void onHitRobot(HitRobotEvent e) {

        turnGunRight( 90 );

        int times = (int) ( e.getEnergy()/3 );
        while (times >=0 && !disengageSpam) {
            fireBullet(1000000  );
            times --;
        }
        turnGunLeft( 90 );
        back( radius/2 );
        turnLeft(45 );
    }
}
