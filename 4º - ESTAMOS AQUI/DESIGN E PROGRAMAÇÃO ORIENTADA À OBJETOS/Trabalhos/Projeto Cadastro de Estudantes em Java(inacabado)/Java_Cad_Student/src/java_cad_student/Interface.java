
package java_cad_student;
import java.util.ArrayList;
import java.util.Scanner;

public class Interface {

    private final Scanner scanner;
    private final ControlerStudent controlerStudent;

    public Interface() {

        scanner = new Scanner(System.in);
        controlerStudent = new ControlerStudent();
    }
    
    public void init() {

        int option;

        do {
            option = getOptions();

        switch (option) {
            case 1 -> addStudent();
            case 2 -> removeStudent();
            case 3 -> getStudentByName();
            case 4 -> getStudentById();
            case 5 -> showStudents();
            case 0 -> bye();
            
            default -> System.out.println("Opção não foi encontrada! \n");
        }        } while (option != 0);
    }
    
    private int getOptions(){
        System.out.println("""
                           Selecione a opcao:
                           1- Adicionar o estudante
                           2- Remover o estudante
                           3- Pesquisar estudante por nome
                           4- Pesquisar estudante por matricula
                           5- Listar todos estudantes cadastrados
                           0- Sair
                           Opcao:""");

        return scanner.nextInt();
    }

    private void bye(){
        System.out.println("Até mais...");
        scanner.close();
    }

    private void addStudent(){
        String id;
        String name;
        String e_mail;
        String phone_number;
        String adress;

        System.out.println("Forneça os dados para efetuar o cadastro:");
        scanner.nextLine();

        do {
            System.out.println("Matrícula: ");
            id = scanner.nextLine(); 
            
        } while (id.length() != 8);
        
        do {
            System.out.println("Nome: ");
            name = scanner.nextLine();
    
        } while (name.length() < 2 || name.length() > 40);
        

        System.out.println("Email: ");
        e_mail = scanner.nextLine();
        

        System.out.println("Telefone: ");
        phone_number = scanner.nextLine();
        
        
        System.out.println("Endereço: ");
        adress = scanner.nextLine();
        

        Student student = new Student(id, name, e_mail, phone_number, adress);
        controlerStudent.addStudent(student);
    }

    private void removeStudent(){
        scanner.nextLine();
        System.out.println("Para remover o estudande insira a Matrícula do mesmo: ");
        System.out.println("Matrícula: ");

        controlerStudent.removeStudent(scanner.nextLine());
    }

    private void getStudentByName(){
        scanner.nextLine();
        System.out.println("Informe o nome do estudante: ");
        System.out.println("Nome: ");
        Student student = controlerStudent.findStudentByName(scanner.nextLine());

        if (student != null){
            System.out.println("Nome: " + student.getName() +
                "\nMatrícula: " + student.getId() +
                "\nEmail: " + student.getE_mail() +
                "\nTelefone: " + student.getPhone() +
                "\nEndereço: " + student.getAdress());
        }else{
            System.out.println("Estudante não está cadastrado!");
        }
    }

    private void getStudentById(){
        scanner.nextLine();
        System.out.println("Informe a matrícula do estudante: ");
        System.out.println("Matrícula: ");
        Student student = controlerStudent.findStudentById(scanner.nextLine());

        if (student != null){
            System.out.println("Nome: " + student.getName() +
                "\nMatrícula: " + student.getId() + 
                "\nEmail: " + student.getE_mail() +
                "\nTelefone: " + student.getPhone() +
                "\nEndereço: " + student.getAdress());
        }else{
            System.out.println("Estudante não está cadastrado!");
        }
    }

    private void showStudents(){
        System.out.println("Listando Estudantes...");
        ArrayList<Student> students = controlerStudent.returnAllStudents();

        if (students.isEmpty()){
            System.out.println("Nenhum aluno encontrado");
            init();
        }
        
        for (int i=0; i < students.size(); ++i){
            Student student = students.get(i);
            System.out.println("Nome: " + student.getName() +
                "\nMatrícula: " + student.getId() +
                "\nEmail: " + student.getE_mail() +
                "\nTelefone: " + student.getPhone() +
                "\nEndereço: " + student.getAdress());
            System.out.println();
        }
        System.out.println("\n");
    }
}
