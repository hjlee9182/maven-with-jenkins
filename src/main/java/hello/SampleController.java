package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @Value("${environment.message}")
    private String message;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World! This is " + message ;
    }

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(SampleController.class, args);
        Logger logger = Logger.getLogger(SampleController.class.getName());
        Scanner in = new Scanner(System.in);
        boolean end = false;

        // calcUserMoney method test
        int userMoney = 10000;
        int totalPrice = 0;

        int button;

        logger.log(Level.INFO,"사용자가 가지고있는액수");

        while (!end) {
            printMenu();
            button = in.nextInt();
            printMenu();
            if (userMoney < 0) {

                logger.log(Level.INFO,"액수가 부족합니다.");
                end = true;
            }
            switch(button) {
                case 0:

                    end = true;

                    logger.log(Level.INFO,"구매금액 : " + totalPrice + " 잔액 : " + userMoney);

                    logger.log(Level.INFO,"이용해주셔서 감사합니다.");
                case 1:
                    totalPrice += calcTotalPrice(1000, 1);
                case 2:
                    totalPrice += calcTotalPrice(1500, 1);
                case 3:
                    totalPrice += calcTotalPrice(1300, 1);
                case 4:
                    totalPrice += calcTotalPrice(1000, 1);
                default:

                    logger.log(Level.INFO,"올바른 명령어를 입력하세요");
            }
            userMoney = calcUserMoney(userMoney, totalPrice);

        }



    }

    /*
     * calculate userMoney and totalPrice Method
     * if userMoney bigger than totalPrice, return positive numbers
     * else return negative numbers.
    */

    private static int calcUserMoney(int userMoney, int totalPrice) {
        return userMoney - totalPrice;
    }

    private static void printMenu(){
        Logger logger = Logger.getLogger(SampleController.class.getName());

        logger.log(Level.INFO,"---------------------------");
        logger.log(Level.INFO,"1.콜라 1000");
        logger.log(Level.INFO,"2.환타 1500");
        logger.log(Level.INFO,"3.사이다 1300");
        logger.log(Level.INFO,"4.포카리스웨트 1000");
        logger.log(Level.INFO,"5.조지아 1600");
        logger.log(Level.INFO,"---------------------------");


    }

    public static int calcTotalPrice(int price, int number){

        return price*number;

    }
}
