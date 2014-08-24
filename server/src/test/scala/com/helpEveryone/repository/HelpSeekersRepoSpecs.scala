package com.helpEveryone.repository

import com.helpEveryone.domain.HelpSeeker
import com.mongodb.casbah.Imports._
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

class HelpSeekersRepoSpecs extends Specification {

  val helpSeekerRepo: HelpSeekersRepo = HelpSeekersRepoMongoImpl

  "HelpSeekersRepo " should {
    " save help seeker in DB " in new CleanHelpSeekerContext {
      val helSeeker = HelpSeeker(
        id = new ObjectId(),
        name = "Robin",
        shortDesc = "Money for Study",
        longDesc = "Money for Strude Long",
        totalHelpAmount = 1000.0
      )
      helpSeekerRepo.insert(helSeeker)
      HelpSeekersRepoMongoImpl.count() should beEqualTo(1)
    }
  }


  trait CleanHelpSeekerContext extends Scope {
    helpSeekerRepo.collection.drop()
  }


}
