package com.salesforce.dev;

import com.salesforce.dev.framework.Environment;
import com.salesforce.dev.pages.Base.NavigationBar;
import com.salesforce.dev.pages.Home.HomePage;
import com.salesforce.dev.pages.Leads.LeadForm;
import com.salesforce.dev.pages.Leads.LeadsHome;
import com.salesforce.dev.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Jimmy Vargas on 6/15/2015.
 */
public class CreateLead {
    HomePage homePage;
    MainPage mainPage;
    NavigationBar navBar;

    String account;
    String password;

    @BeforeMethod
    public void setUp(){
        account = Environment.getInstance().getPrimaryUser();
        password = Environment.getInstance().getPrimaryPassword();

        homePage = new HomePage();
        mainPage = homePage.loginAs(account,password);
        navBar = mainPage.gotoNavBar();
    }

    @Test
    public void createLead(){
        LeadsHome leadsHome = navBar.gotToLeadsHome();
        LeadForm leadForm = leadsHome.clickNewBtn();

        //leadForm = new LeadBuilder()
        // .build();

    }

    @AfterMethod
    public void tearDown(){

    }
}
