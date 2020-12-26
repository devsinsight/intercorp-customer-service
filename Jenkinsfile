pipeline {
  agent {
    docker {
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

    stage('Docker Build') {
      steps {
        sh 'mvn dockerfile:build'
      }
    }

    stage('Docker Push') {
      steps {
        sh 'mvn dockerfile:push'
      }
    }

  }
}