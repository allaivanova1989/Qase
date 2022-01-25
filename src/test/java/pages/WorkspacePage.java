package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class WorkspacePage {
    public static final By MEMBERS = By.xpath("//span[contains(text(),'Members')]");
    public static final By INVITES = By.xpath("//span[contains(text(),'Invites')]");
    public static final By GROUPS = By.xpath("//span[contains(text(),'Groups')]");
    public static final By ROLES = By.xpath("//span[contains(text(),'Roles')]");
    public static final By CUSTOM_FIELDS = By.xpath("//span[contains(text(),'Custom Fields')]");
    public static final By TAGS = By.xpath("//span[contains(text(),'Tags')]");
    public static final By ATTACHMENTS = By.xpath("//span[contains(text(),'Attachments')]");
    public static final By LOGS= By.xpath("//span[contains(text(),'Logs')]");
    public static final By SETTINGS= By.xpath("//span[contains(text(),'Settings')]");
    public static final By SECURITY= By.xpath("//span[contains(text(),'Security')]");

    public void switghToMembers(){
        $(MEMBERS).click();
    }
    public void switchToInvites(){
        $(INVITES).click();
    }
    public void switchToRoles(){
        $(ROLES).click();
    }
    public void switchToGroupes(){
        $(GROUPS).click();
    }
    public void switchToCustomFields(){
        $(CUSTOM_FIELDS).click();
    }
    public void switchToTags(){
        $(TAGS).click();
    }
    public void switchToAttachments(){
        $(ATTACHMENTS).click();
    }
    public void switchToLogs(){
        $(LOGS).click();
    }
    public void switchToSettings(){
        $(SETTINGS).click();
    }
    public void switchToSecurity(){
        $(SECURITY).click();
    }
}
