package ku.cs.shop.models;

import java.util.ArrayList;

public class MemberCardList {
    private ArrayList<MemberCard> cards;

    public MemberCardList() {
        cards = new ArrayList<>();
    }

    public void addCard(MemberCard card) {
        cards.add(card);
    }

    public ArrayList<MemberCard> getAllCards() {
        return cards;
    }

    public void addPurchaseByPhone(String phone, double purchase) {
        MemberCard card = searchCardByPhone(phone);
        card.addPurchase(purchase);
    }


    public void useStampByPhone(String phone, int stamp) {
        MemberCard card = searchCardByPhone(phone);
        card.useStamp(stamp);
    }
    public void usePointByPhone(String phone,int point){
        MemberCardGold cardGold = (MemberCardGold) searchCardByPhone(phone);
        cardGold.useVipPoint(point);
    }

    public MemberCard searchCardByPhone(String phone) {
        for (MemberCard card : cards) {
            if (card.checkPhone(phone)) {
                return card;
            }
        }
        return null;
    }



    public int countCard() {
        return cards.size();
    }

}
