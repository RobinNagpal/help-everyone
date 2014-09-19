package com.helpEveryone.domain

import com.helpEveryone.domain.HelpEveryoneJsonProtocol._
import com.helpEveryone.mothers.{DomainJsonMother, DomainMother}
import org.bson.types.ObjectId
import org.specs2.mutable.Specification
import spray.json._

class SprayJsonSpecs extends Specification {


  "Spray Json " should {
    "be able to unmarshal List of Help Seekers " in {
      DomainJsonMother.helpSeekerListJsonString.parseJson.convertTo[List[HelpSeeker]] must beEqualTo(List(DomainMother.robinHelpSeeker))
    }

    "be able to marshal user to json" in {
      val robin = User(id = new ObjectId(),
        firstName = "Robin",
        lastName = "Nagpal",
        emailAddress = "robinnagpal@tiet.gmail",
        password = "test",
        roles = List(Roles.User, Roles.Admin)
      )

      val json: JsValue = robin.toJson
      json.compactPrint must contain("""roles":["User","Admin"]""")

    }
  }
}
