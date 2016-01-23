import akka.actor.Props
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import rest.RoutesActor
import spray.can.Http
import utils.{ActorModuleImpl, ConfigurationModuleImpl}

import scala.concurrent.duration._

object Boot extends App {

  val modules = new ConfigurationModuleImpl with ActorModuleImpl

  val service = modules.system.actorOf(Props(classOf[RoutesActor], modules), "routesActor")

  implicit val system = modules.system
  implicit val timeout = Timeout(5.seconds)

  IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)

}
