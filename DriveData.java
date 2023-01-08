public class DriveData {
    double chassis_width; // width between wheels, meters
    double chassis_length; // length between wheels, meters
    double max_speed; // max wheel velocity, m/sec

    public double getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(double max_speed) {
        this.max_speed = max_speed;
    }

    public double getChassis_width() {
        return chassis_width;
    }

    public void setChassis_width(double chassis_width) {
        this.chassis_width = chassis_width;
    }

    public double getChassis_length() {
        return chassis_length;
    }

    public void setChassis_length(double chassis_length) {
        this.chassis_length = chassis_length;
    }

    public DriveData(double chassis_width, double chassis_length, double max_speed) {
        this.chassis_width = chassis_width;
        this.chassis_length = chassis_length;
        this.max_speed = max_speed;
    }

}
