package com.qwe3.jdoexample.servlet

import javax.servlet.http._
import javax.jdo.PersistenceManager
import javax.jdo.Query

import collection.jcl.Conversions
import com.qwe3.jdoexample.model.Contact
import com.qwe3.jdoexample.PMF

class UpdateContact extends HttpServlet {
    override def doGet(request: HttpServletRequest, response: HttpServletResponse) {
        if (request.getParameter("id") != null) {
            val id = new java.lang.Long(request.getParameter("id").toString())
            val pm = PMF.get().getPersistenceManager
            val c = pm.getObjectById(classOf[Contact], id)
            request.setAttribute("contact", c)
            pm.close()
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/updatecontact.jsp").forward(request, response)
        } else {
            response.sendRedirect("/listcontacts")
        }
    }
    override def doPost(request: HttpServletRequest, response: HttpServletResponse) {
        if (request.getParameter("id") != null) {
            val id = new java.lang.Long(request.getParameter("id").toString())
            val pm = PMF.get().getPersistenceManager
            val c = pm.getObjectById(classOf[Contact], id)
            c.setFirstName( request.getParameter("contact_firstname") )
            c.setLastName( request.getParameter("contact_lastname") )
            c.setEmail( request.getParameter("contact_email") )
            pm.makePersistent(c)
            pm.close()
        }
        response.sendRedirect("/listcontacts")
    }
}

