package com.helpEveryone.resouces

import akka.actor.Actor
import com.helpEveryone.service.HelpSeekersService
import spray.routing.HttpService
import spray.httpx.SprayJsonSupport._


trait HelpSeekersResource extends HttpService {
  import com.helpEveryone.domain.HelpEveryoneJsonProtocol._

  def helpSeekersService: HelpSeekersService

  val helpSeekersRoute =
    path("help-seekers") {
      get {
        complete {
          helpSeekersService.getAll()
        }
      }
    }

}



