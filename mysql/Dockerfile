FROM mysql:5.7.13
ENV VERSION=0.13.0
COPY replication.cnf /etc/mysql/conf.d
COPY schema-mysql.sql /docker-entrypoint-initdb.d
RUN chmod +r /etc/mysql/conf.d/replication.cnf /docker-entrypoint-initdb.d/schema-mysql.sql