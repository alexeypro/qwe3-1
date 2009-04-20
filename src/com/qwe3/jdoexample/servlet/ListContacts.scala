package com.qwe3.jdoexample.servlet

import javax.servlet.http._
import javax.jdo.PersistenceManager
import javax.jdo.Query

import collection.jcl.Conversions
import com.qwe3.jdoexample.model.Contact
import com.qwe3.jdoexample.PMF


class ListContacts extends HttpServlet {
    override def doGet(request: HttpServletRequest, response: HttpServletResponse) {
        val pm = PMF.get().getPersistenceManager
        val q = pm.newQuery("select from " + classOf[Contact].getName)
        //q.setOrdering("id DESC")
        val res = q.execute().asInstanceOf[java.util.List[Contact]]
        //val contacts = Conversions.convertList(res).toList
        // we do not convert as jsp works with java's List
        // and we recreceate as new obj otherwise it will bring up attached obj issues
        var ret = new java.util.ArrayList[Contact]()
        if (res != null) ret = new java.util.ArrayList[Contact](res)
        request.setAttribute("contacts", ret)
        pm.close()
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/listcontacts.jsp").forward(request, response)
    }
}

