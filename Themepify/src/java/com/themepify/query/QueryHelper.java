/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.themepify.query;

import com.themepify.entity.Category;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author faisalhadi
 */

@Repository
public class QueryHelper {
    
    private HibernateTemplate hibernateTemplate;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
    
    public List<Category> getCategory(String number){

        return hibernateTemplate.find("from " + Category.class.getName());
    }
    
    
}
