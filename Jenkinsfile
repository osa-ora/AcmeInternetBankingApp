pipeline {
  agent {
      label 'maven'
  }
  stages {
    stage('Build JAR') {
      steps {
        sh "mvn package"
        stash name:"jar", includes:"target/MyInternetBankingApp-1.0-SNAPSHOT.jar"
      }
    }
    stage('Build Image') {
      steps {
        unstash name:"jar"
        script {
          openshift.withCluster() {
            openshift.startBuild("my-gui-app", "--from-file=target/MyInternetBankingApp-1.0-SNAPSHOT.jar", "--wait")
          }
        }
      }
    }
    stage('Deploy') {
      steps {
        script {
          openshift.withCluster() {
            def dc = openshift.selector("dc", "my-gui-app")
            dc.rollout().latest()
            dc.rollout().status()
          }
        }
      }
    }
  }
}
