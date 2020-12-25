pipeline {
  agent {
    docker {
      args '--network docker-jenkins_jenkinsnet'
      image 'openjdk:15'
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