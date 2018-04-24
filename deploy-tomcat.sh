#!/usr/bin/env bash
rm -rf /usr/local/Cellar/tomcat/9.0.7/libexec/webapps/ROOT/
rm -rf /usr/local/Cellar/tomcat/9.0.7/libexec/webapps/ROOT.war
cp target/cargo-0.0.1-SNAPSHOT.war /usr/local/Cellar/tomcat/9.0.7/libexec/webapps/ROOT.war