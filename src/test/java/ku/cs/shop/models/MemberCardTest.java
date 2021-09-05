package ku.cs.shop.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberCardTest {

    @Test
    void testAddPurchase() {
        // input, expected output, actual output
        // input + expected => test case
        MemberCard card = new MemberCard("John Smith", "080-123-4567");
        card.addPurchase(49);
        card.addPurchase(51);
        double expected = 100; // output ที่คาดว่าจะเป็น (ไม่เกี่ยวกับโค้ด)
        double actual = card.getCumulativePurchase(); // output จากการเขียนโค้ด

        assertEquals(expected, actual);
    }

    @Test
    void testAddNegativePurchase() {
        MemberCard card = new MemberCard("John Smith", "080-123-4567");
        card.addPurchase(-100);
        card.addPurchase(85);
        card.addPurchase(-85);
        assertEquals(85, card.getCumulativePurchase());
    }

    @Test
    void testAddPurchaseToSeeStamp() {
        MemberCard card = new MemberCard("John Smith", "080-123-4567");
        card.addPurchase(49);
        card.addPurchase(51);
        assertEquals(1, card.getStamp());
    }

    @Test
    @DisplayName("มีแสตมป์เพียงพอ เอาไปใช้ได้")
    void testUseStampCase1() {
        MemberCard card = new MemberCard("John Smith", "080-123-4567", 12);
        assertEquals(true, card.useStamp(10));
        assertEquals(2, card.getStamp());
    }

    @Test
    @DisplayName("มีแสตมป์ไม่เพียงพอ ไม่ควรใช้ได้")
    void testUseStampCase2() {
        MemberCard card = new MemberCard("John Smith", "080-123-4567");
        card.addPurchase(500); // ได้ 10 stamps
        assertEquals(false, card.useStamp(15));
        assertEquals(10, card.getStamp());
    }

    @Test
    @DisplayName("ใช้แสตมป์ด้วยค่าลบ ไม่ควรทำได้")
    void testUseStampCase3() {
        MemberCard card = new MemberCard("John Smith", "080-123-4567", 12);
        assertEquals(false, card.useStamp(-100));
    }

    @Test
    @DisplayName("ใช้แสตมป์ด้วยค่าลบ ไม่ควรทำได้ และจำนวนแสตมป์คงเดิม")
    void testUseStampCase4() {
        MemberCard card = new MemberCard("John Smith", "080-123-4567", 12);
        card.useStamp(-100);
        assertEquals(12, card.getStamp());
    }

    @Test
    @DisplayName("ลองใช้ member card silver ซื้อ 4000 ได้แสมป์ 100 ดวง และ VIP point 1")
        void testMemberCardSilverAddPurchase(){
            MemberCardSilver a = new MemberCardSilver("a", "081-234-5678", 0, 0);
            a.addPurchase(4000);
            assertEquals(100, a.getStamp());
            assertEquals(1,a.getVipPoint());
        }
    @Test
    @DisplayName("ลองใช้ แต้ม VIP point")
    void testMemberCardSilverUseVipPoint(){
        MemberCardSilver b = new MemberCardSilver("b", "081-234-5678", 0, 10);
        assertEquals("You get a gift voucher 100 Baht", b.useVipPoint(10));

    }
    @Test
    @DisplayName("ลองใช้ แต้ม VIP point แต่ไม่พอ")
    void testMemberCardSilverUseVipPoint2(){
        MemberCardSilver b = new MemberCardSilver("b", "081-234-5678", 0, 0);
        assertEquals("You don't have enough VIP point", b.useVipPoint(2));

    }
    @Test
    @DisplayName("ลองใช้ member card gold ซื้อ 3000 ได้แสมป์ 100 ดวง และ VIP point 1")
    void testMemberCardGoldAddPurchase(){
        MemberCardGold a = new MemberCardGold("a", "081-234-5678", 0, 0);
        a.addPurchase(3000);
        assertEquals(100, a.getStamp());
        assertEquals(1,a.getVipPoint());
    }
    @Test
    @DisplayName("ลองใช้ แต้ม VIP point")
    void testMemberCardGoldUseVipPoint(){
        MemberCardGold b = new MemberCardGold("b", "081-234-5678", 0, 10);
        assertEquals("You get a gift voucher 150 Baht", b.useVipPoint(10));

    }
    @Test
    @DisplayName("ลองใช้ แต้ม VIP point แต่ไม่พอแลกของ")
    void testMemberCardGoldUseVipPoint2(){
        MemberCardGold b = new MemberCardGold("b", "081-234-5678", 0, 0);
        b.useVipPoint(20);
        assertEquals(0,b.getVipPoint());

    }

}