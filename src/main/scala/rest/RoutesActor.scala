package rest

import akka.actor.{Actor, ActorRefFactory}
import spray.routing.HttpService
import utils.Configuration

class RoutesActor(modules: Configuration) extends Actor with HttpService {

  val spraySampleRoute = {
    path("test") {
      get {
        complete("hello world")
      }
    }
  }

  def actorRefFactory: ActorRefFactory = context

  def receive: Receive = runRoute(spraySampleRoute)

}
