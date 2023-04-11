package jobsity;

public abstract class Storm {

  protected double eyeRadius;
  protected double eyePositionX;
  protected double eyePositionY;



  public double getEyeRadius() {
    return eyeRadius;
  }

  public void setEyeRadius(double eyeRadius) {
    this.eyeRadius = eyeRadius;
  }

  public double getEyePositionX() {
    return eyePositionX;
  }

  public void setEyePositionX(double eyePositionX) {
    this.eyePositionX = eyePositionX;
  }

  public double getEyePositionY() {
    return eyePositionY;
  }

  public void setEyePositionY(double eyePositionY) {
    this.eyePositionY = eyePositionY;
  }

  public boolean isInEyeOfTheStorm(double positionX, double positionY) {
    double distance = Math.sqrt(Math.pow(positionX - eyePositionX, 2) +
        Math.pow(positionY - eyePositionY, 2));
    return distance < eyeRadius;
  }
}
