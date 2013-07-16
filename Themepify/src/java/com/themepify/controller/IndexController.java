/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.themepify.controller;

import com.themepify.query.QueryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author faisalhadi
 */
@Controller
public class IndexController {

    @Autowired
    QueryHelper queryhelper;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView IndexController() {

        ModelAndView mav = new ModelAndView("index");
//    List<Category> cat = queryhelper.getCategory(String.valueOf(1));
//    System.out.println(cat.get(0).getName());
//    System.out.println(cat.get(0).getDescription());


        return mav;


    }
}