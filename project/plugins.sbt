addSbtPlugin("org.scala-js"       % "sbt-scalajs"              % "0.6.28")
addSbtPlugin("org.portable-scala" % "sbt-crossproject"         % "0.6.1")
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "0.6.1")
addSbtPlugin("com.jsuereth"       % "sbt-pgp"                  % "1.1.2")
addSbtPlugin("com.typesafe.sbt"   % "sbt-ghpages"              % "0.6.3")
addSbtPlugin("com.typesafe.sbt"   % "sbt-site"                 % "1.3.3")
addSbtPlugin("org.scoverage"      % "sbt-scoverage"            % "1.6.0")
addSbtPlugin("com.typesafe.sbt"   % "sbt-git"                  % "1.0.0")
addSbtPlugin("org.xerial.sbt"     % "sbt-sonatype"             % "2.5")
addSbtPlugin("ohnosequences"      % "sbt-github-release"       % "0.7.0")
addSbtPlugin("com.eed3si9n"       % "sbt-buildinfo"            % "0.9.0")

resolvers += Resolver.url("sonatype", new URL("https://oss.sonatype.org/content/repositories/releases"))(Resolver.ivyStylePatterns)

// needed by sbt-github-release when building on JDK 11.
// reference: https://github.com/ohnosequences/sbt-github-release/issues/28
libraryDependencies += "com.sun.activation" % "javax.activation" % "1.2.0"
