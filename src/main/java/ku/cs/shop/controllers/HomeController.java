package ku.cs.shop.controllers;

import javafx.fxml.FXML;
import ku.cs.shop.models.MemberCard;
import ku.cs.shop.models.MemberCardGold;


public class HomeController {
    private MemberCard john, anna, harry;

    @FXML
    public void initialize() {
        john = new MemberCard("John Smith", "081-222-8888");
        anna = new MemberCard("Anna Frost", "082-333-9999", 135);
        harry = new MemberCard("Harry Potter", "083-444-0000", 40000);
    }

}
