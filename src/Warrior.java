public class Warrior extends Personage {
	public Warrior(String name, int health, int power, int agility, int skill, int gold) {
		super(name, health, power, agility, skill, gold);
	}

	@Override
	public String toString() {
		return String.format("""
										Здоровье: %d,\s
										Сила: %d,\s
										Ловкость: %d,\s
										Опыт: %d, \s
										Золото: %d.""",
						super.getHealth(),
						super.getPower(),
						super.getAgility(),
						super.getSkill(),
						super.getGold());
	}
	public void setWonBattle(){
		System.out.println("Ваш герой " + this.getName() + " одержал победу!");
		this.setSkill(getSkill()+10);
		System.out.println();
		System.out.println("Ваши характеристики на данный момент:");
		System.out.println(this);
		System.out.println("Вы хотите продолжить бой? (да/нет)");
	}

}
