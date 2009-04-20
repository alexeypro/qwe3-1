package com.qwe3.jdoexample.servlet

import javax.servlet.http._
import javax.jdo.PersistenceManager
import javax.jdo.Query

import collection.jcl.Conversions
import com.qwe3.jdoexample.model.Contact
import com.qwe3.jdoexample.PMF

class AddContact extends HttpServlet {
    override def doGet(request: HttpServletRequest, response: HttpServletResponse) {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/addcontact.jsp").forward(request, response)
    }
    override def doPost(request: HttpServletRequest, response: HttpServletResponse) {
        val fname : String = request.getParameter("contact_firstname")
        val lname : String = request.getParameter("contact_lastname")
        val email : String = request.getParameter("contact_email")
        val c = new Contact(fname, lname, email)
        val pm = PMF.get().getPersistenceManager
        pm.makePersistent(c)
        pm.close()
        response.sendRedirect("/listcontacts")
    }
}

