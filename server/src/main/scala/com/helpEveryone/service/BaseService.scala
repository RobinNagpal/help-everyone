package com.helpEveryone.service

import com.mongodb.casbah.commons.MongoDBObject
import com.novus.salat.dao.SalatDAO
import org.bson.types.ObjectId


trait BaseService[T] {

  def get(id: ObjectId)

  def delete(id: ObjectId)

  def insert(t: T)

  def update(t: T)

  def getAll(): List[T]
}


class BaseServiceImpl[T <: AnyRef](dao: SalatDAO[T, ObjectId]) extends BaseService[T]{

  def get(id: ObjectId) = {

  }

  def delete(id: ObjectId) = {

  }

  def insert(t: T) = {
    dao.insert(t)
  }

  def update(t: T) = {

  }

  def getAll(): List[T] = {
    val list: List[T] = dao.find(MongoDBObject.empty).toList
    return list
  }
}
