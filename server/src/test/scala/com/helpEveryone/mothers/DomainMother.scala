package com.helpEveryone.mothers

import com.helpEveryone.domain.HelpSeeker
import org.bson.types.ObjectId


object DomainMother {
  val robinHelpSeeker = HelpSeeker(
    id = new ObjectId("540c69f744ae57368e9b5e87"),
    name = "Robin",
    shortDesc = "Short Desc",
    longDesc = "Long Desc",
    totalHelpAmount = 22.0
  )
}
