/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.NewHibernateUtil;
import entity.Profesor;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author pc01
 */
public class ProfesorModel {
	public List<Profesor> getAll() {
        List<Profesor> lst = new ArrayList<Profesor>();
        
        Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();
            lst = s.createCriteria(Profesor.class).list();
            s.getTransaction().commit();

        } catch (Exception e) {

            e.printStackTrace();
        }
        
        return lst;
    }
}
