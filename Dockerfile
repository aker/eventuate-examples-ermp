FROM java:openjdk-8u91-jdk
CMD java ${JAVA_OPTS} -jar eventuate-examples-ermp.jar
COPY build/libs/eventuate-examples-ermp.jar .