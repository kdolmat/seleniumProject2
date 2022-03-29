import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;


public class project2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Inna\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.manage().window().maximize();
        driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test", Keys.ENTER);

        driver.findElement(By.xpath("//li[.='Order']")).click();

        String quantity = String.valueOf((int)(Math.random()*100));
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).clear();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(quantity);
//        Thread.sleep(2000);
//        driver.findElement(By.className("btn_dark")).click();
        //couldn't figure out this part, but after proceeding with putting in customers name, it automatically calculates it


        char f=' ';
        String temp1="";
        String rand1 = "";
        for(int i=0;i<6;i++){
            f = (char)(26*(Math.random())+65);
            temp1  = String.valueOf(f);
            rand1=temp1+rand1;
        }

        char l=' ';
        String temp2="";
        String rand2 = "";
        for(int i=0;i<6;i++){
            l = (char)(26*(Math.random())+65);
            temp2  = String.valueOf(l);
            rand2=temp2+rand2;
        }
        String fl = rand1+" "+rand2;
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(fl);


        int streetNum = (int)(Math.random()*1000);
        char st=' ';
        String temp3="";
        String rand3 = "";
        for(int i=0;i<6;i++){
            st = (char)(26*(Math.random())+65);
            temp3  = String.valueOf(st);
            rand3=temp3+rand3;
        }
        String street = ""+streetNum+rand3+" St";
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys(" "+street);


        char city=' ';
        String temp4="";
        String rand4 = "";
        for(int i=0;i<7;i++){
            city = (char)(26*(Math.random())+65);
            temp4  = String.valueOf(city);
            rand4=temp4+rand4;
        }
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys(rand4);


        char state=' ';
        String temp5="";
        String rand5 = "";
        for(int i=0;i<2;i++){
            state = (char)(26*(Math.random())+65);
            temp5  = String.valueOf(state);
            rand5=temp5+rand5;
        }
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys(rand5);

        int zip = 9999+(int)(Math.random()*1000);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(zip+"");

        int cardType=1+(int)(Math.random()*2);

        Random rnd = new Random();
        StringBuilder stb = new StringBuilder();
        int i=0;
        while(i<=14){
            int generate = rnd.nextInt(9);
            stb.append(generate);
            i++;
        }

        switch (cardType){
            case 1:driver.findElement(By.xpath("//*[.='Visa']")).click();
            driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("4"+stb);
            break;
            case 2:driver.findElement(By.xpath("//*[.='MasterCard']")).click();
            driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("5"+stb);
            break;
            case 3:driver.findElement(By.xpath("//*[.='American Express']")).click();
            driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("3"+stb.deleteCharAt(stb.length()-1));
            break;
        }


        String month = String.valueOf(1+(int)(Math.random()*12));
        if(month.length()<2){
            month="0"+month;
        }
        int year = 22+(int)(Math.random()*10);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys(month+"/"+year);


        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        String expexted = "New order has been successfully added.";
        WebElement el = driver.findElement(By.xpath("//*[contains(text(),'New order')]"));
        String ell = ""+el.getText();


        if (expexted.contains(ell)) {

            driver.findElement(By.id("ctl00_logout")).click();
        }

        //also, all these random string generators, is there a way to use only one, or I'd have to use a new one for each string generated?




    }
}
