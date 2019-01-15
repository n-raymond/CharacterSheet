FROM java:latest

ENV appName tcard
ENV appVersion 1.0
ENV appWithVersion ${appName}-${appVersion}

ADD target/universal/${appWithVersion}.zip .

RUN unzip ${appWithVersion}.zip

WORKDIR ${appWithVersion}/bin
RUN rm -rf *.bat
RUN chown 1000:1000 ${appName}
RUN chmod +x ${appName}

CMD ./${appName}
