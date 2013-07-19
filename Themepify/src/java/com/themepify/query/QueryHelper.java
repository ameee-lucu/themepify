/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.themepify.query;

import com.themepify.entity.Category;
import com.themepify.entity.Uploader;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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
    
    public Uploader getUploaderbyName(String name){
        DetachedCriteria criteria = DetachedCriteria.forClass(Uploader.class);
        criteria.add(Restrictions.eq("name", name));
        List<Object> result = hibernateTemplate.findByCriteria(criteria);
        Uploader uploader = (Uploader) (result==null||result.isEmpty()?null:result.get(0));
        return uploader;
    }
    
    public void saveEntity(Object entity){
        hibernateTemplate.save(entity);
    }
    
}
