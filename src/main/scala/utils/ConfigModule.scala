package utils

import java.io.File

import com.typesafe.config.{ConfigFactory, Config}

trait Configuration {

  def config: Config

}

class ConfigurationModuleImpl extends Configuration {

  private val internalConfig: Config = {
    val configDefaults = ConfigFactory.load(this.getClass().getClassLoader(), "application.conf")

    scala.sys.props.get("application.config") match {
      case Some(filename) => ConfigFactory.parseFile(new File(filename)).withFallback(configDefaults)
      case None => configDefaults
    }
  }

  def config = internalConfig

}
