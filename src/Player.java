
import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int orjHealth;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    private Scanner input=new Scanner(System.in);


    public Player( String name){
        this.name=name;
        this.inventory=new Inventory();
    }

    public void printInfo(){
        System.out.println("Silahiniz: "+getInventory().getWeapon().getName()+
                ", Zirh: "+getInventory().getArmor().getName()+
                ", Bloklama: "+getInventory().getArmor().getBlock()+
                ", Hasariniz: "+getDamage()+
                ", Saglik: "+getHealth()+
                ", Para: "+getMoney());
    }
    public void selectChar(){
        GameChar[] charList={new Samurai(),new Archer(),new Knight()};
        System.out.println("Karakterler ");
        System.out.println("-------------------------------------------------");
        for(GameChar gameChar:charList){
            System.out.println("ID: "+gameChar.getId()+"\tKarakter: "+gameChar.getName()+"\tHasar: "+gameChar.getDamage()+"\tSaglik: "+gameChar.getHealth()+"\tPara: "+gameChar.getMoney());
        }
        System.out.println("--------------------------------------------------");
        System.out.print("Lutfen bir karakter seciniz: ");
        int selectChar= input.nextInt();

        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                new Samurai();
        }
        System.out.println("Karakter: "+this.getName()+"\tHasar: "+this.getDamage()+"\tSaglik: "+this.getHealth()+"\tPara: "+this.getMoney());
    }
    public void initPlayer(GameChar gameChar){
        this.setName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setOrjHealth(gameChar.getHealth());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
    }
    public int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage){
        this.damage=damage;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health=health;
    }
    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money=money;
    }
    public String getCharName() {
        return charName;
    }
    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getOrjHealth() {
        return orjHealth;
    }

    public void setOrjHealth(int orjHealth) {
        this.orjHealth = orjHealth;
    }
}
