public class Telephone {
    private String model;
    private String number;
    private String color;
    private boolean mobilePhone;

    public Telephone(String model, String number, String color, boolean mobilePhone) {
        this.model = model;
        this.number = number;
        this.color = color;
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return model + ", " + number + ", " + color + ", " + mobilePhone;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(boolean mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
