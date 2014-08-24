package com.helpEveryone.repository

import com.helpEveryone.domain.HelpSeeker
import com.novus.salat._
import com.novus.salat.global._
import com.novus.salat.annotations._
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import org.bson.types.ObjectId

trait HelpSeekersRepo  extends SalatDAO[HelpSeeker, ObjectId] {
}

object HelpSeekersRepoMongoImpl extends SalatDAO[HelpSeeker, ObjectId](collection  = MongoConnection()("test_db")("test_coll")) with HelpSeekersRepo