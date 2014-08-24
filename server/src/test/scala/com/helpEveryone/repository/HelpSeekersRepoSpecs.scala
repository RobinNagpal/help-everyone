package com.helpEveryone.repository

import com.helpEveryone.domain.HelpSeeker
import org.specs2.mutable.Specification
import com.novus.salat._
import com.novus.salat.global._
import com.novus.salat.annotations._
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._

class HelpSeekersRepoSpecs extends Specification {
  "HelpSeekersRepo " should {
    val helpSeekerRepo : HelpSeekersRepo = HelpSeekersRepoMongoImpl

    " save help seeker in DB " in {
      val helSeeker = HelpSeeker(
        id = new ObjectId(),
        name = "Robin",
        shortDesc = "Money for Study",
        longDesc = "Money for Strude Long",
        totalHelpAmount = 1000.0
      )

      helpSeekerRepo.insert(helSeeker);

      HelpSeekersRepoMongoImpl.count() should beEqualTo(6)
    }
  }

}
