#!/bin/bash -e

if [[ $OSTYPE == "cygwin" ]] ; then
    PATHSEP=";"
else
    PATHSEP=":"
fi

#Make sure environment variables are properly set
if [ -e "$JAVA_HOME"/bin/java ] ; then
    if [ -f "$MCF_HOME"/properties.xml ] ; then
    
        # Build the classpath
        CLASSPATH=""
        for filename in $(ls -1 "$MCF_HOME"/documentum-registry-process/jar) ; do
            if [ -n "$CLASSPATH" ] ; then
                CLASSPATH="$CLASSPATH""$PATHSEP""$MCF_HOME"/documentum-registry-process/jar/"$filename"
            else
                CLASSPATH="$MCF_HOME"/documentum-registry-process/jar/"$filename"
            fi
        done
        
        "$JAVA_HOME/bin/java" -Xmx32m -Xms32m -cp "$CLASSPATH" org.apache.manifoldcf.crawler.registry.DCTM.DCTM
        exit $?
        
    else
        echo "Environment variable MCF_HOME is not properly set." 1>&2
        exit 1
    fi
    
else
    echo "Environment variable JAVA_HOME is not properly set." 1>&2
    exit 1
fi