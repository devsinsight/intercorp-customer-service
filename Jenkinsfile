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
        sh 'mvn clean package docker:build'
      }
    }

    stage('Docker Push') {
      steps {
        sh 'aws ecr get-login-password --region us-west-1 | docker login --username AWS --password-stdin 843444704701.dkr.ecr.us-west-1.amazonaws.com'
      }
    }

  }
}