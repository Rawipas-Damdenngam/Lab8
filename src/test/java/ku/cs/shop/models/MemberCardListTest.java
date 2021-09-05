package ku.cs.shop.models;

import ku.cs.shop.services.MemberCardListHardCodeDataSource;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MemberCardListTest {

    private MemberCardListHardCodeDataSource dataSource;

    @Test
    void testAddCard() {
        dataSource = new MemberCardListHardCodeDataSource();
        MemberCardList list = dataSource.getCardList();

        assertEquals(6, list.countCard());

        ArrayList<MemberCard> cards = list.getAllCards();
        assertEquals(6, cards.size());
    }

    @Test
    void testSearchByPhone() {
        dataSource = new MemberCardListHardCodeDataSource();
        MemberCardList list = dataSource.getCardList();

        String phone = "083-444-0000";
        MemberCard card = list.searchCardByPhone(phone);
        assertEquals("Harry Potter", card.getName());
    }

    @Test
    void testSearchByPhoneWithNoHyphen() {
        dataSource = new MemberCardListHardCodeDataSource();
        MemberCardList list = dataSource.getCardList();

        String phone = "0834440000";
        MemberCard card = list.searchCardByPhone(phone);
        assertEquals("083-444-0000", card.getPhone());
    }

    @Test
    void testSearchByInvalidPhone() {
        dataSource = new MemberCardListHardCodeDataSource();
        MemberCardList list = dataSource.getCardList();

        String phone = "083-444-0001";
        MemberCard card = list.searchCardByPhone(phone);
        assertNull(card);
    }

    @Test
    void testAddPurchaseToCardByPhone() {
        dataSource = new MemberCardListHardCodeDataSource();
        MemberCardList list = dataSource.getCardList();

        String phone = "083-444-0000";
        list.addPurchaseByPhone(phone, 150);
        MemberCard card = list.searchCardByPhone(phone);
        assertEquals(150, card.getCumulativePurchase());
    }

    @Test
    void testUseStampByPhone() {
        dataSource = new MemberCardListHardCodeDataSource();
        MemberCardList list = dataSource.getCardList();

        String phone = "083-444-0000";
        list.useStampByPhone(phone, 15);
        MemberCard card = list.searchCardByPhone(phone);
        assertEquals(39985, card.getStamp());
    }
    @Test
    void testUsePointByPhone(){
        dataSource = new MemberCardListHardCodeDataSource();
        MemberCardList list = dataSource.getCardList();

        String phone = "082-345-6789";
        MemberCardGold card = (MemberCardGold) list.searchCardByPhone(phone);
        list.usePointByPhone(phone,15);
        assertEquals(85, card.getVipPoint());
    }


}