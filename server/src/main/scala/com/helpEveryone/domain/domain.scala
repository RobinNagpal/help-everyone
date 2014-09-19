package com.helpEveryone.domain

import com.novus.salat.annotations._
import org.bson.types.ObjectId
import spray.json._


object HelpCategory extends Enumeration {
  type HelpCategory = Value
  val Study, Food, Health = Value
}


object Roles extends Enumeration {
  type Roles = Value
  val User, ContentManager, Admin = Value
}


case class HelpSeeker(
                       @Key("_id") id: ObjectId,
                       name: String,
                       shortDesc: String,
                       longDesc: String,
                       totalHelpAmount: Double
                       )

case class User(
                 @Key("_id") id: ObjectId,
                 firstName: String,
                 lastName: String,
                 emailAddress: String,
                 password: String,
                 roles: List[Roles.Roles] = List(Roles.User)
                 )


object HelpEveryoneJsonProtocol extends DefaultJsonProtocol {

  implicit object ObjectIdJsonFormat extends JsonFormat[ObjectId] {
    def write(obj: ObjectId): JsValue = JsString(obj.toString)

    def read(json: JsValue): ObjectId = json match {
      case JsString(str) => new ObjectId(str)
      case _ => throw new DeserializationException("ObjectId string expected")
    }
  }

  implicit object RolesJsonFormat extends JsonFormat[Roles.Value] {
    def write(obj: Roles.Value): JsValue = JsString(obj.toString)

    def read(json: JsValue): Roles.Value = json match {
      case JsString(str) => Roles.withName(str)
      case _ => throw new DeserializationException("Enum string expected")
    }
  }


  implicit val HelpSeekerJsonFormat = jsonFormat5(HelpSeeker)
  implicit val UserJsonFormat = jsonFormat6(User)

  /* implicit object HelpSeekerJsonFormat extends RootJsonFormat[HelpSeeker] {
    def write(c: HelpSeeker) = JsObject(
      "id" -> JsString(c.id.toString),
      "name" -> JsString(c.name),
      "shortDesc" -> JsString(c.shortDesc),
      "longDesc" -> JsString(c.longDesc),
      "totalHelpAmount" -> JsNumber(c.totalHelpAmount)
    )

    def read(value: JsValue) = {
      value.asJsObject.getFields("id", "name", "shortDesc", "longDesc", "totalHelpAmount") match {
        case Seq(JsString(id), JsString(name), JsString(shortDesc), JsString(longDesc), JsNumber(totalHelpAmount)) =>
          HelpSeeker(id = new ObjectId(id), name = name, shortDesc = shortDesc, longDesc = longDesc, totalHelpAmount = totalHelpAmount.toDouble)
        case _ => throw new DeserializationException("HelpSeeker expected")
      }
    }
  }

  implicit object UserJsonFormat extends RootJsonFormat[User] {
    def write(c: User) = JsObject(
      "id" -> JsString(c.id.toString),
      "firstName" -> JsString(c.firstName),
      "lastName" -> JsString(c.lastName),
      "emailAddress" -> JsString(c.emailAddress),
      "roles" -> JsArray(c.roles.map { role => JsString(role.toString)})
    )

    def read(value: JsValue) = ???
  }
     */
}


