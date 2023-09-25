/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package java_cad_student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fodao
 */

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
            case 0 -> System.out.println("Até mais...");
            default -> System.out.println("Opção não foi encontrada! \n");
        }        } while (option != 0);
    }
    
    private int getOptions(){
        System.out.println("""
                           Selecione a opcao:
                           1- Adicionar o estudante
                           2- Remover o estudante
                           3- Pesquisar estudante por nome
                           4- Pesquisar estudante por matr\u00edcula
                           5- Listar todos estudantes cadastrados
                           0- Sair
                           Opcao:""");

        return scanner.nextInt();
    }

    private void addStudent(){
        String id;
        String name;
        String e_mail;
        String phone_number;
        String adress;

        System.out.println("Forneça os dados para efetuar o cadastro:");
        System.out.println("Matrícula: ");
        id = scanner.next();
        System.out.println("Nome: ");
        name = scanner.next();
        System.out.println("Email: ");
        e_mail = scanner.next();
        System.out.println("Telefone: ");
        phone_number = scanner.next();
        System.out.println("Endereço: ");
        adress = scanner.next();

        Student student = new Student(id, name, e_mail, phone_number, adress);
        controlerStudent.addStudent(student);
    }

    private void removeStudent(){
        System.out.println("Para remover o estudande insira a Matrícula do mesmo: ");
        System.out.println("Matrícula: ");

        controlerStudent.removeStudent(scanner.next());
    }

    private void getStudentByName(){
        System.out.println("Informe o nome do estudante: ");
        System.out.println("Nome: ");
        Student student = controlerStudent.findStudentByName(scanner.next());

        if (student != null){
            System.out.println("Nome: " + student.getName() +
                "\nMatrícula: " + student.getId() +
                "\nEmail: " + student.getE_mail() +
                "\nTelefone: " + student.getPhone() +
                "\nEndereço: " + student.getAdress());;
        }else{
            System.out.println("Estudante não está cadastrado!");
        }
    }

    private void getStudentById(){
        System.out.println("Informe a matrícula do estudante: ");
        System.out.println("Matrícula: ");
        Student student = controlerStudent.findStudentById(scanner.next());

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
