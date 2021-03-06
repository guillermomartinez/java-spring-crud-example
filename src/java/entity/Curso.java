package entity;
// Generated 09/06/2018 04:02:46 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Curso generated by hbm2java
 */
@Entity
@Table(name="curso"
    ,catalog="java_demo1"
)
public class Curso  implements java.io.Serializable {


     private Integer id;
     private Profesor profesor;
     private String nombre;
     private Set<Alumno> alumnos = new HashSet<Alumno>(0);

    public Curso() {
    }

	
    public Curso(Profesor profesor) {
        this.profesor = profesor;
    }
    public Curso(Profesor profesor, String nombre, Set<Alumno> alumnos) {
       this.profesor = profesor;
       this.nombre = nombre;
       this.alumnos = alumnos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="profesor", nullable=false)
    public Profesor getProfesor() {
        return this.profesor;
    }
    
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    
    @Column(name="nombre", length=100)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="alumno_has_curso", catalog="java_demo1", joinColumns = { 
        @JoinColumn(name="curso_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="alumno_id", nullable=false, updatable=false) })
    public Set<Alumno> getAlumnos() {
        return this.alumnos;
    }
    
    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }




}


