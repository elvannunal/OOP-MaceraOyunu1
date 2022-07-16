import java.util.Scanner;

public class Game {
    public void start(){
        Scanner input=new Scanner(System.in);
        System.out.println("Macera oyununa hos geldiniz!");
        System.out.print("Lutfen bir isim giriniz: ");
       // String playerName=input.nextLine();
        Player player=new Player( "Elvan ");
        System.out.println("Sayin " +player.getName()+" bu karanlik ve sisli adaya hos geldiniz!\n Burada yasananlarin hepsi gercek!!!");
        System.out.println("Lutfen bir karakter seciniz!");
        player.selectChar();
        Location location=null;
        while (true){

            player.printInfo();
            System.out.println();
            System.out.println("#############Bolgeler##############");
            System.out.println();
            System.out.println("1-Guvenli ev--> Burasi sizin icin guvenli, dusman yok!");
            System.out.println("2-Esya Dukkani-> Silah veya zirh satin alabilirsin! ");
            System.out.println("3-Magara--> Magaraya gir! Odulun yemek. Dikkatli ol karsina zombie cakabilir");
            System.out.println("4-Orman--> Ormana gir! Odulun Odun. Dikkatli ol karsina vampir cakabilir");
            System.out.println("5-Nehir--> Nehire gir! Odulun su. Dikkatli ol karsina ayi cakabilir");
            System.out.println("0- Cikis yap--> Oyunu sonlandir");

            System.out.println("Lutfen gitmek istediginiz bolgeyi seciniz: ");
            int selectLoc= input.nextInt();
            switch (selectLoc){
                case 0:
                    location =null;
                    break;
                case 1:
                    location=new SafeHouse(player);
                    break;
                case 2:
                    location=new ToolStore(player);
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);
                    break;
                case 5:
                    location=new River(player);
                    break;
                default:
                    System.out.println("Lutfen gecerli bir bolge giriniz!");
                    break;
            }
            if(location==null){
                System.out.println("Bu karanlik ve sisli adadan cabuk vazgectin!");
                break;
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER!");
            }
        }
    }
}
