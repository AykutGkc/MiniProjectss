package LoginPageApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    //6-Kullanicidan bilgileri tutmak icin list olusturalim.
    List<User> userList = new ArrayList<User>();
    //Tüm methodlarda kullanicidan bilgi almak icin scanner objesi olusturalim
    Scanner inp = new Scanner(System.in);

    //7-Username veya email ile kayitli useru getirme
    private User getUser(String usernameOrEmail) {
        for (User user : userList) {
            if (user.getUsername().equals(usernameOrEmail)) {
                return user;
            } else if (user.getEmail().equals(usernameOrEmail)) {
                return user;
            }
        }
        return null;
    }

    //8-email validation
    private static boolean validateEmail(String email) {
        boolean isValid;

        boolean isExistsSpace = email.contains(" ");
        boolean isContainsAt = email.contains("@");
        if (isExistsSpace) {
            System.out.println("E-mail bosluk iceremez!!!");
            isValid = false;
        } else if (!isContainsAt) {
            System.out.println("E-mail @ sembolünü icermelidir!!!");
            isValid = false;
        } else { //asd@gmail.com --> [asd,@gmail.com]
            String firstPart = email.split("@")[0];
            String secondPart = email.split("@")[1];

            boolean valid = firstPart.replaceAll("[a-zA-Z0-9_.-]", "").isEmpty();
            boolean checkStart = valid && firstPart.length() > 0;

            boolean checkEnd = secondPart.equals("gmail.com") || secondPart.equals("hotmail.com") || secondPart.equals("yahoo.com");

            if (!checkStart) {
                System.out.println("Mailin kullanici adi bölümü en az bir karakter icermelidir ve " +
                        "sadece kücük büyük harf,rakam veya -._ icerebilir!!!");
            }
            if (!checkEnd) {
                System.out.println("E-mail gmail.com,hotmail.com,yahoo.com ile bitmelidir!!!");
            }

            isValid = checkStart && checkEnd;

        }
        if(!isValid){
            System.out.println("Geçersiz email, tekrar deneyiniz!");
        }
        return isValid;
    }

    //9-Password validation

    private static boolean validatePassword(String password){
        boolean isValid;
        boolean isExistsSpace=password.contains(" ");
        boolean isLenghtGtSix=password.length()>=6;
        boolean isExistsUpperLetter=password.replaceAll("[^A-Z]","").length()>0;
        boolean isExistsLowerLetter=password.replaceAll("[^a-z]","").length()>0;
        boolean isExistsDigit=password.replaceAll("[\\D]","").length()>0;
        boolean isExistsSymbol=password.replaceAll("\\P{Punct}","").length()>0;

        if (isExistsSpace){
            System.out.println("Sifre bosluk iceremez");
        }else if (!isLenghtGtSix){
            System.out.println("Sifre en az 6 karakter icermelidir.");
        }else if (!isExistsUpperLetter){
            System.out.println("Sifre büyük harf icermelidir.");
        }else if (!isExistsLowerLetter){
            System.out.println("Sifre kücük harf icermelidir.");
        }else if (!isExistsDigit){
            System.out.println("Sifre rakam icermelidir.");
        }else if (!isExistsSymbol){
            System.out.println("Sifre sembol icermelidir.");
        }
        isValid=!isExistsSpace && isLenghtGtSix && isExistsUpperLetter && isExistsLowerLetter && isExistsDigit && isExistsSymbol;
        if (!isValid){
            System.out.println("Gecersiz sifre tekrar deneyiniz!!!");
        }
        return isValid;
    }

    public void register(){
        System.out.println("Ad-Soyad");
        String name=inp.nextLine();

        //10-Username unique(benzersiz) olmali
        String username=getUsername();
        //11-email bilgisi almak unique olmali,gecerli olmali
        String email=getEmail();
        //12-password gecerli olmali
        String password=getPassword();
        //13-user objesini olusturalim
        User user=new User(name,username,email,password);
        //14-user kayidi, listeye ekleme
        this.userList.add(user);
        System.out.println("Tebrikler.Isleminiz basari ile gerceklestirildi.");
        System.out.println("Kullanici adi (veya email) ve sifreniz ile sisteme giris yapabilirsiniz.");
    }
    //10-a username almak
    private String getUsername (){
      String username;
      boolean existsUsername;
        do {
            System.out.println("Kullanici adini giriniz: ");
            username = inp.next();
            existsUsername=getUser(username)!=null;
            if (existsUsername){
                System.out.println("Bu kullanici adi kullanilmistir.Farkli bir kullanici adi deneyiniz");
            }
        }while (existsUsername);

      return username;
    }

    //11-a kullanicidan email alma

    private String getEmail(){
        String email;
        boolean isValid;
        boolean existsEmail;
        do {
            System.out.println("Lütfen bir Email giriniz");
            email=inp.next();//email gerli mi
            isValid=validateEmail(email);//gecerli ise unique mi
            existsEmail=getUser(email)!=null;
            if (existsEmail){
                System.out.println("Bu email daha zaten kayitli, farkli bir email deneyiniz.");
                isValid=false;
            }
        }while(!isValid);



        return email;
    }
    //12-a password olusturma
    private String getPassword(){
         String password;
         boolean isValidPassword;

         do {
             System.out.println("Sifrenizi giriniz");
             password=inp.next();//gecerli mi
             isValidPassword=validatePassword(password);

         }while(!isValidPassword);
         return password;
    }
    //15-Email veya username ile giris yapma

    public void login(){
        System.out.println("Lütfen kullanici adi veya email giriniz");
        String usernameOrEmail=inp.next();
        //16-girilen deger ile useri bulma
        if (getUser(usernameOrEmail)!=null) {
            User user = getUser(usernameOrEmail);
            //17-user bulundu ise sifre kontrolü
            boolean isWrong=true;
            while (isWrong){
                System.out.println("Sifrenizi giriniz");
                String password=inp.next();
                //girilen sifre buldugumuz userin sifresi ile eslesiyor mu kontrolü
                if (user.getPassword().equals(password)){
                    System.out.println("Sisteme giris yaptiniz.");
                    isWrong=false;
                }else{
                    System.out.println("Sifreniz yanlis,tekrar deneyiniz");
                }
            }

        }else{
            System.out.println("Sistemde kayitli kullanici adi veya email bulunamadi.");
            System.out.println("Üye iseniz bilgilerinizi kontrol ederek tekrar deneyiniz, üye degilseniz lütfen üye olunuz");
        }

    }
}
