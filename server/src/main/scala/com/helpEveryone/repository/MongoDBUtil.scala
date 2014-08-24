package com.helpEveryone.repository

import com.mongodb.casbah
import com.mongodb.casbah.Imports._

object MongoDBUtil {

  val db = MongoConnection("localhost", 27017)("help_everyone")

}
