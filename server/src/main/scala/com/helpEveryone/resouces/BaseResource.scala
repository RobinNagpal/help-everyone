package com.helpEveryone.resouces

import akka.actor.Actor
import com.example.MyService
import com.helpEveryone.service.HelpSeekersService
import com.helpEveryone.domain.HelpEveryoneJsonProtocol._

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class BaseResource(injected : Env)  extends Actor with HelpSeekersResource with MyService{
  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(helpSeekersRoute ~ myRoute)

  override def helpSeekersService: HelpSeekersService = injected.helpSeekerService
}



trait Env {
    def helpSeekerService: HelpSeekersService
}
