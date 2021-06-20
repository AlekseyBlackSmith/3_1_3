package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

/**
 *
 *    DEPENDENCIES!!!  НЕ ОБНОВИШЬ - НЕ ЗАПУСТИШЬ!
 *
 */

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("BMW", 3);
      Car car2 = new Car("Mazda", 5);
      Car car3 = new Car("Mercedes", 4);
      Car car4 = new Car("Opel", 2);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      System.out.println(userService.getUserByCar("Mercedes", 4));
      System.out.println(userService.getUserByCar("BMW", 3));
      System.out.println(userService.getUserByCar("Mazda", 5));
      System.out.println(userService.getUserByCar("Opel", 2));

      context.close();

   }
}
