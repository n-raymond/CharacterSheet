FROM java:latest

ENV appName tcard
ENV appVersion 1.0
ENV appWithVersion ${appName}-${appVersion}

ADD target/universal/${appWithVersion}.tgz /

RUN rm -rf /${appWithVersion}/bin/*.bat
RUN chown 1000:1000 /${appWithVersion}/bin/${appName}
RUN chmod +x /${appWithVersion}/bin/${appName}

WORKDIR /${appWithVersion}/bin
CMD ./${appName}
