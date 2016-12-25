#!/bin/sh

postgres -D /usr/local/pgsql/data >logs/psql.log 2>&1 &
