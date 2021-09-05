package ku.cs.shop.models;

public class MemberCardSilver extends MemberCard{

    private int vipPoint;
    private int stampCount;

    public MemberCardSilver(String name, String phone, int stamp,int vipPoint) {
        super(name, phone, stamp);
        this.vipPoint = vipPoint;
    }

    @Override
    public void addPurchase(double purchase) {
        if (purchase < 0) {
            return;
        }
        setCumulativePurchase(getCumulativePurchase() + purchase);
        setStamp(getStamp() + (int) purchase / 40);

        stampCount += (int) purchase / 40;
        if (stampCount >= 10) {
            vipPoint += stampCount / 100;
            stampCount %= 10;
        }
    }

    public String useVipPoint (int vipPoint){
        if (vipPoint < 0){
            return "Error VIP point";
        }
        if (this.vipPoint >= vipPoint) {
            this.vipPoint -= vipPoint;
            return "You get a gift voucher 100 Baht";
        }
        return "You don't have enough VIP point";
    }

    public int getVipPoint () {
        return vipPoint;
    }
}


