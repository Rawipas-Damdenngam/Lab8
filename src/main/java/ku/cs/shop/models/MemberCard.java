package ku.cs.shop.models;

public class MemberCard {

    private String name;
    private String phone;
    private double cumulativePurchase;
    private int stamp;

    public MemberCard(String name, String phone, int stamp) {
        this.name = name;
        this.phone = phone;
        this.stamp = stamp;
        cumulativePurchase = 0;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public boolean checkPhone(String phone) {
        phone = phone.replaceAll("-", "");
        String myPhone = this.phone.replaceAll("-", "");
        return myPhone.equals(phone);
    }

    public double getCumulativePurchase() {
        return cumulativePurchase;
    }

    public int getStamp() {
        return stamp;
    }


    public void addPurchase(double purchase) {
        if (purchase < 0) {
            return;
        }
        cumulativePurchase += purchase;
        stamp += purchase / 50;
    }

    public boolean useStamp(int stamp) {
        if (stamp < 0) {
            return false;
        }
        if (this.stamp >= stamp) {
            this.stamp -= stamp;
            return true;
        }
        return false;
    }

    public void setCumulativePurchase(double cumulativePurchase) {
        this.cumulativePurchase = cumulativePurchase;
    }

    public void setStamp(int stamp) {
        this.stamp = stamp;
    }

    public MemberCard(String name, String phone) {
        this(name, phone, 0);
    }


}
