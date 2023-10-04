
package java_cad_student;

public class Student {
    private String id;
    private String name;
    private String e_mail;
    private String phone_number;
    private String adress;
    

    public Student (String id, String name, String e_mail,
            String phone_number, String adress){
        this.id = id;
        this.name = name;
        this.e_mail = e_mail;
        this.phone_number = phone_number;
        this.adress = adress;
    } 

    //-----------------------BLOCO PARA ADICIONAR VALORES-----------------------

    public String getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }

    public String getE_mail(){
        return this.e_mail;
    }
    
    public String getPhone(){
        return this.phone_number;
    }
    
    public String getAdress(){
        return this.adress;
    }
    
    //-----------------------BLOCO PARA MUDAR VALORES-----------------------

    public void changeId(String id){
        this.id = id;
    }

    public void changeName(String name){
        this.name = name;
    }

    public void changeE_mail(String e_mail){
        this.e_mail = e_mail;
    }

    public void changePhone(String phone_number){
        this.phone_number = phone_number;
    }

    public void changeAdress(String adress){
        this.adress = adress;
    }
    
}
