package com.helpEveryone.resouces

import akka.actor.Actor
import com.helpEveryone.service.HelpSeekersService
import spray.http.MediaTypes._
import spray.routing.HttpService
import spray.httpx.SprayJsonSupport._
import spray.routing._
import spray.http._
import com.helpEveryone.domain.HelpEveryoneJsonProtocol._
trait HelpSeekersResource extends HttpService {


  def helpSeekersService: HelpSeekersService

  val helpSeekersRoute =
    path("help-seekers") {
      get {
        respondWithMediaType(`application/json`) {
          complete {
            helpSeekersService.getAll()
          }
        }
      }
    }

}



