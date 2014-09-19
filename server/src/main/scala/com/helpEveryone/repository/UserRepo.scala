package com.helpEveryone.repository

import com.helpEveryone.domain.User
import com.novus.salat._
import com.novus.salat.global._
import com.novus.salat.annotations._
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import org.bson.types.ObjectId

trait UserRepo extends SalatDAO[User, ObjectId]

object UserRepoMongoImpl extends SalatDAO[User, ObjectId](collection  = MongoDBUtil.db("users")) with UserRepo