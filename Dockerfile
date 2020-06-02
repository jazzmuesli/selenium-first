FROM ubuntu:latest

# Install.
RUN \
  sed -i 's/# \(.*multiverse$\)/\1/g' /etc/apt/sources.list && \
  apt-get update && \
  apt-get -y upgrade && \
  apt-get install -y build-essential && \
  apt-get install default-jre default-jdk maven -y && \
  apt-get install -y software-properties-common  && \
  apt-get install -y byobu curl git htop man unzip vim wget zip && \
  rm -rf /var/lib/apt/lists/*

RUN apt-get install -y maven
RUN apt-get install -y chromium-chromedriver

# Set environment variables.
ENV HOME /root

# Define working directory.
WORKDIR /root

