package com.qwe3.jdoexample.servlet

import javax.servlet.http._
import javax.jdo.PersistenceManager
import javax.jdo.Query

import collection.jcl.Conversions
import com.qwe3.jdoexample.model.Contact
import com.qwe3.jdoexample.PMF

class DeleteContact extends HttpServlet {
    override def doPost(request: HttpServletRequest, response: HttpServletResponse) {
        if (request.getParameter("id") != null) {
            val id = new java.lang.Long(request.getParameter("id").toString())
            val pm = PMF.get().getPersistenceManager
            val c = pm.getObjectById(classOf[Contact], id)
            pm.deletePersistent(c)
            pm.close()
        }
        response.sendRedirect("/listcontacts")
    }
}

