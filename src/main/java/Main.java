import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Здравствуйте! На сколько гостей разделить счёт?");
        int guest;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                guest = scanner.nextInt();
                if (guest > 1) {
                    System.out.println("Количество гостей " + guest);
                    break;
                } else if (guest == 1) {
                    System.out.println("Счёт выставлен на 1 гостя");

                }
            }  else {
                System.out.println("Произошла ошибка");
                scanner.reset();
            }
        }
        String product;
        float price;
        float totalPrice = 0;
        String goods = "";
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите блюдо");
            product = scanner.nextLine();
            scanner.reset();
            System.out.println("Укажите цену");
            if (scanner.hasNextFloat()) {
                price = scanner.nextFloat();
                if (price <= 0) {
                    System.out.println("Произошла ошибка");
                } else {
                    Scanner scanner1 = new Scanner(System.in);
                    totalPrice = totalPrice + price;
                    goods = goods + product;
                    System.out.println("Блюдо в корзине");
                    System.out.println("Добавить ещё или \"Завершить\"?");
                    String check = scanner1.nextLine();
                    scanner1.reset();
                    String complete = "Завершить";
                    if (check.equalsIgnoreCase (complete)) {
                        System.out.println("Блюда в корзине:" + "\n"+ goods);
                       String payment = "Итого каждому к оплате: %.2f %s";
                       Rouble ending = new Rouble();
                       System.out.println(String.format(payment, totalPrice / guest, ending.ending(totalPrice/guest)));
                        break;
                    }
                }

                }
            }
        }

    }

  class Rouble {
      public String ending(double rubles) {
          int ending = (int) (Math.floor(rubles) % 10);
          if (((int) (Math.floor(rubles) % 100)) <= 19 && ((int) (Math.floor(rubles) % 100)) >= 11)
              return "рублей";
          switch (ending) {
              case 1:
                  return "рубль";
              case 2:
              case 3:
              case 4:
                  return "рубля";
              default:
                  return "рублей";
          }
      }
  }
