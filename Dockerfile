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

# We need wget to set up the PPA and xvfb to have a virtual screen and unzip to install the Chromedriver
RUN apt-get update
RUN apt-get install -y xvfb 

# Set up the Chrome PPA
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list

# Update the package list and install chrome
RUN apt-get update -y
RUN apt-get install -y google-chrome-stable

RUN apt -y install libgconf2-4


# https://askubuntu.com/questions/870530/how-to-install-geckodriver-in-ubuntu
RUN apt-get -y install jq

RUN apt-get -y install firefox

# Set up Chromedriver Environment variables
ENV CHROMEDRIVER_VERSION 83.0.4103.39 
ENV CHROMEDRIVER_DIR /chromedriver
RUN mkdir $CHROMEDRIVER_DIR

# Download and install Chromedriver
RUN wget -q --continue -P $CHROMEDRIVER_DIR "http://chromedriver.storage.googleapis.com/$CHROMEDRIVER_VERSION/chromedriver_linux64.zip"
RUN unzip $CHROMEDRIVER_DIR/chromedriver* -d $CHROMEDRIVER_DIR

# Put Chromedriver into the PATH
ENV PATH $CHROMEDRIVER_DIR:$PATH

#RUN apt-get install -y chromium-chromedriver

# Set environment variables.
ENV HOME /root

# Define working directory.
WORKDIR /root

COPY install_firefox.sh /root/
RUN /root/install_firefox.sh

COPY . . 
CMD ["bash"]
