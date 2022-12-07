import java.util.Scanner;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	private static Warrior warrior = null;
	private static World world = null;
	private static Dealer dealer = null;

	public static void main(String[] args) {
		world = new World();
		System.out.println("Введите имя персонажа");
		command(scanner.nextLine());
	}

	public static void command(String string) {
		if (!string.equals("")) {
			if (warrior == null) {
				warrior = new Warrior(string, 100, 20, 25, 0, 50);
				System.out.println("<<Приветствуем тебя, герой " + warrior.getName() + "!>>");
				System.out.println("Вот твои начальные характеристики");
				System.out.println(warrior);
				string = "нет";
			}
			switch (string) {
				case "1" -> trading();
				case "2" -> world.fight(warrior);
				case "3" -> System.exit(1);
				case "да" -> {
					if (World.count == 0)
						command("нет");
					else command("2");
				}
				case "нет" -> {
					printMenu();
					command(scanner.nextLine());
				}
				default -> System.out.println("Введите корректную команду");
			}
			command(scanner.nextLine());
		} else {
			System.out.println("Введите имя персонажа");
			command(scanner.nextLine());
		}
	}

	public static void trading() {
		if (dealer == null) {
			dealer = new Dealer(2);
			System.out.println("Приветствую тебя, воин!");
			System.out.println("Я местный торговец зельем.");
		}
		System.out.println("У меня в наличии " + dealer.getPotion() + " единица/ы элексира.");
		System.out.println("Стоимость одной единицы 50 золотых.");
		System.out.println("У тебя: " + warrior.getGold() + " золотых");
		System.out.println("Хочешь пополнить здоровье? (да/нет)");
		seller(scanner.nextLine());
	}

	public static void seller(String string) {
		switch (string) {
			case "да":
				if (warrior.getHealth() == 100) {
					System.out.println("Полное здоровье");
					command("нет");
				} else if (warrior.getGold() >= 50 && dealer.getPotion() > 0) {
					warrior.setHealth(100);
					warrior.setGold(warrior.getGold() - 50);
					System.out.println("Здоровье восстановлено!");
					dealer.setPotion(dealer.getPotion() - 1);
					command("нет");
				} else if (warrior.getGold() < 50) {
					System.out.println("Нехватает золота");
					command("нет");
				} else if (dealer.getPotion() == 0) {
					System.out.println("Закончилось зелье");
					command("нет");
				}
			case "нет": {
				command("нет");
			}
			default: {
				System.out.println("Введите корректную команду");
			}
			seller(scanner.nextLine());
		}
	}

	public static void printMenu() {
		System.out.println();
		System.out.println("Куда бы ты пошёл?");
		System.out.println("Введите номер команды");
		System.out.println("1. К торговцу.");
		System.out.println("2. В Тёмный лес.");
		System.out.println("3. Закончить игру.");
		System.out.println();
	}
}
