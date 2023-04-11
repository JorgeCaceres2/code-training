package jobsity;

public class SnowStorm extends Storm {

  private double amountOfSnow;

  public SnowStorm(double eyeRadius, double eyePositionX, double eyePositionY, double amountOfSnow) {
    this.eyeRadius = eyeRadius;
    this.eyePositionX = eyePositionX;
    this.eyePositionY = eyePositionY;
    this.amountOfSnow = amountOfSnow;
  }

  public double getAmountOfSnow() {
    return amountOfSnow;
  }

  public void setAmountOfSnow(double amountOfSnow) {
    this.amountOfSnow = amountOfSnow;
  }
}
