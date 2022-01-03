package Testcases.Railway;

import Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends TestBase {
    @Test(description = "User can book many tickets at a time")
    public void TC14() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();

        System.out.println("Pre-condition: Create and activate a new account");
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME,Constant.PASSWORD);

        System.out.println("3. Click on 'Book ticket' tab");
        homePage.gotoBookTicketPage();

        System.out.println("4. Select a Depart date from the list");
        System.out.println("5. Select 'Nha Trang' for 'Depart from' and 'Sài Gòn' for 'Arrive at'.");
        System.out.println("6. Select 'Soft seat with air conditioner' for 'Seat type'");
        System.out.println("7. Select '5' for 'Ticket amount'");
        System.out.println("8. Click on 'Book ticket' button");
        bookTicketPage.bookTicket("Nha Trang","Sài Gòn","Soft seat with air conditioner",5);

        Assert.assertEquals(bookTicketPage.getSuccessfulBookTicketMessage(),"Ticket booked successfully!");

        bookTicketPage.gotoMyTicket();

        Assert.assertEquals(myTicketPage.getBookedTicketDepartStation(),"Nha Trang");
        Assert.assertEquals(myTicketPage.getBookedTicketArriveStation(),"Sài Gòn");
        Assert.assertEquals(myTicketPage.getBookedTicketSeatType(),"Soft seat with air conditioner");
        Assert.assertEquals(myTicketPage.getBookedTicketAmount(),String.valueOf(5));
    }
}
