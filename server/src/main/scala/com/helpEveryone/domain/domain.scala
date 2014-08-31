package com.helpEveryone.domain

import com.novus.salat.annotations._
import org.bson.types.ObjectId
import spray.json._


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



object HelpEveryoneJsonProtocol extends DefaultJsonProtocol {
  implicit object ApprovalStatusJsonFormat extends RootJsonFormat[ObjectId] {
    def write(obj: ObjectId): JsValue = JsString(obj.toString)

    def read(json: JsValue): ObjectId = json match {
      case JsString(str) => new ObjectId(str)
      case _ => throw new DeserializationException("Enum string expected")
    }
  }
  implicit val HelpSeekerFormat = jsonFormat5(HelpSeeker)
}


