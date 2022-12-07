public abstract class Personage implements Fight {
    private String name;
    private int health;
    private int power;
    private int agility;
    private int skill;
    private int gold;

    public Personage(String name, int health, int power, int agility, int skill, int gold) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.agility = agility;
        this.skill = skill;
        this.gold = gold;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }
    public int getPower() { return power; }
    public void setPower(int power) { this.power = power; }
    public int getAgility() { return agility; }
    public void setAgility(int agility) { this.agility = agility; }
    public int getSkill() { return skill; }
    public void setSkill(int skill) { this.skill = skill; }
    public int getGold() { return gold; }
    public void setGold(int gold) { this.gold = gold; }

    @Override
    public int attack() {
        int checkPower = (int)(Math.random() * 100);
        int criticalPower = (int)(Math.random() * 100);
        if (agility * 3 > checkPower){
            if (criticalPower > 80) {
                return power * 2;
            }return power;
        } else return 0;

    }
}
