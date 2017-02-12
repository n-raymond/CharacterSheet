FROM java:latest

ADD target/universal/tcard-1.0.tgz /

RUN rm -rf /tcard-1.0/bin/*.bat
RUN chown 1000:1000 /tcard-1.0/bin/tcard
RUN chmod +x /tcard-1.0/bin/tcard

WORKDIR /tcard-1.0/bin
CMD [ "./tcard"  ]
