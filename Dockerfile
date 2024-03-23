# Use Ubuntu 20.04 as the base image
FROM ubuntu:20.04

# Install dependencies (fontconfig and OpenJDK 17 JRE)
RUN apt-get update && \
    apt-get install -y fontconfig openjdk-17-jre wget

# Add Jenkins repository key to the keyring
RUN wget -q -O /usr/share/keyrings/jenkins-keyring.asc \
    https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key

# Add Jenkins apt repository entry
RUN echo "deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] https://pkg.jenkins.io/debian-stable binary/" | \
    tee /etc/apt/sources.list.d/jenkins.list > /dev/null

# Update package index
RUN apt-get update

# Install Jenkins
RUN apt-get install -y jenkins

# Expose Jenkins default port
EXPOSE 8080

# Start Jenkins service
CMD ["/usr/sbin/service", "jenkins", "start"]