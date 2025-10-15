package IGOR;

import robocode.*;
// import java.awt.Color;

public class Igor extends Robot {

    // Função principal do robô
    public void run() {
<<<<<<< HEAD
=======
	    // Ir para o centro da arena no inicio
		double largura = getBattleFieldWidth();
		double altura = getBattleFieldHeight();
		
        double centroX = largura / 2;
		double centroY = altura / 2;
		
        double dx = centroX - getX();
		double dy = centroY - getY();
		double angulo = Math.toDegrees(Math.atan2(dx, dy));
		turnRight(normalRelativeAngleDegrees(angulo - getHeading()));
		ahead(Math.hypot(dx, dy));
		
>>>>>>> 8c84579 (Initial commit)
        // Cores opcionais
        // setColors(Color.red, Color.blue, Color.green); // corpo, canhão, radar

        while (true) {
            ahead(100);
            turnGunRight(360);
            back(100);
            turnGunRight(360);
        }
    }

    // Quando vê outro robô
    public void onScannedRobot(ScannedRobotEvent e) {
        // Mira no inimigo
        double angleToEnemy = getHeading() + e.getBearing() - getGunHeading();
        double turnGunAmount = normalRelativeAngleDegrees(angleToEnemy);
        turnGunRight(turnGunAmount);

        // Tiro com força baseada na distância
        double distance = e.getDistance();
        double firePower = 1;
        if (distance < 200) {
<<<<<<< HEAD
            firePower = 3;
        } else if (distance < 500) {
            firePower = 2;
=======
            firePower = 4;
        } else if (distance < 500) {
            firePower = 3;
>>>>>>> 8c84579 (Initial commit)
        }

        fire(firePower);
    }

    // Quando é atingido por um tiro
    public void onHitByBullet(HitByBulletEvent e) {
        turnRight(90);
        ahead(100);
    }

    // Quando bate na parede
    public void onHitWall(HitWallEvent e) {
        back(20);
        turnRight(90);
    }

    // Método para normalizar o ângulo entre -180 e 180 graus
    double normalRelativeAngleDegrees(double angle) {
        while (angle > 180) angle -= 360;
        while (angle < -180) angle += 360;
        return angle;
    }
}