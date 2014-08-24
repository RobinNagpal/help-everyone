package com.helpEveryone.domain

import com.novus.salat.annotations.raw.Key
import org.bson.types.ObjectId


object HelpCategory extends Enumeration {
  type HelpCategory = Value
  val Study, Food, Health = Value
}


case class HelpSeeker(
                       @Key("_id") id: ObjectId,
                       name: String,
                       shortDesc: String,
                       longDesc: String,
                       totalHelpAmount: Double
                       )



