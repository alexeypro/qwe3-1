package com.qwe3.jdoexample;

import javax.jdo.JDOHelper
import javax.jdo.PersistenceManagerFactory

object PMF {
    private val pmfInstance = JDOHelper.getPersistenceManagerFactory("transactions-optional")
    def get() = pmfInstance
}