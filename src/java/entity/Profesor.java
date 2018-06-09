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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Profesor generated by hbm2java
 */
@Entity
@Table(name="profesor"
    ,catalog="java_demo1"
)
public class Profesor  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private Set<Curso> cursos = new HashSet<Curso>(0);

    public Profesor() {
    }

    public Profesor(String nombre, Set<Curso> cursos) {
       this.nombre = nombre;
       this.cursos = cursos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="nombre", length=100)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="profesor")
    public Set<Curso> getCursos() {
        return this.cursos;
    }
    
    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }




}


