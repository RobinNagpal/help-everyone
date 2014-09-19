package com.helpEveryone.resources

import akka.actor.ActorRefFactory
import com.helpEveryone.domain.HelpSeeker
import com.helpEveryone.mothers.DomainMother
import com.helpEveryone.resouces.HelpSeekersResource
import com.helpEveryone.service.HelpSeekersService
import org.bson.types.ObjectId
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest

import spray.httpx.SprayJsonSupport._
import com.helpEveryone.domain.HelpEveryoneJsonProtocol._

class HelpSeekersResourceSpecs extends Specification with Specs2RouteTest with Mockito with HelpSeekersResource {

  val service: HelpSeekersService = mock[HelpSeekersService]
  service.getAll() returns List(DomainMother.robinHelpSeeker)

  def helpSeekersService: HelpSeekersService = service

  def actorRefFactory: ActorRefFactory = system

  "HelpSeekersResource" should {

    "return list of all help seekers " in {

      Get("/help-seekers") ~> helpSeekersRoute ~> check {

        handled must beTrue
        val res = responseAs[List[HelpSeeker]]
        res  must be equalTo(List(DomainMother.robinHelpSeeker))

      }
    }

  }
}
