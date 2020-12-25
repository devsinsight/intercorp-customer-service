pipeline {
  agent {
    docker {
      args '--network docker-jenkins_jenkinsnet'
      image 'maven:3.6.3-openjdk-15'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }

  }
}