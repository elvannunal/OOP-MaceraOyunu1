public class ToolStore extends Location{
    public ToolStore(Player player){
        super(player,"Magaza");
    }

    @Override
    public boolean onLocation(){
        System.out.println("--------------Magazaya Hosgeldiniz------------");
        boolean showMenu=true;
       while (showMenu){
           System.out.println("1-Silahlar");
           System.out.println("2-Zirhlar");
           System.out.println("3-Cikis Yap");
           System.out.print("Seciminiz:  ");
           int selectCase=Location.input.nextInt();
           while (selectCase<1 || selectCase>3){
               System.out.println("Gecersiz bir deger girdiniz! Tekrar giriniz: ");
               selectCase= input.nextInt();
           }
           switch (selectCase){

               case 1:
                   printWeapon();
                   buyWeapon();
                   break;

               case 2:
                   printArmor();
                   buyArmor();
                   break;

               case 3:
                   System.out.println("Bir daha bekleriz!");
                   showMenu=false;
                   break;
           }
       }
       return true;

    }
    public void buyArmor(){

        System.out.println("Bir zirh seciniz : ");

        int selectedArmorID = input.nextInt();

        while (selectedArmorID <1 || selectedArmorID >Armor.armors().length){
            System.out.println("Gecersiz bir deger girdiniz! Tekrar giriniz: ");
            selectedArmorID = input.nextInt();
        }
        Armor selectedArmor =Armor.getArmorObjById(selectedArmorID);

        if(selectedArmor !=null){
            if(selectedArmor.getPrice()>this.getPlayer().getMoney()){
                System.out.println("Yeterli paraniz bulunmamaktadir!");
            }else{
                System.out.println(selectedArmor.getName()+" zirhini aldiniz!");
                this.getPlayer().setMoney(this.getPlayer().getMoney()-selectedArmor.getPrice());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Kalan paraniz: "+this.getPlayer().getMoney());
            }
        }


    }
    public void printWeapon(){
        System.out.println("---------Silahlar---------");
        System.out.println();
        for(Weapon w:  Weapon.weapons()){
            System.out.println(w.getId()+" - "+w.getName()+" <Para: "+w.getPrice()+" Hasar: "+w.getDamage()+" >");
        }

    }
    public void buyWeapon(){
        System.out.println("Bir silah seciniz : ");

        int selectWeaponID = input.nextInt();

        while (selectWeaponID <0 || selectWeaponID >Weapon.weapons().length){
            System.out.println("Gecersiz bir deger girdiniz! Tekrar giriniz: ");
            selectWeaponID = input.nextInt();
        }
        if(selectWeaponID!=0){
            Weapon selectedWeapon=Weapon.getWeaponObjById(selectWeaponID);

            if(selectedWeapon!=null){
                if(selectedWeapon.getPrice()>this.getPlayer().getMoney()){
                    System.out.println("Yeterli paraniz bulunmamaktadir!");
                }else{
                    System.out.println(selectedWeapon.getName()+" Silahini aldiniz!");
                    int balance= getPlayer().getMoney()-selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println();
                    System.out.println("Kalan paraniz: "+this.getPlayer().getMoney());
                    System.out.println("Onceki silahiniz: "+this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni silahiniz: "+this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }


    }
    public void printArmor(){
        System.out.println("---------Zirhlar---------");
        for (Armor a:Armor.armors()){
            System.out.println(a.getId()+" - "+a.getName()+" <Para : "+a.getPrice()+
                    ", Bloklama:  "+a.getBlock()+" >");
        }


    }
}
