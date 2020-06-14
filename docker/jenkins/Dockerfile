FROM jenkins/jenkins:lts

USER root
# Install JDK-11
RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys 0xB1998361219BD9C9
RUN echo "deb http://repos.azulsystems.com/debian stable main" | tee /etc/apt/sources.list.d/zulu.list
RUN apt update && apt install -y zulu-11

# Install Maven 3.6
RUN wget -O maven.tgz https://www-eu.apache.org/dist/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
RUN tar -xzf maven.tgz && rm maven.tgz* && mv apache-maven* /opt/maven
RUN echo "export PATH=$PATH:/opt/maven/apache-maven-3.6.3/bin" >> /etc/profile

# set Jenkins env:
# JAVA_HOME: /usr/lib/jvm/zulu-11-amd64
# MAVEN_HOME: /opt/maven/apache-maven-3.6.3

USER jenkins