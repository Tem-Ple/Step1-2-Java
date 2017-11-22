docker run --name='activemq' -it --rm \
    -e 'ACTIVEMQ_CONFIG_MINMEMORY=512' \
    -e 'ACTIVEMQ_CONFIG_MAXMEMORY=2048'\
    -P webcenter/activemq:latest
