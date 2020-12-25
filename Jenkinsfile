pipeline {
  agent {
    docker {
      args '--network docker-jenkins_jenkinsnet'
      image '3.6.3-openjdk-15'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }

  }
}