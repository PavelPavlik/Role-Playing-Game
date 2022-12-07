public class World{
	public static int count = 0;

	public void fight(Warrior warrior) {
		Runnable runnable = () -> {
			count++;
			Personage enemy = createEnemy();
			System.out.println("На тебя напал " + enemy.getName());
			System.out.println("И завязался бой...");
			System.out.println();
			try { Thread.sleep(3000);
			} catch (InterruptedException e) { e.printStackTrace(); }
			int gameMove = 1;
			int priority = isPriorityAttack();
			int enemyHealth = enemy.getHealth();
			int warriorHealth = warrior.getHealth();
			while (enemyHealth > 0 && warriorHealth > 0) {
				System.out.println("#####    Ход " + gameMove + "    #####");
				System.out.println(warrior.getName() + " Здоровье: " + warriorHealth);
				System.out.println(enemy.getName() + " Здоровье: " + enemyHealth);
				System.out.println();
				gameMove++;
				if (priority++ % 2 == 0) {
					enemyHealth -= warrior.attack();
				} else warriorHealth -= enemy.attack();
				try {	Thread.sleep(2000); }
				catch (InterruptedException e) { e.printStackTrace();	}
			}
			System.out.println("Бой окончен");
			System.out.println();
			if (warriorHealth <= 0) {
				System.out.println("Увы, Ваш герой погиб.");
				System.out.println("Количество убитых монстров: " + warrior.getSkill() / 10);
				System.exit(1);
			} else {
				warrior.setHealth(warriorHealth);
				warrior.setGold((warrior.getGold()) + enemy.getGold());
				warrior.setWonBattle();
			}
		};
		Thread thread1 = new Thread(runnable);
		thread1.start();
	}

	private static Personage createEnemy() {
		int random = (int) (Math.random() * 10);
		if (random % 2 == 0)
			return new Goblin("Гоблин", 100, 20, 20, 0, 20);
		else return new Skeleton("Скелет", 100, 25, 15, 0, 30);
	}

	private int isPriorityAttack() {
		return (int) (Math.random() * 10);
	}
}
