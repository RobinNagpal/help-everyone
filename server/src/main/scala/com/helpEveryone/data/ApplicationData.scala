package com.helpEveryone.data

import com.helpEveryone.domain.HelpSeeker
import com.helpEveryone.repository.HelpSeekersRepo
import org.bson.types.ObjectId


class ApplicationData(
                       helpSeekersRepo: HelpSeekersRepo
                       ) {

  def saveHelpSeekers = {
    helpSeekersRepo.collection.drop()

    val ram = HelpSeeker(
      id = new ObjectId(),
      name = "Ram",
      shortDesc = "Help Ram with Stationary",
      longDesc =
        """Ram belongs to a poor family and he is doing really well in studies.
         Please contribute some money so that he can buy some basic stuff for him.
        """.stripMargin,
      totalHelpAmount = 10
    )
    helpSeekersRepo.insert(ram)
  }

}
