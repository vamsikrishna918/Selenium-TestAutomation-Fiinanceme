pipeline{
    agent any
     
    stages{
        stage("Test auomation Code checkout"){
            steps{
                git branch: 'main', url: 'https://github.com/vamsikrishna918/Selenium-TestAutomation-Financeme'
            }
        }
        stage("Executing jar"){
            steps{
                sh ' sudo java -jar seleniumAutomationFinanceme.jar'
            }
        }
        
    }
}
