package com.example

import akka.actor.{Props, ActorRef, ActorSystem}
import akka.io.IO
import com.helpEveryone.data.ApplicationData
import com.helpEveryone.repository.HelpSeekersRepoMongoImpl
import com.helpEveryone.resouces.{Env, BaseResource}
import com.helpEveryone.service.{HelpSeekerServiceImpl, HelpSeekersService}
import spray.can.Http

object Boot extends App {

  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("on-spray-can")


  val helpSeekersRepo = HelpSeekersRepoMongoImpl


  val applicationData = new ApplicationData(helpSeekersRepo)
  applicationData.saveHelpSeekers


  val env  = new Env {
    override def helpSeekerService: HelpSeekersService = new HelpSeekerServiceImpl(helpSeekersRepo)
  }
  // create and start our service actor

  val service: ActorRef = system.actorOf(Props( new BaseResource(env)))

  // start a new HTTP server on port 8080 with our service actor as the handler
  IO(Http) ! Http.Bind(service, interface = "localhost", port = 8080)



}