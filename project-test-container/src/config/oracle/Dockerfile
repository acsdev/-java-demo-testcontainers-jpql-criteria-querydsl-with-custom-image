FROM acsdev00/oracle-18-4-0-xe

ENV ORACLE_BASE=/opt/oracle
ENV ORACLE_SID=XE
ENV ORACLE_PDB=oracle
ENV ORACLE_PWD=oracle

VOLUME /opt/oracle/oradata

COPY sql/create.sql /opt/oracle/scripts/startup/create.sql
COPY sql/load.sql /opt/oracle/scripts/startup/load.sql

EXPOSE 8080 1521 5500