#!/bin/sh
echo "Please Login to OCP using oc login ..... "  
echo "Press [Enter] key to resume..." 
read

oc new-project dev
oc new-app --name=my-gui-app jboss-webserver31-tomcat8-openshift:1.4~https://github.com/osa-ora/AcmeInternetBankingApp
oc apply -f https://raw.githubusercontent.com/osa-ora/AcmeInternetBankingApp/master/configs/configmap.yaml
oc expose service my-gui-app
echo "Please make sure the configmap 'env-settings' has the correct serverless local endpoints"  
echo "Press [Enter] key to resume..." 
read
oc set env deployment/my-gui-app --from configmap/env-settings
echo "Internet Banking GUI deployed successfully as a serverless" 
