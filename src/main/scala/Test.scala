import java.net.{HttpURLConnection, URL}
import java.security.Security

import org.bouncycastle.jce.provider.BouncyCastleProvider

object Test {
  def main(args: Array[String]): Unit = {

    Security.addProvider(new BouncyCastleProvider())

    val url = args match {
      case Array("--https") =>
        "https://repo1.maven.org/maven2/io/get-coursier/coursier_2.13/2.0.0-RC2-6/coursier_2.13-2.0.0-RC2-6.pom"
      case Array(url0) => url0
      case _ =>
        "http://repo1.maven.org/maven2/io/get-coursier/coursier_2.13/2.0.0-RC2-6/coursier_2.13-2.0.0-RC2-6.pom"
    }
    val url0 = new URL(url)
    val conn = url0.openConnection().asInstanceOf[HttpURLConnection]
    val respCode = conn.getResponseCode
    System.err.println(s"Response code: $respCode")
  }
}
