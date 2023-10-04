/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package java_cad_student;
import java.util.ArrayList;

/**
 *
 * @author fodao
 */

public class ControlerStudent {
    
    private final ArrayList<Student> students;
    
    public ControlerStudent() {
        students = new ArrayList<>();
    }
    
    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(String id){
        if (studentsIsEmpty() == false){
            students.remove(findStudentById(id));
        }
    }

    public Student findStudentByName(String name){

        for (int i=0; i < students.size(); ++i){
            Student studentInSearch = students.get(i);

            if (studentInSearch.getName().equals(name)) {
                System.out.println("Aluno encontrado.. \n");
                return studentInSearch;
            }
        }

        return null;
    }

    public Student findStudentById(String id){

        for (int i=0; i < students.size(); ++i){
            Student studentInSearch = students.get(i);        

            if (studentInSearch.getId().equals(id)) {
                System.out.println("Aluno encontrado.. \n");
                return studentInSearch;
            }
        }
        
        return null;
    }
    
    public ArrayList<Student> returnAllStudents(){
        return students;
    }

    public boolean studentsIsEmpty(){
        return students.isEmpty();
    }
}
